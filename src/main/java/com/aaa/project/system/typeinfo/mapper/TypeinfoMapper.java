package com.aaa.project.system.typeinfo.mapper;

import com.aaa.project.system.typeinfo.domain.Typeinfo;
import java.util.List;	

/**
 * 类型 数据层
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
public interface TypeinfoMapper 
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
     * 删除类型
     * 
     * @param typeId 类型ID
     * @return 结果
     */
	public int deleteTypeinfoById(Integer typeId);
	
	/**
     * 批量删除类型
     * 
     * @param typeIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTypeinfoByIds(String[] typeIds);
	
}