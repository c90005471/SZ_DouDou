package com.aaa.project.system.goodsinfo.controller;

import java.util.List;

import com.aaa.project.system.typeinfo.domain.Typeinfo;
import com.aaa.project.system.typeinfo.service.ITypeinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.goodsinfo.domain.Goodsinfo;
import com.aaa.project.system.goodsinfo.service.IGoodsinfoService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 商品 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
@Controller
@RequestMapping("/system/goodsinfo")
public class GoodsinfoController extends BaseController
{
    private String prefix = "system/goodsinfo";
	
	@Autowired
	private IGoodsinfoService goodsinfoService;
	@Autowired
	private ITypeinfoService typeinfoService;
	
	@RequiresPermissions("system:goodsinfo:view")
	@GetMapping()
	public String goodsinfo()
	{
	    return prefix + "/goodsinfo";
	}
	
	/**
	 * 查询商品列表
	 */
	@RequiresPermissions("system:goodsinfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Goodsinfo goodsinfo)
	{
		startPage();
        List<Goodsinfo> list = goodsinfoService.selectGoodsinfoList(goodsinfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品列表
	 */
	@RequiresPermissions("system:goodsinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Goodsinfo goodsinfo)
    {
    	List<Goodsinfo> list = goodsinfoService.selectGoodsinfoList(goodsinfo);
        ExcelUtil<Goodsinfo> util = new ExcelUtil<Goodsinfo>(Goodsinfo.class);
        return util.exportExcel(list, "goodsinfo");
    }
	
	/**
	 * 新增商品
	 */
	@GetMapping("/add")
	public String add(Model model)
	{
		//查询所有的商品类型保存goodsTypes到model中
		List<Typeinfo> typeinfoList = typeinfoService.selectTypeinfoList(null);
		System.out.println(typeinfoList.size()+"=========================");
		model.addAttribute("goodsTypes",typeinfoList);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存商品
	 */
	@RequiresPermissions("system:goodsinfo:add")
	@Log(title = "商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Goodsinfo goodsinfo)
	{		
		return toAjax(goodsinfoService.insertGoodsinfo(goodsinfo));
	}

	/**
	 * 修改商品
	 */
	@GetMapping("/edit/{goodsId}")
	public String edit(@PathVariable("goodsId") Integer goodsId, ModelMap mmap)
	{
		Goodsinfo goodsinfo = goodsinfoService.selectGoodsinfoById(goodsId);
		mmap.put("goodsinfo", goodsinfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品
	 */
	@RequiresPermissions("system:goodsinfo:edit")
	@Log(title = "商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Goodsinfo goodsinfo)
	{		
		return toAjax(goodsinfoService.updateGoodsinfo(goodsinfo));
	}
	
	/**
	 * 删除商品
	 */
	@RequiresPermissions("system:goodsinfo:remove")
	@Log(title = "商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(goodsinfoService.deleteGoodsinfoByIds(ids));
	}
	
}
