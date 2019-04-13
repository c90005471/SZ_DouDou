package com.ruoyi.project.system.mydept.service;

import com.ruoyi.project.system.mydept.domain.Mydept;
import java.util.List;

/**
 * 测试部门 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IMydeptService 
{
	/**
     * 查询测试部门信息
     * 
     * @param deptno 测试部门ID
     * @return 测试部门信息
     */
	public Mydept selectMydeptById(Integer deptno);
	
	/**
     * 查询测试部门列表
     * 
     * @param mydept 测试部门信息
     * @return 测试部门集合
     */
	public List<Mydept> selectMydeptList(Mydept mydept);
	
	/**
     * 新增测试部门
     * 
     * @param mydept 测试部门信息
     * @return 结果
     */
	public int insertMydept(Mydept mydept);
	
	/**
     * 修改测试部门
     * 
     * @param mydept 测试部门信息
     * @return 结果
     */
	public int updateMydept(Mydept mydept);
		
	/**
     * 删除测试部门信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMydeptByIds(String ids);
	
}
