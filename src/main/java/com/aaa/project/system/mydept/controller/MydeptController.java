package com.aaa.project.system.mydept.controller;

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
import com.aaa.project.system.mydept.domain.Mydept;
import com.aaa.project.system.mydept.service.IMydeptService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 测试部门 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/mydept")
public class MydeptController extends BaseController
{
    private String prefix = "system/mydept";
	
	@Autowired
	private IMydeptService mydeptService;
	
	@RequiresPermissions("system:mydept:view")
	@GetMapping()
	public String mydept()
	{
	    return prefix + "/mydept";
	}
	
	/**
	 * 查询测试部门列表
	 */
	@RequiresPermissions("system:mydept:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Mydept mydept)
	{
		startPage();
        List<Mydept> list = mydeptService.selectMydeptList(mydept);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出测试部门列表
	 */
	@RequiresPermissions("system:mydept:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Mydept mydept)
    {
    	List<Mydept> list = mydeptService.selectMydeptList(mydept);
        ExcelUtil<Mydept> util = new ExcelUtil<Mydept>(Mydept.class);
        return util.exportExcel(list, "mydept");
    }
	
	/**
	 * 新增测试部门
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存测试部门
	 */
	@RequiresPermissions("system:mydept:add")
	@Log(title = "测试部门", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Mydept mydept)
	{		
		return toAjax(mydeptService.insertMydept(mydept));
	}

	/**
	 * 修改测试部门
	 */
	@GetMapping("/edit/{deptno}")
	public String edit(@PathVariable("deptno") Integer deptno, ModelMap mmap)
	{
		Mydept mydept = mydeptService.selectMydeptById(deptno);
		mmap.put("mydept", mydept);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存测试部门
	 */
	@RequiresPermissions("system:mydept:edit")
	@Log(title = "测试部门", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Mydept mydept)
	{		
		return toAjax(mydeptService.updateMydept(mydept));
	}
	
	/**
	 * 删除测试部门
	 */
	@RequiresPermissions("system:mydept:remove")
	@Log(title = "测试部门", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(mydeptService.deleteMydeptByIds(ids));
	}
	
}
