package com.dacnx.www.entry;

/**
 * ��ҳ����
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
	 * ҳ��
	 */
	private int number;
	
	/**
	 * ÿҳ��ʾ����
	 */
	private int count;
	
	/**
	 * ��Ϣ����
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