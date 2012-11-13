package com.ibm.btt.base.ws.format.test.bean;

public class SubJavaBean {
	public SubJavaBean() {
	
	}

	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof SubJavaBean){
			SubJavaBean temp = (SubJavaBean)o;
			return (temp.getIntValue() == this.getIntValue()) && temp.getSomeThing().equals(this.getSomeThing());
		}
		return super.equals(o);
	}


	public SubJavaBean(String someThing, int intValue) {
		this.someThing = someThing;
		this.intValue = intValue;
	}

	private String someThing;
	private int intValue;

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public String getSomeThing() {
		return someThing;
	}

	public void setSomeThing(String someThing) {
		this.someThing = someThing;
	}

}
