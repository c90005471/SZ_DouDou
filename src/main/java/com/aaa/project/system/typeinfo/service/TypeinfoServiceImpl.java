package com.aaa.project.system.typeinfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.typeinfo.mapper.TypeinfoMapper;
import com.aaa.project.system.typeinfo.domain.Typeinfo;
import com.aaa.project.system.typeinfo.service.ITypeinfoService;
import com.aaa.common.support.Convert;

/**
 * 类型 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
@Service
public class TypeinfoServiceImpl implements ITypeinfoService 
{
	@Autowired
	private TypeinfoMapper typeinfoMapper;

	/**
     * 查询类型信息
     * 
     * @param typeId 类型ID
     * @return 类型信息
     */
    @Override
	public Typeinfo selectTypeinfoById(Integer typeId)
	{
	    return typeinfoMapper.selectTypeinfoById(typeId);
	}
	
	/**
     * 查询类型列表
     * 
     * @param typeinfo 类型信息
     * @return 类型集合
     */
	@Override
	public List<Typeinfo> selectTypeinfoList(Typeinfo typeinfo)
	{
	    return typeinfoMapper.selectTypeinfoList(typeinfo);
	}
	
    /**
     * 新增类型
     * 
     * @param typeinfo 类型信息
     * @return 结果
     */
	@Override
	public int insertTypeinfo(Typeinfo typeinfo)
	{
	    return typeinfoMapper.insertTypeinfo(typeinfo);
	}
	
	/**
     * 修改类型
     * 
     * @param typeinfo 类型信息
     * @return 结果
     */
	@Override
	public int updateTypeinfo(Typeinfo typeinfo)
	{
	    return typeinfoMapper.updateTypeinfo(typeinfo);
	}

	/**
     * 删除类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTypeinfoByIds(String ids)
	{
		return typeinfoMapper.deleteTypeinfoByIds(Convert.toStrArray(ids));
	}
	
}
