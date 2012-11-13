package com.ibm.btt.wsc.mapper.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class E2eaSimpleTypeBeanList {

	public E2eaSimpleTypeBeanList() {
		dateIColl = new ArrayList<Date>();
//		dateIColl.add(new Date());
//		dateIColl.add(new Date());
//		dateIColl.add(new Date());
//
		uuidIColl = new ArrayList<String>();
//		uuidIColl.add("+");
//		uuidIColl.add("-");
//		uuidIColl.add("*");
//		uuidIColl.add("/");
	}

	private Object interference1 = null;
	private List<Object> interferenceIColl = new ArrayList<Object>();

	private String stringField = "NA";
	private List<String> stringIColl = new ArrayList<String>();

	private Integer integerField;
	private List<Integer> integerIColl = new ArrayList<Integer>();

	private BigDecimal bigDecimalField;
	private List<BigDecimal> bigDecimalIColl = new ArrayList<BigDecimal>();

	private Date dateField;
	private List<Date> dateIColl;

	private Calendar calendarField;
	private List<Calendar> calendarIColl = new ArrayList<Calendar>();

	private String uuidField;
	private List<String> uuidIColl;

	public Object getInterference1() {
		return interference1;
	}

	public void setInterference1(Object interference1) {
		this.interference1 = interference1;
	}

	public List<Object> getInterferenceIColl() {
		return interferenceIColl;
	}

	public void setInterferenceIColl(List<Object> interferenceIColl) {
		this.interferenceIColl = interferenceIColl;
	}

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public List<String> getStringIColl() {
		return stringIColl;
	}

	public void setStringIColl(List<String> stringIColl) {
		this.stringIColl = stringIColl;
	}

	public Integer getIntegerField() {
		return integerField;
	}

	public void setIntegerField(Integer integerField) {
		this.integerField = integerField;
	}

	public List<Integer> getIntegerIColl() {
		return integerIColl;
	}

	public void setIntegerIColl(List<Integer> integerIColl) {
		this.integerIColl = integerIColl;
	}

	public BigDecimal getBigDecimalField() {
		return bigDecimalField;
	}

	public void setBigDecimalField(BigDecimal bigDecimalField) {
		this.bigDecimalField = bigDecimalField;
	}

	public List<BigDecimal> getBigDecimalIColl() {
		return bigDecimalIColl;
	}

	public void setBigDecimalIColl(List<BigDecimal> bigDecimalIColl) {
		this.bigDecimalIColl = bigDecimalIColl;
	}

	public Date getDateField() {
		return dateField;
	}

	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}

	public List<Date> getDateIColl() {
		return dateIColl;
	}

	public void setDateIColl(List<Date> dateIColl) {
		this.dateIColl = dateIColl;
	}

	public Calendar getCalendarField() {
		return calendarField;
	}

	public void setCalendarField(Calendar calendarField) {
		this.calendarField = calendarField;
	}

	public List<Calendar> getCalendarIColl() {
		return calendarIColl;
	}

	public void setCalendarIColl(List<Calendar> calendarIColl) {
		this.calendarIColl = calendarIColl;
	}

	public String getUuidField() {
		return uuidField;
	}

	public void setUuidField(String uuidField) {
		this.uuidField = uuidField;
	}

	public List<String> getUuidIColl() {
		return uuidIColl;
	}

	public void setUuidIColl(List<String> uuidIColl) {
		this.uuidIColl = uuidIColl;
	}

}
