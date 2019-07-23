package com.aaa.project.system.typeinfo.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.typeinfo.domain.Typeinfo;
import com.aaa.project.system.typeinfo.service.ITypeinfoService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 类型 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
@Controller
@RequestMapping("/system/typeinfo")
public class TypeinfoController extends BaseController
{
    private String prefix = "system/typeinfo";
	
	@Autowired
	private ITypeinfoService typeinfoService;
	
	@RequiresPermissions("system:typeinfo:view")
	@GetMapping()
	public String typeinfo()
	{
	    return prefix + "/typeinfo";
	}
	
	/**
	 * 查询类型列表
	 */
	@RequiresPermissions("system:typeinfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Typeinfo typeinfo)
	{
		startPage();
        List<Typeinfo> list = typeinfoService.selectTypeinfoList(typeinfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出类型列表
	 */
	@RequiresPermissions("system:typeinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Typeinfo typeinfo)
    {
    	List<Typeinfo> list = typeinfoService.selectTypeinfoList(typeinfo);
        ExcelUtil<Typeinfo> util = new ExcelUtil<Typeinfo>(Typeinfo.class);
        return util.exportExcel(list, "typeinfo");
    }
	
	/**
	 * 新增类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存类型
	 */
	@RequiresPermissions("system:typeinfo:add")
	@Log(title = "类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Typeinfo typeinfo)
	{		
		return toAjax(typeinfoService.insertTypeinfo(typeinfo));
	}

	/**
	 * 修改类型
	 */
	@GetMapping("/edit/{typeId}")
	public String edit(@PathVariable("typeId") Integer typeId, ModelMap mmap)
	{
		Typeinfo typeinfo = typeinfoService.selectTypeinfoById(typeId);
		mmap.put("typeinfo", typeinfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存类型
	 */
	@RequiresPermissions("system:typeinfo:edit")
	@Log(title = "类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Typeinfo typeinfo)
	{		
		return toAjax(typeinfoService.updateTypeinfo(typeinfo));
	}
	
	/**
	 * 删除类型
	 */
	@RequiresPermissions("system:typeinfo:remove")
	@Log(title = "类型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(typeinfoService.deleteTypeinfoByIds(ids));
	}
	
}
