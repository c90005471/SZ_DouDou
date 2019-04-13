package com.ruoyi.project.system.mydept.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 测试部门表 mydept
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public class Mydept extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 部门编号 */
	private Integer deptno;
	/** 部门名称 */
	private String dname;
	/** 部门位置 */
	private String loc;

	public void setDeptno(Integer deptno) 
	{
		this.deptno = deptno;
	}

	public Integer getDeptno() 
	{
		return deptno;
	}
	public void setDname(String dname) 
	{
		this.dname = dname;
	}

	public String getDname() 
	{
		return dname;
	}
	public void setLoc(String loc) 
	{
		this.loc = loc;
	}

	public String getLoc() 
	{
		return loc;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptno", getDeptno())
            .append("dname", getDname())
            .append("loc", getLoc())
            .toString();
    }
}
