package com.ibm.btt.wsc.mapper.beans;

public class E2eaComplexTypeBean {
	private E2eaPrimitiveTypeBean primitiveLa = new E2eaPrimitiveTypeBean();
	private E2eaSimpleTypeBean simpleLa = new E2eaSimpleTypeBean();

	private E2eaPrimitiveTypeBean[] primitiveLaIColl;
	private E2eaSimpleTypeBean[] simpleLaIColl = { new E2eaSimpleTypeBean(), new E2eaSimpleTypeBean() };

	private E2eaPrimitiveTypeBean[] primitiveLaIColl2 = new E2eaPrimitiveTypeBean[1];
	private E2eaSimpleTypeBean[] simpleLaIColl2 = {};

	public E2eaPrimitiveTypeBean getPrimitiveLa() {
		return primitiveLa;
	}

	public void setPrimitiveLa(E2eaPrimitiveTypeBean primitiveLa) {
		this.primitiveLa = primitiveLa;
	}

	public E2eaSimpleTypeBean getSimpleLa() {
		return simpleLa;
	}

	public void setSimpleLa(E2eaSimpleTypeBean simpleLa) {
		this.simpleLa = simpleLa;
	}

	public E2eaPrimitiveTypeBean[] getPrimitiveLaIColl() {
		return primitiveLaIColl;
	}

	public void setPrimitiveLaIColl(E2eaPrimitiveTypeBean[] primitiveLaIColl) {
		this.primitiveLaIColl = primitiveLaIColl;
	}

	public E2eaSimpleTypeBean[] getSimpleLaIColl() {
		return simpleLaIColl;
	}

	public void setSimpleLaIColl(E2eaSimpleTypeBean[] simpleLaIColl) {
		this.simpleLaIColl = simpleLaIColl;
	}

	public E2eaPrimitiveTypeBean[] getPrimitiveLaIColl2() {
		return primitiveLaIColl2;
	}

	public void setPrimitiveLaIColl2(E2eaPrimitiveTypeBean[] primitiveLaIColl2) {
		this.primitiveLaIColl2 = primitiveLaIColl2;
	}

	public E2eaSimpleTypeBean[] getSimpleLaIColl2() {
		return simpleLaIColl2;
	}

	public void setSimpleLaIColl2(E2eaSimpleTypeBean[] simpleLaIColl2) {
		this.simpleLaIColl2 = simpleLaIColl2;
	}

}
