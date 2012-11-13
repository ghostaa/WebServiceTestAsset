package com.ibm.btt.wsc.mapper.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Inner {
	private double inCome = 123.45d;
	private Long inHist = new Long(99999L);
	private Calendar startCal = Calendar.getInstance();

	private InnerInner innerInner = new InnerInner();

	private List<String> theInnerStrArray = new ArrayList<String>();

	private List<InnerInner> theInnerInnerArray = new ArrayList<InnerInner>();

	public double getInCome() {
		return inCome;
	}

	public void setInCome(double inCome) {
		this.inCome = inCome;
	}

	public Long getInHist() {
		return inHist;
	}

	public void setInHist(Long inHist) {
		this.inHist = inHist;
	}

	public Calendar getStartCal() {
		return startCal;
	}

	public void setStartCal(Calendar startCal) {
		this.startCal = startCal;
	}

	public InnerInner getInnerInner() {
		return innerInner;
	}

	public void setInnerInner(InnerInner innerInner) {
		this.innerInner = innerInner;
	}

	public List<String> getTheInnerStrArray() {
		return theInnerStrArray;
	}

	public void setTheInnerStrArray(List<String> theInnerStrArray) {
		this.theInnerStrArray = theInnerStrArray;
	}

	public List<InnerInner> getTheInnerInnerArray() {
		return theInnerInnerArray;
	}

	public void setTheInnerInnerArray(List<InnerInner> theInnerInnerArray) {
		this.theInnerInnerArray = theInnerInnerArray;
	}

}