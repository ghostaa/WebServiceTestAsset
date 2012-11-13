package com.ibm.btt.wsc.mapper.beans;

import java.util.ArrayList;
import java.util.List;

public class E2eaComplexTypeBeanList {
	private E2eaPrimitiveTypeBeanList primitiveLa = new E2eaPrimitiveTypeBeanList();
	private E2eaSimpleTypeBeanList simpleLa = new E2eaSimpleTypeBeanList();

	private List<E2eaPrimitiveTypeBeanList> primitiveLaIColl = new ArrayList<E2eaPrimitiveTypeBeanList>();
	private List<E2eaSimpleTypeBeanList> simpleLaIColl = new ArrayList<E2eaSimpleTypeBeanList>();

	private List<E2eaPrimitiveTypeBeanList> primitiveLaIColl2 = new ArrayList<E2eaPrimitiveTypeBeanList>();
	private List<E2eaSimpleTypeBeanList> simpleLaIColl2 = new ArrayList<E2eaSimpleTypeBeanList>();

	public E2eaPrimitiveTypeBeanList getPrimitiveLa() {
		return primitiveLa;
	}

	public void setPrimitiveLa(E2eaPrimitiveTypeBeanList primitiveLa) {
		this.primitiveLa = primitiveLa;
	}

	public E2eaSimpleTypeBeanList getSimpleLa() {
		return simpleLa;
	}

	public void setSimpleLa(E2eaSimpleTypeBeanList simpleLa) {
		this.simpleLa = simpleLa;
	}

	public List<E2eaPrimitiveTypeBeanList> getPrimitiveLaIColl() {
		return primitiveLaIColl;
	}

	public void setPrimitiveLaIColl(List<E2eaPrimitiveTypeBeanList> primitiveLaIColl) {
		this.primitiveLaIColl = primitiveLaIColl;
	}

	public List<E2eaSimpleTypeBeanList> getSimpleLaIColl() {
		return simpleLaIColl;
	}

	public void setSimpleLaIColl(List<E2eaSimpleTypeBeanList> simpleLaIColl) {
		this.simpleLaIColl = simpleLaIColl;
	}

	public List<E2eaPrimitiveTypeBeanList> getPrimitiveLaIColl2() {
		return primitiveLaIColl2;
	}

	public void setPrimitiveLaIColl2(List<E2eaPrimitiveTypeBeanList> primitiveLaIColl2) {
		this.primitiveLaIColl2 = primitiveLaIColl2;
	}

	public List<E2eaSimpleTypeBeanList> getSimpleLaIColl2() {
		return simpleLaIColl2;
	}

	public void setSimpleLaIColl2(List<E2eaSimpleTypeBeanList> simpleLaIColl2) {
		this.simpleLaIColl2 = simpleLaIColl2;
	}

}
