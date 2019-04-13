package com.ruoyi.project.system.myemp.service;

import com.ruoyi.project.system.myemp.domain.Myemp;
import java.util.List;

/**
 * 测试员工 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IMyempService 
{
	/**
     * 查询测试员工信息
     * 
     * @param empno 测试员工ID
     * @return 测试员工信息
     */
	public Myemp selectMyempById(Integer empno);
	
	/**
     * 查询测试员工列表
     * 
     * @param myemp 测试员工信息
     * @return 测试员工集合
     */
	public List<Myemp> selectMyempList(Myemp myemp);
	
	/**
     * 新增测试员工
     * 
     * @param myemp 测试员工信息
     * @return 结果
     */
	public int insertMyemp(Myemp myemp);
	
	/**
     * 修改测试员工
     * 
     * @param myemp 测试员工信息
     * @return 结果
     */
	public int updateMyemp(Myemp myemp);
		
	/**
     * 删除测试员工信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMyempByIds(String ids);
	
}
