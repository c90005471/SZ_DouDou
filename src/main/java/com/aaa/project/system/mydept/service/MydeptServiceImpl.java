package com.aaa.project.system.mydept.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.mydept.mapper.MydeptMapper;
import com.aaa.project.system.mydept.domain.Mydept;
import com.aaa.project.system.mydept.service.IMydeptService;
import com.aaa.common.support.Convert;

/**
 * 测试部门 服务层实现
 * 
 * @author teacherChen
 * @date 2019-04-12
 */
@Service
public class MydeptServiceImpl implements IMydeptService 
{
	@Autowired
	private MydeptMapper mydeptMapper;

	/**
     * 查询测试部门信息
     * 
     * @param deptno 测试部门ID
     * @return 测试部门信息
     */
    @Override
	public Mydept selectMydeptById(Integer deptno)
	{
	    return mydeptMapper.selectMydeptById(deptno);
	}
	
	/**
     * 查询测试部门列表
     * 
     * @param mydept 测试部门信息
     * @return 测试部门集合
     */
	@Override
	public List<Mydept> selectMydeptList(Mydept mydept)
	{
	    return mydeptMapper.selectMydeptList(mydept);
	}
	
    /**
     * 新增测试部门
     * 
     * @param mydept 测试部门信息
     * @return 结果
     */
	@Override
	public int insertMydept(Mydept mydept)
	{
	    return mydeptMapper.insertMydept(mydept);
	}
	
	/**
     * 修改测试部门
     * 
     * @param mydept 测试部门信息
     * @return 结果
     */
	@Override
	public int updateMydept(Mydept mydept)
	{
	    return mydeptMapper.updateMydept(mydept);
	}

	/**
     * 删除测试部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMydeptByIds(String ids)
	{
		return mydeptMapper.deleteMydeptByIds(Convert.toStrArray(ids));
	}
	
}
