package com.ibm.btt.base.ws.format.test.bean;

import java.util.ArrayList;
import java.util.List;

public class JavaBean {

	public byte getPrimitiveByte() {
		return primitiveByte;
	}

	public void setPrimitiveByte(byte primitiveByte) {
		this.primitiveByte = primitiveByte;
	}

	public char getPrimitiveChar() {
		return primitiveChar;
	}

	public void setPrimitiveChar(char primitiveChar) {
		this.primitiveChar = primitiveChar;
	}

	public short getPrimitiveShort() {
		return primitiveShort;
	}

	public void setPrimitiveShort(short primitiveShort) {
		this.primitiveShort = primitiveShort;
	}

	public int getPrimitiveInt() {
		return primitiveInt;
	}

	public void setPrimitiveInt(int primitiveInt) {
		this.primitiveInt = primitiveInt;
	}

	public long getPrimitiveLong() {
		return primitiveLong;
	}

	public void setPrimitiveLong(long primitiveLong) {
		this.primitiveLong = primitiveLong;
	}

	public float getPrimitiveFloat() {
		return primitiveFloat;
	}

	public void setPrimitiveFloat(float primitiveFloat) {
		this.primitiveFloat = primitiveFloat;
	}

	public double getPrimitiveDouble() {
		return primitiveDouble;
	}

	public void setPrimitiveDouble(double primitiveDouble) {
		this.primitiveDouble = primitiveDouble;
	}

	public byte[] getPrimitiveByteArray() {
		return primitiveByteArray;
	}

	public void setPrimitiveByteArray(byte[] primitiveByteArray) {
		this.primitiveByteArray = primitiveByteArray;
	}

	public char[] getPrimitiveCharArray() {
		return primitiveCharArray;
	}

	public void setPrimitiveCharArray(char[] primitiveCharArray) {
		this.primitiveCharArray = primitiveCharArray;
	}

	public short[] getPrimitiveShortArray() {
		return primitiveShortArray;
	}

	public void setPrimitiveShortArray(short[] primitiveShortArray) {
		this.primitiveShortArray = primitiveShortArray;
	}

	public int[] getPrimitiveIntArray() {
		return primitiveIntArray;
	}

	public void setPrimitiveIntArray(int[] primitiveIntArray) {
		this.primitiveIntArray = primitiveIntArray;
	}

	public long[] getPrimitiveLongArray() {
		return primitiveLongArray;
	}

	public void setPrimitiveLongArray(long[] primitiveLongArray) {
		this.primitiveLongArray = primitiveLongArray;
	}

	public float[] getPrimitiveFloatArray() {
		return primitiveFloatArray;
	}

	public void setPrimitiveFloatArray(float[] primitiveFloatArray) {
		this.primitiveFloatArray = primitiveFloatArray;
	}

	public double[] getPrimitiveDoubleArray() {
		return primitiveDoubleArray;
	}

	public void setPrimitiveDoubleArray(double[] primitiveDoubleArray) {
		this.primitiveDoubleArray = primitiveDoubleArray;
	}

	public String getStringObject() {
		return stringObject;
	}

	public void setStringObject(String stringObject) {
		this.stringObject = stringObject;
	}

	public String[] getStringObjectArray() {
		return stringObjectArray;
	}

	public void setStringObjectArray(String[] stringObjectArray) {
		this.stringObjectArray = stringObjectArray;
	}

	public List<String> getStringObjectList() {
		return stringObjectList;
	}

	public void setStringObjectList(List<String> stringObjectList) {
		this.stringObjectList = stringObjectList;
	}

	public SubJavaBean getSubJavaBean() {
		return subJavaBean;
	}

	public void setSubJavaBean(SubJavaBean subJavaBean) {
		this.subJavaBean = subJavaBean;
	}

	public SubJavaBean[] getSubJavaBeanArray() {
		return subJavaBeanArray;
	}

	public void setSubJavaBeanArray(SubJavaBean[] subJavaBeanArray) {
		this.subJavaBeanArray = subJavaBeanArray;
	}

	public List<SubJavaBean> getSubJavaBeanList() {
		return subJavaBeanList;
	}

	public void setSubJavaBeanList(List<SubJavaBean> subJavaBeanList) {
		this.subJavaBeanList = subJavaBeanList;
	}

	byte primitiveByte;
	char primitiveChar;
	short primitiveShort;
	int primitiveInt;
	long primitiveLong;
	float primitiveFloat;
	double primitiveDouble;

	byte[] primitiveByteArray = new byte[0];
	char[] primitiveCharArray = new char[0];
	short[] primitiveShortArray = new short[0];
	int[] primitiveIntArray = new int[0];
	long[] primitiveLongArray = new long[0];
	float[] primitiveFloatArray = new float[0];
	double[] primitiveDoubleArray = new double[0];

	String stringObject;
	String[] stringObjectArray;

	// The list must be initialized either
	List<String> stringObjectList = new ArrayList<String>();

	SubJavaBean subJavaBean = new SubJavaBean();
	SubJavaBean[] subJavaBeanArray;
	List<SubJavaBean> subJavaBeanList = new ArrayList<SubJavaBean>();

}
