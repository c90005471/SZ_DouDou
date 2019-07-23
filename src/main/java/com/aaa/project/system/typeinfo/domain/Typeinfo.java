package com.aaa.project.system.typeinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 类型表 typeinfo
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
public class Typeinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 种类编号 */
	private Integer typeId;
	/** 种类名称 */
	private String typeName;

	public void setTypeId(Integer typeId) 
	{
		this.typeId = typeId;
	}

	public Integer getTypeId() 
	{
		return typeId;
	}
	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}

	public String getTypeName() 
	{
		return typeName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("typeId", getTypeId())
            .append("typeName", getTypeName())
            .toString();
    }
}
