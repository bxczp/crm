package com.bx.entity;

import java.util.Date;

/**
 * @date 2016年3月28日 Sale_Chance.java
 * @author CZP
 * @parameter
 */
public class SaleChance {

	private Integer id;
	private String chanceSource;
	private String customerName;
	// 成功几率
	private Integer cgjl;
	private String overView;
	private String linkMan;

	private String linkPhone;

	private String description;
	private String createMan;
	private Date createTime;
	private String assignMan;
	private Date assignTime;
	// 分配状态 0 未分配 1 已分配
	private Integer state;
	// 客户开发状态 0未开发 1开发中 2开发成功 3开发失败
	private Integer devResult;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChanceSource() {
		return chanceSource;
	}

	public void setChanceSource(String chanceSource) {
		this.chanceSource = chanceSource;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCgjl() {
		return cgjl;
	}

	public void setCgjl(Integer cgjl) {
		this.cgjl = cgjl;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAssignMan() {
		return assignMan;
	}

	public void setAssignMan(String assignMan) {
		this.assignMan = assignMan;
	}

	public Date getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getDevResult() {
		return devResult;
	}

	public void setDevResult(Integer devResult) {
		this.devResult = devResult;
	}

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

}
