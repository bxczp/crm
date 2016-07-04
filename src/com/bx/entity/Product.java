package com.bx.entity;

/**
 * @date 2016年3月27日 Product.java
 * @author CZP
 * @parameter
 */
public class Product {

	private Integer id;
	// 产品名称
	private String productName;
	// 产品型号
	private String model;
	// 单位
	private String unit;
	// 价格
	private float price;
	// 库存
	private Integer store;

	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getStore() {
		return store;
	}

	public void setStore(Integer store) {
		this.store = store;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}