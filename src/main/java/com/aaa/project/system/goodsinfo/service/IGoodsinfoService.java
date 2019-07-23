package com.aaa.project.system.goodsinfo.service;

import com.aaa.project.system.goodsinfo.domain.Goodsinfo;
import java.util.List;

/**
 * 商品 服务层
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
public interface IGoodsinfoService 
{
	/**
     * 查询商品信息
     * 
     * @param goodsId 商品ID
     * @return 商品信息
     */
	public Goodsinfo selectGoodsinfoById(Integer goodsId);
	
	/**
     * 查询商品列表
     * 
     * @param goodsinfo 商品信息
     * @return 商品集合
     */
	public List<Goodsinfo> selectGoodsinfoList(Goodsinfo goodsinfo);
	
	/**
     * 新增商品
     * 
     * @param goodsinfo 商品信息
     * @return 结果
     */
	public int insertGoodsinfo(Goodsinfo goodsinfo);
	
	/**
     * 修改商品
     * 
     * @param goodsinfo 商品信息
     * @return 结果
     */
	public int updateGoodsinfo(Goodsinfo goodsinfo);
		
	/**
     * 删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGoodsinfoByIds(String ids);
	
}
