package com.aaa.project.system.goodsinfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.goodsinfo.mapper.GoodsinfoMapper;
import com.aaa.project.system.goodsinfo.domain.Goodsinfo;
import com.aaa.project.system.goodsinfo.service.IGoodsinfoService;
import com.aaa.common.support.Convert;

/**
 * 商品 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
@Service
public class GoodsinfoServiceImpl implements IGoodsinfoService 
{
	@Autowired
	private GoodsinfoMapper goodsinfoMapper;

	/**
     * 查询商品信息
     * 
     * @param goodsId 商品ID
     * @return 商品信息
     */
    @Override
	public Goodsinfo selectGoodsinfoById(Integer goodsId)
	{
	    return goodsinfoMapper.selectGoodsinfoById(goodsId);
	}
	
	/**
     * 查询商品列表
     * 
     * @param goodsinfo 商品信息
     * @return 商品集合
     */
	@Override
	public List<Goodsinfo> selectGoodsinfoList(Goodsinfo goodsinfo)
	{
	    return goodsinfoMapper.selectGoodsinfoList(goodsinfo);
	}
	
    /**
     * 新增商品
     * 
     * @param goodsinfo 商品信息
     * @return 结果
     */
	@Override
	public int insertGoodsinfo(Goodsinfo goodsinfo)
	{
	    return goodsinfoMapper.insertGoodsinfo(goodsinfo);
	}
	
	/**
     * 修改商品
     * 
     * @param goodsinfo 商品信息
     * @return 结果
     */
	@Override
	public int updateGoodsinfo(Goodsinfo goodsinfo)
	{
	    return goodsinfoMapper.updateGoodsinfo(goodsinfo);
	}

	/**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGoodsinfoByIds(String ids)
	{
		return goodsinfoMapper.deleteGoodsinfoByIds(Convert.toStrArray(ids));
	}
	
}
