package com.aaa.project.system.myemp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.myemp.mapper.MyempMapper;
import com.aaa.project.system.myemp.domain.Myemp;
import com.aaa.project.system.myemp.service.IMyempService;
import com.aaa.common.support.Convert;

/**
 * 测试员工 服务层实现
 * 
 * @author aaa
 * @date 2019-04-15
 */
@Service
public class MyempServiceImpl implements IMyempService 
{
	@Autowired
	private MyempMapper myempMapper;

	/**
     * 查询测试员工信息
     * 
     * @param empno 测试员工ID
     * @return 测试员工信息
     */
    @Override
	public Myemp selectMyempById(Integer empno)
	{
	    return myempMapper.selectMyempById(empno);
	}
	
	/**
     * 查询测试员工列表
     * 
     * @param myemp 测试员工信息
     * @return 测试员工集合
     */
	@Override
	public List<Myemp> selectMyempList(Myemp myemp)
	{
	    return myempMapper.selectMyempList(myemp);
	}
	
    /**
     * 新增测试员工
     * 
     * @param myemp 测试员工信息
     * @return 结果
     */
	@Override
	public int insertMyemp(Myemp myemp)
	{
	    return myempMapper.insertMyemp(myemp);
	}
	
	/**
     * 修改测试员工
     * 
     * @param myemp 测试员工信息
     * @return 结果
     */
	@Override
	public int updateMyemp(Myemp myemp)
	{
	    return myempMapper.updateMyemp(myemp);
	}

	/**
     * 删除测试员工对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMyempByIds(String ids)
	{
		return myempMapper.deleteMyempByIds(Convert.toStrArray(ids));
	}
	
}
