package com.ibm.btt.wsc.mapper.beans;

import java.util.Calendar;
import java.util.Date;

public class BWFromBeanSimple {
	// primitive
	private int intPrimitiveFromField = 1024;
	private long longPrimitiveFromField = 1048576L;
	private char charPrimitiveFromField = 'L';
	private short shortPrimitiveFromField = 8192;
	private float floatPrimitiveFromField = 1024.512f;
	private double doublePrimitiveFromField = 1048576.2048d;
	private boolean booleanPrimitiveFromField = true;
	private byte bytePrimitiveFromField = 64;

	// immutable
	private Boolean booleanFromField;
	private Character characterFromField = new Character('L');
	private Byte byteFromField;
	private Double doubleFromField;
	private Float floatFromField;
	private Integer integerFromField;
	private Long longFromField;
	private Short shortFromField;
	private String stringFromField = "LvShuangTao";

	// mutable
	private Date dateFromField;
	private Calendar calendarFromField;

	public int getIntPrimitiveFromField() {
		return intPrimitiveFromField;
	}

	public void setIntPrimitiveFromField(int intPrimitiveFromField) {
		this.intPrimitiveFromField = intPrimitiveFromField;
	}

	public long getLongPrimitiveFromField() {
		return longPrimitiveFromField;
	}

	public void setLongPrimitiveFromField(long longPrimitiveFromField) {
		this.longPrimitiveFromField = longPrimitiveFromField;
	}

	public char getCharPrimitiveFromField() {
		return charPrimitiveFromField;
	}

	public void setCharPrimitiveFromField(char charPrimitiveFromField) {
		this.charPrimitiveFromField = charPrimitiveFromField;
	}

	public short getShortPrimitiveFromField() {
		return shortPrimitiveFromField;
	}

	public void setShortPrimitiveFromField(short shortPrimitiveFromField) {
		this.shortPrimitiveFromField = shortPrimitiveFromField;
	}

	public float getFloatPrimitiveFromField() {
		return floatPrimitiveFromField;
	}

	public void setFloatPrimitiveFromField(float floatPrimitiveFromField) {
		this.floatPrimitiveFromField = floatPrimitiveFromField;
	}

	public double getDoublePrimitiveFromField() {
		return doublePrimitiveFromField;
	}

	public void setDoublePrimitiveFromField(double doublePrimitiveFromField) {
		this.doublePrimitiveFromField = doublePrimitiveFromField;
	}

	public boolean isBooleanPrimitiveFromField() {
		return booleanPrimitiveFromField;
	}

	public void setBooleanPrimitiveFromField(boolean booleanPrimitiveFromField) {
		this.booleanPrimitiveFromField = booleanPrimitiveFromField;
	}

	public byte getBytePrimitiveFromField() {
		return bytePrimitiveFromField;
	}

	public void setBytePrimitiveFromField(byte bytePrimitiveFromField) {
		this.bytePrimitiveFromField = bytePrimitiveFromField;
	}

	public Boolean getBooleanFromField() {
		return booleanFromField;
	}

	public void setBooleanFromField(Boolean booleanFromField) {
		this.booleanFromField = booleanFromField;
	}

	public Character getCharacterFromField() {
		return characterFromField;
	}

	public void setCharacterFromField(Character characterFromField) {
		this.characterFromField = characterFromField;
	}

	public Byte getByteFromField() {
		return byteFromField;
	}

	public void setByteFromField(Byte byteFromField) {
		this.byteFromField = byteFromField;
	}

	public Double getDoubleFromField() {
		return doubleFromField;
	}

	public void setDoubleFromField(Double doubleFromField) {
		this.doubleFromField = doubleFromField;
	}

	public Float getFloatFromField() {
		return floatFromField;
	}

	public void setFloatFromField(Float floatFromField) {
		this.floatFromField = floatFromField;
	}

	public Integer getIntegerFromField() {
		return integerFromField;
	}

	public void setIntegerFromField(Integer integerFromField) {
		this.integerFromField = integerFromField;
	}

	public Long getLongFromField() {
		return longFromField;
	}

	public void setLongFromField(Long longFromField) {
		this.longFromField = longFromField;
	}

	public Short getShortFromField() {
		return shortFromField;
	}

	public void setShortFromField(Short shortFromField) {
		this.shortFromField = shortFromField;
	}

	public String getStringFromField() {
		return stringFromField;
	}

	public void setStringFromField(String stringFromField) {
		this.stringFromField = stringFromField;
	}

	public Date getDateFromField() {
		return dateFromField;
	}

	public void setDateFromField(Date dateFromField) {
		this.dateFromField = dateFromField;
	}

	public Calendar getCalendarFromField() {
		return calendarFromField;
	}

	public void setCalendarFromField(Calendar calendarFromField) {
		this.calendarFromField = calendarFromField;
	}

}
