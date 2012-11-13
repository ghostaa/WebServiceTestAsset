package com.ibm.btt.wsc.mapper.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.DSEInvalidArgumentException;
import com.ibm.btt.base.DSEInvalidRequestException;
import com.ibm.btt.base.DSEObjectNotFoundException;
import com.ibm.btt.base.DataField;
import com.ibm.btt.base.IndexedCollection;
import com.ibm.btt.base.KeyedCollection;
import com.ibm.btt.base.types.DSETypeException;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.bean.TypeManager;
import com.ibm.btt.config.InitManager;
import com.ibm.btt.wsc.mapper.beans.E2eaComplexTypeBean;
import com.ibm.btt.wsc.mapper.beans.E2eaPrimitiveTypeBean;
import com.ibm.btt.wsc.mapper.beans.E2eaSimpleTypeBean;

public class E2EAsteriskTestsArray extends MapperTestSuper {
	private static boolean appendEqualTrue = false;

	@Override
	protected void setUp() throws Exception {
		InitManager.reset("jar:///definitions/bttE2ea.xml");
	}

	/**
	 * map BTT data to web service data while destination are all of primitive
	 * types or primitive types of array, for map format definition, the value
	 * of byReference is set to true and value of append is set to ignore
	 */
	public void testPrimitiveTypeMap1() {
		try {
			tryPrimitiveTypeMap("primitiveTypeFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of primitive
	 * types or primitive types of array, the map format uses default attribute
	 * values
	 */
	public void testPrimitiveTypeMap2() {
		try {
			tryPrimitiveTypeMap("primitiveTypeDftByRefAppendFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of primitive
	 * types or primitive types of array, for map format definition, the value
	 * of byReference is set to false and value of append is default
	 */
	public void testPrimitiveTypeMap3() {
		try {
			tryPrimitiveTypeMap("primitiveTypeByRefFalseFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of primitive
	 * types or primitive types of array, for map format definition, the value
	 * of append is set to false and value of byReference is default
	 */
	public void testPrimitiveTypeMap4() {
		try {
			tryPrimitiveTypeMap("primitiveTypeAppendFalseFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of primitive
	 * types or primitive types of array, for map format definition, the value
	 * of append is set to true and value of byReference is default
	 */
	public void testPrimitiveTypeMap5() {
		try {
			tryPrimitiveTypeMap("primitiveTypeAppendTrueFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	private void tryPrimitiveTypeMap(String format) throws Exception {
		TypeManager.treatClassAsSimpleType(Calendar.class);

		String prefix = "primitiveLa.";
		Context ctxt = getContext("primitiveLaDataCtxt");
		fillDefaultValuesToPrimitiveBean(ctxt.getKeyedCollection(), prefix);
		System.out.println(ctxt.getKeyedCollection());
		WSMapperConverter mapper = getFormat(format);
		E2eaPrimitiveTypeBean obj = (E2eaPrimitiveTypeBean) mapper.mapContextToObject(ctxt);
		assertPrimitiveBeanValueEqual(ctxt.getKeyedCollection(), prefix, obj);
	}

	/**
	 * map BTT data to web service data while destination are all of simple java
	 * types or simple java types of array, for map format definition, the value
	 * of byReference is set to true and value of append is set to ignore
	 */
	public void testSimpleTypeMap1() {
		try {
			trySimpleTypeMap("simpleTypeFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of simple java
	 * types or simple java types of array, the map format uses default
	 * attribute values
	 */
	public void testSimpleTypeMap2() {
		try {
			trySimpleTypeMap("simpleTypeDftByRefAppendFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of simple java
	 * types or simple java types of array, for map format definition, the value
	 * of byReference is set to false and value of append is default
	 */
	public void testSimpleTypeMap3() {
		try {
			trySimpleTypeMap("simpleTypeByRefFalseFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of simple java
	 * types or simple java types of array, for map format definition, the value
	 * of byReference is default and value of append is set to false
	 */
	public void testSimpleTypeMap4() {
		try {
			trySimpleTypeMap("simpleTypeAppendFalseFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of simple java
	 * types or simple java types of array, for map format definition, the value
	 * of byReference is set to default and value of append is set to true
	 */
	public void testSimpleTypeMap5() {
		appendEqualTrue = true;
		try {
			trySimpleTypeMap("simpleTypeAppendTrueFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		} finally {
			appendEqualTrue = false;
		}
	}

	private void trySimpleTypeMap(String format) throws Exception {
		TypeManager.treatClassAsSimpleType(Calendar.class);
		String prefix = "simpleLa.";
		Context ctxt = getContext("simpleLaDataCtxt");
		// System.out.println(ctxt.getKeyedCollection());
		fillDefaultValuesToSimpleBean(ctxt.getKeyedCollection(), prefix);
		System.out.println(ctxt.getKeyedCollection());
		WSMapperConverter mapper = getFormat(format);
		E2eaSimpleTypeBean obj = (E2eaSimpleTypeBean) mapper.mapContextToObject(ctxt);
		assertSimpleBeanValueEqual(ctxt.getKeyedCollection(), prefix, obj);
	}

	/**
	 * map BTT data to web service data while destination are all of complex
	 * types or complex types of array, for map format definition, the value of
	 * byReference is set to default and value of append is set to true
	 */
	public void testComplexTypeMap1() {
		try {
			tryComplexTypeMap("complexTypeFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of complex
	 * types or complex types of array, the map format uses default attribute
	 * values
	 */
	public void testComplexTypeMap2() {
		try {
			tryComplexTypeMap("complexTypeDftByRefAppendFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of complex
	 * types or complex types of array, for map format definition, the value of
	 * byReference is set to default and value of append is set to true
	 */
	public void testComplexTypeMap3() {
		try {
			tryComplexTypeMap("complexTypeByRefFalseFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of complex
	 * types or complex types of array, for map format definition, the value of
	 * byReference is set to default and value of append is set to true
	 */
	public void testComplexTypeMap4() {
		try {
			tryComplexTypeMap("complexTypeAppendFalseFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map BTT data to web service data while destination are all of complex
	 * types or complex types of array, for map format definition, the value of
	 * byReference is set to default and value of append is set to true
	 */
	public void testComplexTypeMap5() {
		appendEqualTrue = true;
		try {
			tryComplexTypeMap("complexTypeAppendTrueFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		} finally {
			appendEqualTrue = false;
		}
	}

	private void tryComplexTypeMap(String format) throws Exception {
		TypeManager.treatClassAsSimpleType(Calendar.class);

		String prefix1 = "complexLa.primitiveLa.";
		String prefix2 = "complexLa.simpleLa.";
		String prefix3 = "";
		String prefix4 = "";
		Context ctxt = getContext("complexLaDataCtxt");
		fillDefaultValuesToPrimitiveBean(ctxt.getKeyedCollection(), prefix1);
		fillDefaultValuesToSimpleBean(ctxt.getKeyedCollection(), prefix2);

		IndexedCollection primitiveLaIColl = (IndexedCollection) ctxt.getElementAt("complexLa.primitiveLaIColl");
		primitiveLaIColl.removeAll();
		for (int i = 0; i < 0; i++) {
			KeyedCollection kcoll = (KeyedCollection) primitiveLaIColl.createElement(false);
			fillDefaultValuesToPrimitiveBean(kcoll, prefix3);
			primitiveLaIColl.addElement(kcoll);
		}

		IndexedCollection simpleLaIColl = (IndexedCollection) ctxt.getElementAt("complexLa.simpleLaIColl");
		simpleLaIColl.removeAll();
		for (int i = 0; i < 3; i++) {
			KeyedCollection kcoll = (KeyedCollection) simpleLaIColl.createElement(false);
			fillDefaultValuesToSimpleBean(kcoll, prefix4);
			simpleLaIColl.addElement(kcoll);
		}

		IndexedCollection primitiveLaIColl2 = (IndexedCollection) ctxt.getElementAt("complexLa.primitiveLaIColl2");
		primitiveLaIColl2.removeAll();
		for (int i = 0; i < 1; i++) {
			KeyedCollection kcoll = (KeyedCollection) primitiveLaIColl2.createElement(true);
			fillDefaultValuesToPrimitiveBean(kcoll, prefix3);
			primitiveLaIColl2.addElement(kcoll);
		}

		IndexedCollection simpleLaIColl2 = (IndexedCollection) ctxt.getElementAt("complexLa.simpleLaIColl2");
		simpleLaIColl2.removeAll();
		for (int i = 0; i < 2; i++) {
			KeyedCollection kcoll = (KeyedCollection) simpleLaIColl2.createElement(true);
			fillDefaultValuesToSimpleBean(kcoll, prefix4);
			simpleLaIColl2.addElement(kcoll);
		}

		System.out.println(ctxt.getKeyedCollection());
		WSMapperConverter mapper = getFormat(format);
		E2eaComplexTypeBean obj = (E2eaComplexTypeBean) mapper.mapContextToObject(ctxt);
		assertComplexBeanValueEqual(ctxt, obj);
	}

	// ///////////////////////////////////////////
	static Random rand = new Random();
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	static void fillDefaultValuesToPrimitiveBean(KeyedCollection kcoll, String prefix) throws DSEInvalidArgumentException,
			DSEObjectNotFoundException, DSEInvalidRequestException, DSETypeException {
		// fields
		kcoll.setValueAt(prefix + "intField", rand.nextInt());
		kcoll.setValueAt(prefix + "longField", rand.nextLong());
		kcoll.setValueAt(prefix + "booleanField", rand.nextBoolean());
		kcoll.setValueAt(prefix + "floatField", rand.nextFloat() * 1024);
		kcoll.setValueAt(prefix + "doubleField", rand.nextDouble() * 512);
		kcoll.setValueAt(prefix + "charField", (char) rand.nextInt(Character.MAX_VALUE));
		kcoll.setValueAt(prefix + "shortField", (short) rand.nextInt(Short.MAX_VALUE));
		Object obj = kcoll.getValueAt(prefix + "shortField");
		System.out.print(obj.getClass().getSimpleName());
		kcoll.setValueAt(prefix + "byteField", (byte) rand.nextInt(Byte.MAX_VALUE));

		// indexed collections
		// size equals to destination bean's array
		IndexedCollection intIColl = (IndexedCollection) kcoll.getElementAt(prefix + "intIColl");
		intIColl.removeAll();
		for (int i = 0; i < 1; i++) {
			DataField df = (DataField) intIColl.createElement(false);
			df.setValue(rand.nextInt());
			intIColl.addElement(df);
		}

		// size equals to destination bean's array
		IndexedCollection longIColl = (IndexedCollection) kcoll.getElementAt(prefix + "longIColl");
		longIColl.removeAll();
		for (int i = 0; i < 0; i++) {
			DataField df = (DataField) longIColl.createElement(false);
			df.setValue(rand.nextLong());
			longIColl.addElement(df);
		}

		// size smaller than destination bean's array
		IndexedCollection booleanIColl = (IndexedCollection) kcoll.getElementAt(prefix + "booleanIColl");
		booleanIColl.removeAll();
		for (int i = 0; i < 2; i++) {
			DataField df = (DataField) booleanIColl.createElement(false);
			df.setValue(rand.nextBoolean());
			booleanIColl.addElement(df);
		}

		// size greater than destination bean's array
		IndexedCollection floatIColl = (IndexedCollection) kcoll.getElementAt(prefix + "floatIColl");
		floatIColl.removeAll();
		for (int i = 0; i < 3; i++) {
			DataField df = (DataField) floatIColl.createElement(false);
			df.setValue(rand.nextFloat());
			floatIColl.addElement(df);
		}

		// size greater than destination bean's array
		IndexedCollection doubleIColl = (IndexedCollection) kcoll.getElementAt(prefix + "doubleIColl");
		doubleIColl.removeAll();
		for (int i = 0; i < 3; i++) {
			DataField df = (DataField) doubleIColl.createElement(false);
			df.setValue(rand.nextDouble());
			doubleIColl.addElement(df);
		}

		// size equals to destination bean's array
		IndexedCollection charIColl = (IndexedCollection) kcoll.getElementAt(prefix + "charIColl");
		charIColl.removeAll();
		for (int i = 0; i < 0; i++) {
			DataField df = (DataField) charIColl.createElement(false);
			df.setValue((char) rand.nextInt(Character.MAX_VALUE));
			charIColl.addElement(df);
		}

		// size greater than destination bean's array
		IndexedCollection shortIColl = (IndexedCollection) kcoll.getElementAt(prefix + "shortIColl");
		shortIColl.removeAll();
		for (int i = 0; i < 4; i++) {
			DataField df = (DataField) shortIColl.createElement(false);
			df.setValue(new Short((short) rand.nextInt(Short.MAX_VALUE)));
			shortIColl.addElement(df);
		}

		DataField byteIColl = (DataField) kcoll.getElementAt(prefix + "byteIColl");
		byteIColl.setValidValue("ABC".getBytes());
		// size less than destination bean's array
//		IndexedCollection byteIColl = (IndexedCollection) kcoll.getElementAt(prefix + "byteIColl");
//		byteIColl.removeAll();
//		for (int i = 0; i < 0; i++) {
//			DataField df = (DataField) byteIColl.createElement(false);
//			df.setValue((byte) rand.nextInt(Byte.MAX_VALUE));
//			byteIColl.addElement(df);
//		}
	}

	static void assertPrimitiveBeanValueEqual(KeyedCollection kcoll, String prefix, E2eaPrimitiveTypeBean obj)
			throws DSEObjectNotFoundException {
		assertEquals(kcoll.getValueAt(prefix + "byteField"), obj.getByteField());
		assertEquals(kcoll.getValueAt(prefix + "booleanField"), obj.isBooleanField());
		assertEquals(kcoll.getValueAt(prefix + "doubleField"), obj.getDoubleField());
		assertEquals(kcoll.getValueAt(prefix + "floatField"), obj.getFloatField());
		assertEquals(kcoll.getValueAt(prefix + "intField"), obj.getIntField());
		assertEquals(kcoll.getValueAt(prefix + "longField"), obj.getLongField());
		assertEquals(kcoll.getValueAt(prefix + "shortField"), obj.getShortField());

		// indexed collections
		// size equals to destination bean's array
		IndexedCollection intIColl = (IndexedCollection) kcoll.getElementAt(prefix + "intIColl");
		assertEquals(intIColl.size(), obj.getIntIColl().length);
		for (int i = 0; i < 1; i++) {
			assertEquals(intIColl.getValueAt(String.valueOf(i)), obj.getIntIColl()[i]);
		}

		// size equals to destination bean's array
		IndexedCollection longIColl = (IndexedCollection) kcoll.getElementAt(prefix + "longIColl");
		assertEquals(longIColl.size(), obj.getLongIColl().length);
		for (int i = 0; i < longIColl.size(); i++) {
			assertEquals(longIColl.getValueAt(String.valueOf(i)), obj.getLongIColl()[i]);
		}

		// size smaller than destination bean's array
		IndexedCollection booleanIColl = (IndexedCollection) kcoll.getElementAt(prefix + "booleanIColl");
		assertEquals(booleanIColl.size(), obj.getBooleanIColl().length);
		for (int i = 0; i < 2; i++) {
			assertEquals(booleanIColl.getValueAt(String.valueOf(i)), obj.getBooleanIColl()[i]);
		}

		// size greater than destination bean's array
		IndexedCollection floatIColl = (IndexedCollection) kcoll.getElementAt(prefix + "floatIColl");
		assertEquals(floatIColl.size(), obj.getFloatIColl().length);
		for (int i = 0; i < 3; i++) {
			assertEquals(floatIColl.getValueAt(String.valueOf(i)), obj.getFloatIColl()[i]);
		}

		// size greater than destination bean's array
		IndexedCollection doubleIColl = (IndexedCollection) kcoll.getElementAt(prefix + "doubleIColl");
		assertEquals(doubleIColl.size(), obj.getDoubleIColl().length);
		for (int i = 0; i < 3; i++) {
			assertEquals(doubleIColl.getValueAt(String.valueOf(i)), obj.getDoubleIColl()[i]);
		}

		// size equals to destination bean's array
		IndexedCollection charIColl = (IndexedCollection) kcoll.getElementAt(prefix + "charIColl");
		assertEquals(charIColl.size(), obj.getCharIColl().length);
		for (int i = 0; i < 0; i++) {
			assertEquals(charIColl.getValueAt(String.valueOf(i)), obj.getCharIColl()[i]);
		}

		// size greater than destination bean's array
		IndexedCollection shortIColl = (IndexedCollection) kcoll.getElementAt(prefix + "shortIColl");
		assertEquals(shortIColl.size(), obj.getShortIColl().length);
		for (int i = 0; i < 4; i++) {
			assertEquals(shortIColl.getValueAt(String.valueOf(i)), obj.getShortIColl()[i]);
		}

		DataField byteIColl = (DataField) kcoll.getElementAt(prefix + "byteIColl");
		byte[] byts = "ABC".getBytes();
		byte[] bytes = (byte[])byteIColl.getValue();
		assertEquals(byts.length,bytes.length);
		for(int i=0;i<byts.length;i++)
			assertEquals(byts[i],bytes[i]);
		
		// size less than destination bean's array
//		IndexedCollection byteIColl = (IndexedCollection) kcoll.getElementAt(prefix + "byteIColl");
//		assertEquals(byteIColl.size(), obj.getByteIColl().length);
//		for (int i = 0; i < 0; i++) {
//			assertEquals(intIColl.getValueAt(String.valueOf(i)), obj.getIntIColl()[i]);
//		}
	}

	static void fillDefaultValuesToSimpleBean(KeyedCollection kcoll, String prefix) throws DSEInvalidArgumentException,
			DSEObjectNotFoundException, DSEInvalidRequestException, ParseException {
		System.out.println(kcoll);
		// fields
		kcoll.setValueAt(prefix + "stringField", "IVAN" + rand.nextLong());
		kcoll.setValueAt(prefix + "integerField", new Integer(rand.nextInt()));
		kcoll.setValueAt(prefix + "bigDecimalField", new BigDecimal(rand.nextDouble() * rand.nextInt(1024)));
		kcoll.setValueAt(prefix + "dateField", sdf.parse("20101010"));
		kcoll.setValueAt(prefix + "calendarField", Calendar.getInstance());
		kcoll.setValueAt(prefix + "uuidField", String.valueOf(rand.nextLong()));

		// indexed collections
		// size greater than destination bean's array
		IndexedCollection stringIColl = (IndexedCollection) kcoll.getElementAt(prefix + "stringIColl");
		stringIColl.removeAll();
		for (int i = 0; i < 2; i++) {
			DataField df = (DataField) stringIColl.createElement(false);
			df.setValue(i == 1 ? null :"LVST" + rand.nextInt());
			stringIColl.addElement(df);
		}

		// size equals to destination bean's array
		IndexedCollection integerIColl = (IndexedCollection) kcoll.getElementAt(prefix + "integerIColl");
		integerIColl.removeAll();
		for (int i = 0; i < 3; i++) {
			DataField df = (DataField) integerIColl.createElement(true);
			df.setValue(i == 1 ? null :new Integer(rand.nextInt()));
			integerIColl.addElement(df);
		}

		// size smaller than destination bean's array
		IndexedCollection bigDecimalIColl = (IndexedCollection) kcoll.getElementAt(prefix + "bigDecimalIColl");
		bigDecimalIColl.removeAll();
		for (int i = 0; i < 2; i++) {
			DataField df = (DataField) bigDecimalIColl.createElement(false);
			df.setValue(i == 1 ? null :new BigDecimal(rand.nextFloat() * 1024));
			bigDecimalIColl.addElement(df);
		}

		// size equals to destination bean's array
		IndexedCollection dateIColl = (IndexedCollection) kcoll.getElementAt(prefix + "dateIColl");
		dateIColl.removeAll();
		for (int i = 0; i < 3; i++) {
			DataField df = (DataField) dateIColl.createElement(true);
			df.setValue(i == 1 ? null :rand.nextBoolean() ? new Date() : sdf.parse("19830915"));
			dateIColl.addElement(df);
		}

		// size greater than destination bean's array
		IndexedCollection calendarIColl = (IndexedCollection) kcoll.getElementAt(prefix + "calendarIColl");
		calendarIColl.removeAll();
		for (int i = 0; i < 3; i++) {
			DataField df = (DataField) calendarIColl.createElement(false);
			df.setValue(i == 1 ? null :Calendar.getInstance());
			calendarIColl.addElement(df);
		}

		// size equals to destination bean's array
		IndexedCollection uuidIColl = (IndexedCollection) kcoll.getElementAt(prefix + "uuidIColl");
		uuidIColl.removeAll();
		for (int i = 0; i < 0; i++) {
			DataField df = (DataField) uuidIColl.createElement(false);
			df.setValue(i == 1 ? null :String.valueOf(rand.nextLong()));
			uuidIColl.addElement(df);
		}
	}

	static void assertSimpleBeanValueEqual(KeyedCollection kcoll, String prefix, E2eaSimpleTypeBean obj)
			throws DSEObjectNotFoundException {
		// fields
		assertEquals(kcoll.getValueAt(prefix + "stringField"), obj.getStringField());
		assertEquals(kcoll.getValueAt(prefix + "integerField"), obj.getIntegerField());
		assertEquals(kcoll.getValueAt(prefix + "bigDecimalField"), obj.getBigDecimalField());
		assertEquals(kcoll.getValueAt(prefix + "dateField"), obj.getDateField());
		assertEquals(kcoll.getValueAt(prefix + "calendarField"), obj.getCalendarField());
		assertEquals(kcoll.getValueAt(prefix + "uuidField"), obj.getUuidField());

		// indexed collections
		IndexedCollection stringIColl = (IndexedCollection) kcoll.getElementAt(prefix + "stringIColl");
		assertEquals(stringIColl.size(), obj.getStringIColl().length);
		for (int i = 0; i < 2; i++) {
			assertEquals(stringIColl.getValueAt(String.valueOf(i)), obj.getStringIColl()[i]);
		}

		// destination bean's array have initial size
		IndexedCollection integerIColl = (IndexedCollection) kcoll.getElementAt(prefix + "integerIColl");
		if (appendEqualTrue) {
			assertEquals(3 + integerIColl.size(), obj.getIntegerIColl().length);
			for (int i = 0; i < 3; i++) {
				assertEquals(integerIColl.getValueAt(String.valueOf(i)), obj.getIntegerIColl()[i + 3]);
			}
		} else {
			assertEquals(integerIColl.size(), obj.getIntegerIColl().length);
			for (int i = 0; i < 3; i++) {
				assertEquals(integerIColl.getValueAt(String.valueOf(i)), obj.getIntegerIColl()[i]);
			}
		}

		// size smaller than destination bean's array
		IndexedCollection bigDecimalIColl = (IndexedCollection) kcoll.getElementAt(prefix + "bigDecimalIColl");
		assertEquals(bigDecimalIColl.size(), obj.getBigDecimalIColl().length);
		for (int i = 0; i < 2; i++) {
			assertEquals(bigDecimalIColl.getValueAt(String.valueOf(i)), obj.getBigDecimalIColl()[i]);
		}

		// size equals to destination bean's array
		IndexedCollection dateIColl = (IndexedCollection) kcoll.getElementAt(prefix + "dateIColl");
		assertEquals(dateIColl.size(), obj.getDateIColl().length);
		for (int i = 0; i < 3; i++) {
			assertEquals(dateIColl.getValueAt(String.valueOf(i)), obj.getDateIColl()[i]);
		}

		// size greater than destination bean's array
		IndexedCollection calendarIColl = (IndexedCollection) kcoll.getElementAt(prefix + "calendarIColl");
		assertEquals(calendarIColl.size(), obj.getCalendarIColl().length);
		for (int i = 0; i < 3; i++) {
			assertEquals(calendarIColl.getValueAt(String.valueOf(i)), obj.getCalendarIColl()[i]);
		}

		// size equals to destination bean's array
		IndexedCollection uuidIColl = (IndexedCollection) kcoll.getElementAt(prefix + "uuidIColl");
		assertEquals(uuidIColl.size(), obj.getUuidIColl().length);
		for (int i = 0; i < 0; i++) {
			assertEquals(uuidIColl.getValueAt(String.valueOf(i)), obj.getUuidIColl()[i]);
		}
	}

	static void assertComplexBeanValueEqual(Context ctxt, E2eaComplexTypeBean obj) throws DSEObjectNotFoundException,
			DSEInvalidRequestException {
		String prefix1 = "complexLa.primitiveLa.";
		String prefix2 = "complexLa.simpleLa.";
		String prefix3 = "";
		String prefix4 = "";
		assertPrimitiveBeanValueEqual(ctxt.getKeyedCollection(), prefix1, obj.getPrimitiveLa());
		assertSimpleBeanValueEqual(ctxt.getKeyedCollection(), prefix2, obj.getSimpleLa());

		IndexedCollection primitiveLaIColl = (IndexedCollection) ctxt.getElementAt("complexLa.primitiveLaIColl");
		assertEquals(primitiveLaIColl.size(), obj.getPrimitiveLaIColl().length);
		for (int i = 0; i < primitiveLaIColl.size(); i++) {
			KeyedCollection kcoll = (KeyedCollection) primitiveLaIColl.createElement(false);
			assertPrimitiveBeanValueEqual(kcoll, prefix3, obj.getPrimitiveLaIColl()[i]);
		}

		IndexedCollection simpleLaIColl = (IndexedCollection) ctxt.getElementAt("complexLa.simpleLaIColl");
		if (appendEqualTrue) {
			assertEquals(2 + simpleLaIColl.size(), obj.getSimpleLaIColl().length);
			for (int i = 0; i < simpleLaIColl.size(); i++) {
				KeyedCollection kcoll = (KeyedCollection) simpleLaIColl.getElementAt(i);
				assertSimpleBeanValueEqual(kcoll, prefix4, obj.getSimpleLaIColl()[i + 2]);
			}
		} else {
			assertEquals(simpleLaIColl.size(), obj.getSimpleLaIColl().length);
			for (int i = 0; i < simpleLaIColl.size(); i++) {
				KeyedCollection kcoll = (KeyedCollection) simpleLaIColl.getElementAt(i);
				assertSimpleBeanValueEqual(kcoll, prefix4, obj.getSimpleLaIColl()[i]);
			}
		}

		IndexedCollection primitiveLaIColl2 = (IndexedCollection) ctxt.getElementAt("complexLa.primitiveLaIColl2");
		if (appendEqualTrue) {
			assertEquals(1 + primitiveLaIColl2.size(), obj.getPrimitiveLaIColl2().length);
			for (int i = 0; i < primitiveLaIColl2.size(); i++) {
				KeyedCollection kcoll = (KeyedCollection) primitiveLaIColl2.getElementAt(i);
				assertPrimitiveBeanValueEqual(kcoll, prefix3, obj.getPrimitiveLaIColl2()[i + 1]);
			}
		} else {
			assertEquals(primitiveLaIColl2.size(), obj.getPrimitiveLaIColl2().length);
			for (int i = 0; i < primitiveLaIColl2.size(); i++) {
				KeyedCollection kcoll = (KeyedCollection) primitiveLaIColl2.getElementAt(i);
				assertPrimitiveBeanValueEqual(kcoll, prefix3, obj.getPrimitiveLaIColl2()[i]);
			}
		}

		IndexedCollection simpleLaIColl2 = (IndexedCollection) ctxt.getElementAt("complexLa.simpleLaIColl2");
		assertEquals(simpleLaIColl2.size(), obj.getSimpleLaIColl2().length);
		for (int i = 0; i < simpleLaIColl2.size(); i++) {
			KeyedCollection kcoll = (KeyedCollection) simpleLaIColl2.getElementAt(i);
			assertSimpleBeanValueEqual(kcoll, prefix4, obj.getSimpleLaIColl2()[i]);
		}
	}
}
