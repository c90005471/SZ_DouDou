package com.aaa.project.system.myemp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 测试员工表 myemp
 * 
 * @author aaa
 * @date 2019-04-15
 */
public class Myemp extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 员工编号 */
	private Integer empno;
	/** 员工姓名 */
	private String ename;
	/** 上级 */
	private Integer mgr;
	/** 岗位 */
	private String job;
	/** 工资 */
	private Float sal;
	/** 奖金 */
	private Float comm;
	/** 日志日期 */
	private Date hiredate;
	/** 部门编号 */
	private Integer deptno;

	public void setEmpno(Integer empno) 
	{
		this.empno = empno;
	}

	public Integer getEmpno() 
	{
		return empno;
	}
	public void setEname(String ename) 
	{
		this.ename = ename;
	}

	public String getEname() 
	{
		return ename;
	}
	public void setMgr(Integer mgr) 
	{
		this.mgr = mgr;
	}

	public Integer getMgr() 
	{
		return mgr;
	}
	public void setJob(String job) 
	{
		this.job = job;
	}

	public String getJob() 
	{
		return job;
	}
	public void setSal(Float sal) 
	{
		this.sal = sal;
	}

	public Float getSal() 
	{
		return sal;
	}
	public void setComm(Float comm) 
	{
		this.comm = comm;
	}

	public Float getComm() 
	{
		return comm;
	}
	public void setHiredate(Date hiredate) 
	{
		this.hiredate = hiredate;
	}

	public Date getHiredate() 
	{
		return hiredate;
	}
	public void setDeptno(Integer deptno) 
	{
		this.deptno = deptno;
	}

	public Integer getDeptno() 
	{
		return deptno;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("empno", getEmpno())
            .append("ename", getEname())
            .append("mgr", getMgr())
            .append("job", getJob())
            .append("sal", getSal())
            .append("comm", getComm())
            .append("hiredate", getHiredate())
            .append("deptno", getDeptno())
            .toString();
    }
}
