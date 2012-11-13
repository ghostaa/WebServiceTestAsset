package com.ibm.btt.wsc.mapper.beans;

import java.util.Calendar;

public class Inner4Array {
		private double inCome = 123.45d;
		private Long inHist = new Long(99999L);
		private Calendar startCal = Calendar.getInstance();

		private InnerInner4Array innerInner = new InnerInner4Array();

		private String[] theInnerStrArray = { "", "23" };

		private InnerInner4Array[] theInnerInnerArray = { new InnerInner4Array(),
				new InnerInner4Array(), new InnerInner4Array() };

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

		public InnerInner4Array getInnerInner() {
			return innerInner;
		}

		public void setInnerInner(InnerInner4Array innerInner) {
			this.innerInner = innerInner;
		}

		public String[] getTheInnerStrArray() {
			return theInnerStrArray;
		}

		public void setTheInnerStrArray(String[] theInnerStrArray) {
			this.theInnerStrArray = theInnerStrArray;
		}

		public InnerInner4Array[] getTheInnerInnerArray() {
			return theInnerInnerArray;
		}

		public void setTheInnerInnerArray(InnerInner4Array[] theInnerInnerArray) {
			this.theInnerInnerArray = theInnerInnerArray;
		}
	}