package com.ibm.btt.wsc.mapper.beans;

import java.util.Date;

public class WMCBW11231 {
	// immutable
	private Integer integerField;
	private String stringField = "0000000000";
	private Date dateField;

	private Integer[] integerArray = { 1, 2, 5, 7 };
	private String[] stringArray = { "1", "2", "3" };
	private Date[] dateArray;

	// nested bean
	private BWFromBeanSimple innerBean;
	private BWFromBeanSimple innerBeanNull = null;

	private BWFromBeanSimple[] innerBeanArray = new BWFromBeanSimple[4];

	private String[][] str2dArray = { { "0", "0", "0" }, { "01", "01", "01" },
			{ "10", "10", "10" } };

	public WMCBW11231() {
		innerBean = new BWFromBeanSimple();
		innerBean.setCharacterFromField(new Character('S'));
	}

	public Integer getIntegerField() {
		return integerField;
	}

	public void setIntegerField(Integer integerField) {
		this.integerField = integerField;
	}

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public Date getDateField() {
		return dateField;
	}

	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}

	public Integer[] getIntegerArray() {
		return integerArray;
	}

	public void setIntegerArray(Integer[] integerArray) {
		this.integerArray = integerArray;
	}

	public String[] getStringArray() {
		return stringArray;
	}

	public void setStringArray(String[] stringArray) {
		this.stringArray = stringArray;
	}

	public Date[] getDateArray() {
		return dateArray;
	}

	public void setDateArray(Date[] dateArray) {
		this.dateArray = dateArray;
	}

	public BWFromBeanSimple getInnerBean() {
		return innerBean;
	}

	public void setInnerBean(BWFromBeanSimple innerBean) {
		this.innerBean = innerBean;
	}

	public BWFromBeanSimple getInnerBeanNull() {
		return innerBeanNull;
	}

	public void setInnerBeanNull(BWFromBeanSimple innerBeanNull) {
		this.innerBeanNull = innerBeanNull;
	}

	public BWFromBeanSimple[] getInnerBeanArray() {
		return innerBeanArray;
	}

	public void setInnerBeanArray(BWFromBeanSimple[] innerBeanArray) {
		this.innerBeanArray = innerBeanArray;
	}

	public String[][] getStr2dArray() {
		return str2dArray;
	}

	public void setStr2dArray(String[][] str2dArray) {
		this.str2dArray = str2dArray;
	}

}
