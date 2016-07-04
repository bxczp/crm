package com.bx.entity;

/**
 * @date 2016年3月27日 PageBean.java
 * @author CZP
 * @parameter
 */
public class PageBean {

	private Integer page;
	private Integer size;
	private Integer start;

	public PageBean(Integer page, Integer size) {
		super();
		this.page = page;
		this.size = size;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getStart() {
		return (page - 1) * size;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

}
