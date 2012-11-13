package com.ibm.btt.wsc.mapper.beans;

import java.util.Calendar;
import java.util.Date;

public class WMCBW11223 {
	// primitive
	private char charPrimitiveToField = 'L';
	private short shortPrimitiveToField = 8192;
	private boolean booleanPrimitiveToField = true;
	private byte bytePrimitiveToField = 64;

	// immutable
	private Boolean booleanToField;
	private Character characterToField = new Character('L');
	private Byte byteToField;
	private Short shortToField;

	// mutable
	private Date dateToField;
	private Calendar calendarToField;

	public char getCharPrimitiveToField() {
		return charPrimitiveToField;
	}

	public void setCharPrimitiveToField(char charPrimitiveToField) {
		this.charPrimitiveToField = charPrimitiveToField;
	}

	public short getShortPrimitiveToField() {
		return shortPrimitiveToField;
	}

	public void setShortPrimitiveToField(short shortPrimitiveToField) {
		this.shortPrimitiveToField = shortPrimitiveToField;
	}

	public boolean isBooleanPrimitiveToField() {
		return booleanPrimitiveToField;
	}

	public void setBooleanPrimitiveToField(boolean booleanPrimitiveToField) {
		this.booleanPrimitiveToField = booleanPrimitiveToField;
	}

	public byte getBytePrimitiveToField() {
		return bytePrimitiveToField;
	}

	public void setBytePrimitiveToField(byte bytePrimitiveToField) {
		this.bytePrimitiveToField = bytePrimitiveToField;
	}

	public Boolean getBooleanToField() {
		return booleanToField;
	}

	public void setBooleanToField(Boolean booleanToField) {
		this.booleanToField = booleanToField;
	}

	public Character getCharacterToField() {
		return characterToField;
	}

	public void setCharacterToField(Character characterToField) {
		this.characterToField = characterToField;
	}

	public Byte getByteToField() {
		return byteToField;
	}

	public void setByteToField(Byte byteToField) {
		this.byteToField = byteToField;
	}

	public Short getShortToField() {
		return shortToField;
	}

	public void setShortToField(Short shortToField) {
		this.shortToField = shortToField;
	}

	public Date getDateToField() {
		return dateToField;
	}

	public void setDateToField(Date dateToField) {
		this.dateToField = dateToField;
	}

	public Calendar getCalendarToField() {
		return calendarToField;
	}

	public void setCalendarToField(Calendar calendarToField) {
		this.calendarToField = calendarToField;
	}

}
