package com.test.pojo;

import java.util.Date;

public class Cost {

	private Integer id;// ID
	private String name;// NAME
	private Integer baseDuration;// BASE_DURATION
	private Double baseCost;// BASE_COST
	private Double unitCost;// UNIT_COST
	private String status;// STATUS
	private String descr;// DESCR
	private Date createTime;// CREATIME
	private Date startTime;// STARTIME
	private String costType;// COST_TYPE

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBaseDuration() {
		return baseDuration;
	}

	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTiem) {
		this.startTime = startTiem;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

}
