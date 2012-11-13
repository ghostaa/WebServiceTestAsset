package com.ibm.btt.wsc.mapper.beans;

import java.util.Date;

public class WMCBW11231DestBean {
	// immutable
	private Integer integerDestField;
	private String stringDestField = "^^^^^^^^^^";
	private Date dateDestField;

	private Integer[] integerDestArray;
	private String[] stringDestArray = { "3", "0", "1" };
	private Date[] dateDestArray = {new Date(),new Date()};

	// nested bean
	private WMCBW11223 innerDestBean = new WMCBW11223();
	private WMCBW11223 innerDestBeanNull = null;

	private WMCBW11223[] innerDestBeanArray = new WMCBW11223[4];

	private String[][] str2dArrayDest = { { "90", "90", "90" }, { "901", "901", "901" },
			{ "109", "109", "109" } };

	public Integer getIntegerDestField() {
		return integerDestField;
	}

	public void setIntegerDestField(Integer integerDestField) {
		this.integerDestField = integerDestField;
	}

	public String getStringDestField() {
		return stringDestField;
	}

	public void setStringDestField(String stringDestField) {
		this.stringDestField = stringDestField;
	}

	public Date getDateDestField() {
		return dateDestField;
	}

	public void setDateDestField(Date dateDestField) {
		this.dateDestField = dateDestField;
	}

	public Integer[] getIntegerDestArray() {
		return integerDestArray;
	}

	public void setIntegerDestArray(Integer[] integerDestArray) {
		this.integerDestArray = integerDestArray;
	}

	public String[] getStringDestArray() {
		return stringDestArray;
	}

	public void setStringDestArray(String[] stringDestArray) {
		this.stringDestArray = stringDestArray;
	}

	public Date[] getDateDestArray() {
		return dateDestArray;
	}

	public void setDateDestArray(Date[] dateDestArray) {
		this.dateDestArray = dateDestArray;
	}

	public WMCBW11223 getInnerDestBean() {
		return innerDestBean;
	}

	public void setInnerDestBean(WMCBW11223 innerDestBean) {
		this.innerDestBean = innerDestBean;
	}

	public WMCBW11223 getInnerDestBeanNull() {
		return innerDestBeanNull;
	}

	public void setInnerDestBeanNull(WMCBW11223 innerDestBeanNull) {
		this.innerDestBeanNull = innerDestBeanNull;
	}

	public WMCBW11223[] getInnerDestBeanArray() {
		return innerDestBeanArray;
	}

	public void setInnerDestBeanArray(WMCBW11223[] innerDestBeanArray) {
		this.innerDestBeanArray = innerDestBeanArray;
	}

	public String[][] getStr2dArrayDest() {
		return str2dArrayDest;
	}

	public void setStr2dArrayDest(String[][] str2dArrayDest) {
		this.str2dArrayDest = str2dArrayDest;
	}

}
