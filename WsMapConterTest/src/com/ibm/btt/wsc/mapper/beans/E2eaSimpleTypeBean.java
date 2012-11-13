package com.ibm.btt.wsc.mapper.beans;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class E2eaSimpleTypeBean {
	private Object interference1 = null;
	private Object[] interferenceIColl = { "Field only for interference" };

	private String stringField = "NA";
	private String[] stringIColl;

	private Integer integerField;
	private Integer integerIColl[] = new Integer[3];

	private BigDecimal bigDecimalField;
	private BigDecimal[] bigDecimalIColl;

	private Date dateField;
	private Date[] dateIColl;

	private Calendar calendarField;
	private Calendar[] calendarIColl;

	//TODO In web service, String would be converted to String
	private String uuidField;
	private String uuidIColl[];

	public Object getInterference1() {
		return interference1;
	}

	public void setInterference1(Object interference1) {
		this.interference1 = interference1;
	}

	public Object[] getInterferenceIColl() {
		return interferenceIColl;
	}

	public void setInterferenceIColl(Object[] interferenceIColl) {
		this.interferenceIColl = interferenceIColl;
	}

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public String[] getStringIColl() {
		return stringIColl;
	}

	public void setStringIColl(String[] stringIColl) {
		this.stringIColl = stringIColl;
	}

	public Integer getIntegerField() {
		return integerField;
	}

	public void setIntegerField(Integer integerField) {
		this.integerField = integerField;
	}

	public Integer[] getIntegerIColl() {
		return integerIColl;
	}

	public void setIntegerIColl(Integer[] integerIColl) {
		this.integerIColl = integerIColl;
	}

	public BigDecimal getBigDecimalField() {
		return bigDecimalField;
	}

	public void setBigDecimalField(BigDecimal bigDecimalField) {
		this.bigDecimalField = bigDecimalField;
	}

	public BigDecimal[] getBigDecimalIColl() {
		return bigDecimalIColl;
	}

	public void setBigDecimalIColl(BigDecimal[] bigDecimalIColl) {
		this.bigDecimalIColl = bigDecimalIColl;
	}

	public Date getDateField() {
		return dateField;
	}

	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}

	public Date[] getDateIColl() {
		return dateIColl;
	}

	public void setDateIColl(Date[] dateIColl) {
		this.dateIColl = dateIColl;
	}

	public Calendar getCalendarField() {
		return calendarField;
	}

	public void setCalendarField(Calendar calendarField) {
		this.calendarField = calendarField;
	}

	public Calendar[] getCalendarIColl() {
		return calendarIColl;
	}

	public void setCalendarIColl(Calendar[] calendarIColl) {
		this.calendarIColl = calendarIColl;
	}

	public String getUuidField() {
		return uuidField;
	}

	public void setUuidField(String uuidField) {
		this.uuidField = uuidField;
	}

	public String[] getUuidIColl() {
		return uuidIColl;
	}

	public void setUuidIColl(String[] uuidIColl) {
		this.uuidIColl = uuidIColl;
	}

}
