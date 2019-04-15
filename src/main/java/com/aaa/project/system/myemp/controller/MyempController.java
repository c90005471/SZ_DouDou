package com.aaa.project.system.myemp.controller;

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
import com.aaa.project.system.myemp.domain.Myemp;
import com.aaa.project.system.myemp.service.IMyempService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 测试员工 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-15
 */
@Controller
@RequestMapping("/system/myemp")
public class MyempController extends BaseController
{
    private String prefix = "system/myemp";
	
	@Autowired
	private IMyempService myempService;
	
	@RequiresPermissions("system:myemp:view")
	@GetMapping()
	public String myemp()
	{
	    return prefix + "/myemp";
	}
	
	/**
	 * 查询测试员工列表
	 */
	@RequiresPermissions("system:myemp:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Myemp myemp)
	{
		startPage();
        List<Myemp> list = myempService.selectMyempList(myemp);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出测试员工列表
	 */
	@RequiresPermissions("system:myemp:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Myemp myemp)
    {
    	List<Myemp> list = myempService.selectMyempList(myemp);
        ExcelUtil<Myemp> util = new ExcelUtil<Myemp>(Myemp.class);
        return util.exportExcel(list, "myemp");
    }
	
	/**
	 * 新增测试员工
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存测试员工
	 */
	@RequiresPermissions("system:myemp:add")
	@Log(title = "测试员工", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Myemp myemp)
	{		
		return toAjax(myempService.insertMyemp(myemp));
	}

	/**
	 * 修改测试员工
	 */
	@GetMapping("/edit/{empno}")
	public String edit(@PathVariable("empno") Integer empno, ModelMap mmap)
	{
		Myemp myemp = myempService.selectMyempById(empno);
		mmap.put("myemp", myemp);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存测试员工
	 */
	@RequiresPermissions("system:myemp:edit")
	@Log(title = "测试员工", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Myemp myemp)
	{		
		return toAjax(myempService.updateMyemp(myemp));
	}
	
	/**
	 * 删除测试员工
	 */
	@RequiresPermissions("system:myemp:remove")
	@Log(title = "测试员工", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(myempService.deleteMyempByIds(ids));
	}
	
}
