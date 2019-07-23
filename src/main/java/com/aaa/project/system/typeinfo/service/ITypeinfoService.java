package com.aaa.project.system.typeinfo.service;

import com.aaa.project.system.typeinfo.domain.Typeinfo;
import java.util.List;

/**
 * 类型 服务层
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
public interface ITypeinfoService 
{
	/**
     * 查询类型信息
     * 
     * @param typeId 类型ID
     * @return 类型信息
     */
	public Typeinfo selectTypeinfoById(Integer typeId);
	
	/**
     * 查询类型列表
     * 
     * @param typeinfo 类型信息
     * @return 类型集合
     */
	public List<Typeinfo> selectTypeinfoList(Typeinfo typeinfo);
	
	/**
     * 新增类型
     * 
     * @param typeinfo 类型信息
     * @return 结果
     */
	public int insertTypeinfo(Typeinfo typeinfo);
	
	/**
     * 修改类型
     * 
     * @param typeinfo 类型信息
     * @return 结果
     */
	public int updateTypeinfo(Typeinfo typeinfo);
		
	/**
     * 删除类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTypeinfoByIds(String ids);
	
}
