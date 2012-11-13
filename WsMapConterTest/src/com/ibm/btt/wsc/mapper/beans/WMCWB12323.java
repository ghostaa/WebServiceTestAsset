package com.ibm.btt.wsc.mapper.beans;

import java.util.Date;

public class WMCWB12323 {
	private String uuid = "1b6c0f31-eb5e-4118-973f-fd451750d1de";

	private String theName = "RANDOM_NAME";

	private int theAge = 27;

	private Date theBirth = new Date();

	private String[] theStrArray = { "X", "Y", "Z", "A" };

	private int[] theIntArray = { 99, 888, 333 };

	private Date[] theDateArray = { new Date(), new Date(), new Date() };

	public Inner4Array inner = new Inner4Array();

	private Inner4Array[] innerArray = { new Inner4Array(), new Inner4Array() };

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public int getTheAge() {
		return theAge;
	}

	public void setTheAge(int theAge) {
		this.theAge = theAge;
	}

	public Date getTheBirth() {
		return theBirth;
	}

	public void setTheBirth(Date theBirth) {
		this.theBirth = theBirth;
	}

	public String[] getTheStrArray() {
		return theStrArray;
	}

	public void setTheStrArray(String[] theStrArray) {
		this.theStrArray = theStrArray;
	}

	public int[] getTheIntArray() {
		return theIntArray;
	}

	public void setTheIntArray(int[] theIntArray) {
		this.theIntArray = theIntArray;
	}

	public Date[] getTheDateArray() {
		return theDateArray;
	}

	public void setTheDateArray(Date[] theDateArray) {
		this.theDateArray = theDateArray;
	}

	public Inner4Array getInner() {
		return inner;
	}

	public void setInner(Inner4Array inner) {
		this.inner = inner;
	}

	public Inner4Array[] getInnerArray() {
		return innerArray;
	}

	public void setInnerArray(Inner4Array[] innerArray) {
		this.innerArray = innerArray;
	}

}
