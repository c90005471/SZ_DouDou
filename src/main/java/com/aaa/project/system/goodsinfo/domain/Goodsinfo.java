package com.aaa.project.system.goodsinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 商品表 goodsinfo
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
public class Goodsinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 商品编号 */
	private Integer goodsId;
	/** 商品名称 */
	private String goodsName;
	/** 商品种类 */
	private Integer goodsType;
	/** 商品规格 */
	private String goodsSpec;
	/** 商品价格 */
	private Float goodsPrice;
	/** 建账时间 */
	private Date goodsDate;

	public void setGoodsId(Integer goodsId) 
	{
		this.goodsId = goodsId;
	}

	public Integer getGoodsId() 
	{
		return goodsId;
	}
	public void setGoodsName(String goodsName) 
	{
		this.goodsName = goodsName;
	}

	public String getGoodsName() 
	{
		return goodsName;
	}
	public void setGoodsType(Integer goodsType) 
	{
		this.goodsType = goodsType;
	}

	public Integer getGoodsType() 
	{
		return goodsType;
	}
	public void setGoodsSpec(String goodsSpec) 
	{
		this.goodsSpec = goodsSpec;
	}

	public String getGoodsSpec() 
	{
		return goodsSpec;
	}
	public void setGoodsPrice(Float goodsPrice) 
	{
		this.goodsPrice = goodsPrice;
	}

	public Float getGoodsPrice() 
	{
		return goodsPrice;
	}
	public void setGoodsDate(Date goodsDate) 
	{
		this.goodsDate = goodsDate;
	}

	public Date getGoodsDate() 
	{
		return goodsDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("goodsType", getGoodsType())
            .append("goodsSpec", getGoodsSpec())
            .append("goodsPrice", getGoodsPrice())
            .append("goodsDate", getGoodsDate())
            .toString();
    }
}
