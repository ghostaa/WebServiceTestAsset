package com.ibm.btt.wsc.mapper.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WMCWB12323List {
	private String uuid = "1b6c0f31-eb5e-4118-973f-fd451750d1de";

	private String theName = "RANDOM_NAME";

	private int theAge = 27;

	private Date theBirth = new Date();

	private List<String> theStrArray = new ArrayList<String>();

	private List<Integer> theIntArray = new ArrayList<Integer>();

	private List<Date> theDateArray = new ArrayList<Date>();

	public Inner inner = new Inner();

	private List<Inner> innerArray = new ArrayList<Inner>();

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

	public List<String> getTheStrArray() {
		return theStrArray;
	}

	public void setTheStrArray(List<String> theStrArray) {
		this.theStrArray = theStrArray;
	}

	public List<Integer> getTheIntArray() {
		return theIntArray;
	}

	public void setTheIntArray(List<Integer> theIntArray) {
		this.theIntArray = theIntArray;
	}

	public List<Date> getTheDateArray() {
		return theDateArray;
	}

	public void setTheDateArray(List<Date> theDateArray) {
		this.theDateArray = theDateArray;
	}

	public Inner getInner() {
		return inner;
	}

	public void setInner(Inner inner) {
		this.inner = inner;
	}

	public List<Inner> getInnerArray() {
		return innerArray;
	}

	public void setInnerArray(List<Inner> innerArray) {
		this.innerArray = innerArray;
	}
}