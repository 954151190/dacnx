package com.dacnx.www.entry;

/**
 * 分页对象
 * @author Administrator
 *
 */
public class Page {
	
	public Page() {
		this.number = 1;
		this.count = 20;
	}
	
	public Page( int number , int count ){
		this.number = number;
		this.count = count;
	}
	
	/**
	 * 页码
	 */
	private int number;
	
	/**
	 * 每页显示条数
	 */
	private int count;
	
	/**
	 * 信息总数
	 */
	private int allCount;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
}