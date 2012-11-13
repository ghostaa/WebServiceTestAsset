package com.ibm.btt.wsc.mapper.beans;

import java.util.Date;

public class WMCWB1244CompleteMatch {
	private int intSrcField = 9987;;
	private String strSrcField = "stlv@cn.ibm.com";
	private Date dateSrcField = new Date();
	private WMCWB1244 beanSrcCollection = new WMCWB1244();

	public int getIntSrcField() {
		return intSrcField;
	}

	public void setIntSrcField(int intSrcField) {
		this.intSrcField = intSrcField;
	}

	public String getStrSrcField() {
		return strSrcField;
	}

	public void setStrSrcField(String strSrcField) {
		this.strSrcField = strSrcField;
	}

	public Date getDateSrcField() {
		return dateSrcField;
	}

	public void setDateSrcField(Date dateSrcField) {
		this.dateSrcField = dateSrcField;
	}

	public WMCWB1244 getBeanSrcCollection() {
		return beanSrcCollection;
	}

	public void setBeanSrcCollection(WMCWB1244 beanSrcCollection) {
		this.beanSrcCollection = beanSrcCollection;
	}

}
