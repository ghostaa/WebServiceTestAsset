package com.ibm.btt.wsc.mapper.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.DSEInvalidArgumentException;
import com.ibm.btt.base.DSEInvalidClassException;
import com.ibm.btt.base.DSEObjectNotFoundException;
import com.ibm.btt.base.IndexedCollection;
import com.ibm.btt.base.KeyedCollection;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.bean.TypeManager;
import com.ibm.btt.config.InitManager;
import com.ibm.btt.wsc.mapper.beans.E2eaComplexTypeBeanList;
import com.ibm.btt.wsc.mapper.beans.E2eaPrimitiveTypeBeanList;
import com.ibm.btt.wsc.mapper.beans.E2eaSimpleTypeBeanList;

public class E2EAsteriskRevertTestsList extends MapperTestSuper {
	private static boolean appendEqualTrue = false;
	static Random rand = new Random();
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@Override
	protected void setUp() throws Exception {
		appendEqualTrue = false;
		// init btt
		InitManager.reset("jar:///definitionsE2EA/bttE2ea.xml");
	}

	/**
	 * test map from javaBean which nested primitive data and List<xxx> to
	 * context using complex type and true byReference and default append xxx
	 * represent complex type which according to simple type
	 */
	public void testPrimitiveListRevertTypeMap1() {
		try {
			tryPrimitivelistRevertTypeMap("primitiveTypeListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested primitive data and List<xxx> to
	 * context using complex type and default byReference and default append xxx
	 * represent complex type which according to simple type
	 */
	public void testPrimitiveListRevertTypeMap2() {
		try {
			tryPrimitivelistRevertTypeMap("primitiveTypeListDftByRefAppendRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested primitive data and List<xxx> to
	 * context using complex type and false byReference and default append xxx
	 * represent complex type which according to simple type
	 */
	public void testPrimitiveListRevertTypeMap3() {
		try {
			tryPrimitivelistRevertTypeMap("primitiveTypeListByRefFalseRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested primitive data and List<xxx> to
	 * context using complex type and default byReference and false append xxx
	 * represent complex type which according to simple type
	 */
	public void testPrimitiveListRevertTypeMap4() {
		try {
			tryPrimitivelistRevertTypeMap("primitiveTypeListAppendFalseRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested primitive data and List<xxx> to
	 * context using complex type and default byReference and true append xxx
	 * represent complex type which according to simple type
	 */
	public void testPrimitiveListRevertTypeMap5() {
		try {
			tryPrimitivelistRevertTypeMap("primitiveTypeListAppendTrueRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map javaBean which nested primitive and its List to context
	 */
	private void tryPrimitivelistRevertTypeMap(String format) throws Exception {
		TypeManager.treatClassAsSimpleType(Calendar.class);
		TypeManager.treatClassAsSimpleType(UUID.class);
		String prefix = "primitiveLa.";
		E2eaPrimitiveTypeBeanList e2eaPrimitiveTypeBeanList = new E2eaPrimitiveTypeBeanList();
		fillDefaultValuesToPrimitiveListBean(e2eaPrimitiveTypeBeanList);
		Context ctxt = getContext("primitiveLaDataCtxt");
		// //System.out.println(ctxt.getKeyedCollection());
		WSMapperConverter mapper = getFormat(format);
		mapper.mapObjectToContext(e2eaPrimitiveTypeBeanList, ctxt);

		KeyedCollection kcoll = ctxt.getKeyedCollection();
		assertPrimitiveListCtxValueEqual(kcoll, prefix, e2eaPrimitiveTypeBeanList);

	}

	/**
	 * assert map of javaBean which nested primitive and its List to context
	 */

	static void assertPrimitiveListCtxValueEqual(KeyedCollection kcoll, String prefix,
			E2eaPrimitiveTypeBeanList e2eaPrimitiveTypeBeanList) throws DSEObjectNotFoundException {
		assertNotNull(kcoll);
		assertEquals(e2eaPrimitiveTypeBeanList.getIntField(), kcoll.getValueAt(prefix + "intField"));
		assertEquals(e2eaPrimitiveTypeBeanList.isBooleanField(), kcoll.getValueAt(prefix + "booleanField"));
		assertEquals(e2eaPrimitiveTypeBeanList.getByteField(), kcoll.getValueAt(prefix + "byteField"));
		assertEquals(e2eaPrimitiveTypeBeanList.getCharField(), kcoll.getValueAt(prefix + "charField"));
		assertEquals(e2eaPrimitiveTypeBeanList.getFloatField(), kcoll.getValueAt(prefix + "floatField"));
		assertEquals(e2eaPrimitiveTypeBeanList.getDoubleField(), kcoll.getValueAt(prefix + "doubleField"));
		assertEquals(e2eaPrimitiveTypeBeanList.getLongField(), kcoll.getValueAt(prefix + "longField"));
		assertEquals(e2eaPrimitiveTypeBeanList.getShortField(), kcoll.getValueAt(prefix + "shortField"));

		IndexedCollection intIColl = (IndexedCollection) kcoll.getElementAt(prefix + "intIColl");
		// bean's array size equals to destination
		if (intIColl.getElements().size() <= e2eaPrimitiveTypeBeanList.getIntIColl().size()) {
			for (int i = 0; i < intIColl.getElements().size(); i++) {

				//System.out.println(e2eaPrimitiveTypeBeanList.getIntIColl().get(i) + ";;" + intIColl.getElementAt(i));
				assertEquals(e2eaPrimitiveTypeBeanList.getIntIColl().get(i), intIColl.getElementAt(i).getValue());
			}
		}

		IndexedCollection booleanIColl = (IndexedCollection) kcoll.getElementAt(prefix + "booleanIColl");
		// bean's array size less than to destination
		if (booleanIColl.getElements().size() <= e2eaPrimitiveTypeBeanList.getBooleanIColl().size()) {
			for (int i = 0; i < booleanIColl.getElements().size(); i++) {
				//System.out.println(booleanIColl.getElementAt(i).getValue());
				assertEquals(e2eaPrimitiveTypeBeanList.getBooleanIColl().get(i), booleanIColl.getElementAt(i).getValue());
			}
		}
		// bean's array size equals to destination 's
		IndexedCollection byteIColl = (IndexedCollection) kcoll.getElementAt(prefix + "byteIColl");

		if (byteIColl.getElements().size() <= e2eaPrimitiveTypeBeanList.getByteIColl().size()) {
			for (int i = 0; i < byteIColl.getElements().size(); i++) {
				//System.out.println(byteIColl.getElementAt(i).getValue());
				assertEquals(e2eaPrimitiveTypeBeanList.getByteIColl().get(i), byteIColl.getElementAt(i).getValue());
			}
		}

		// bean's array big than destination 's
		IndexedCollection charIColl = (IndexedCollection) kcoll.getElementAt(prefix + "charIColl");
		if (charIColl.getElements().size() <= e2eaPrimitiveTypeBeanList.getCharIColl().size()) {
			for (int i = 0; i < charIColl.getElements().size(); i++) {
				//System.out.println(charIColl.getElementAt(i).getValue());
				assertEquals(e2eaPrimitiveTypeBeanList.getCharIColl().get(i), charIColl.getElementAt(i).getValue());
			}
		}
		// bean's array big than destination 's
		IndexedCollection floatIColl = (IndexedCollection) kcoll.getElementAt(prefix + "floatIColl");

		if (floatIColl.getElements().size() <= e2eaPrimitiveTypeBeanList.getFloatIColl().size()) {
			for (int i = 0; i < floatIColl.getElements().size(); i++) {
				//System.out.println(floatIColl.getElementAt(i).getValue());
				assertEquals(e2eaPrimitiveTypeBeanList.getFloatIColl().get(i), floatIColl.getElementAt(i).getValue());
			}
		}
		// bean's array size equals to destination 's
		IndexedCollection doubleIColl = (IndexedCollection) kcoll.getElementAt(prefix + "doubleIColl");
		if (doubleIColl.getElements().size() <= e2eaPrimitiveTypeBeanList.getDoubleIColl().size()) {
			for (int i = 0; i < doubleIColl.getElements().size(); i++) {
				//System.out.println(doubleIColl.getElementAt(i).getValue());
				assertEquals(e2eaPrimitiveTypeBeanList.getDoubleIColl().get(i), doubleIColl.getElementAt(i).getValue());

			}
		}
		// bean's array big than destination 's
		IndexedCollection longIColl = (IndexedCollection) kcoll.getElementAt(prefix + "longIColl");
		if (longIColl.getElements().size() <= e2eaPrimitiveTypeBeanList.getLongIColl().size()) {
			for (int i = 0; i < longIColl.getElements().size(); i++) {
				//System.out.println(longIColl.getElementAt(i).getValue());
				assertEquals(e2eaPrimitiveTypeBeanList.getLongIColl().get(i), longIColl.getElementAt(i).getValue());

			}
		}
		// destination bean's array big than size greater than
		IndexedCollection shortIColl = (IndexedCollection) kcoll.getElementAt(prefix + "shortIColl");
		if (shortIColl.getElements().size() <= e2eaPrimitiveTypeBeanList.getShortIColl().size()) {
			for (int i = 0; i < shortIColl.getElements().size(); i++) {
				//System.out.println(shortIColl.getElementAt(i).getValue());
				assertEquals(e2eaPrimitiveTypeBeanList.getShortIColl().get(i), shortIColl.getElementAt(i).getValue());
			}
		}

	}

	/**
	 * init javaBean which nested primitive and its List
	 */
	private static void fillDefaultValuesToPrimitiveListBean(E2eaPrimitiveTypeBeanList e2eaPrimitiveTypeBeanList) {

		e2eaPrimitiveTypeBeanList.setIntField(rand.nextInt());
		e2eaPrimitiveTypeBeanList.setBooleanField(rand.nextBoolean());
		e2eaPrimitiveTypeBeanList.setFloatField(rand.nextFloat());
		e2eaPrimitiveTypeBeanList.setDoubleField(rand.nextDouble());
		e2eaPrimitiveTypeBeanList.setByteField((byte) rand.nextInt(Byte.MAX_VALUE));
		e2eaPrimitiveTypeBeanList.setCharField((char) rand.nextInt(Character.MAX_VALUE));
		e2eaPrimitiveTypeBeanList.setShortField((short) rand.nextInt(Short.MAX_VALUE));
		e2eaPrimitiveTypeBeanList.setLongField(rand.nextLong());

		// add initial values for testing
		List<Integer> intIColl = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			intIColl.add(new Integer(rand.nextInt()));
		}
		e2eaPrimitiveTypeBeanList.setIntIColl(intIColl);

		List<Boolean> booleanIColl = new ArrayList<Boolean>();
		for (int i = 0; i < 6; i++) {
			booleanIColl.add(new Boolean(rand.nextBoolean()));
		}
		e2eaPrimitiveTypeBeanList.setBooleanIColl(booleanIColl);

		List<Byte> byteIColl = new ArrayList<Byte>();
		for (int i = 0; i < 6; i++) {
			byteIColl.add(new Byte((byte) rand.nextInt(Byte.MAX_VALUE)));
		}
		e2eaPrimitiveTypeBeanList.setByteIColl(byteIColl);

		List<Character> charIColl = new ArrayList<Character>();
		for (int i = 0; i < 6; i++) {
			charIColl.add(new Character((char) rand.nextInt(Character.MAX_VALUE)));
		}

		e2eaPrimitiveTypeBeanList.setCharIColl(charIColl);

		List<Double> doubleIColl = new ArrayList<Double>();
		for (int i = 0; i < 6; i++) {
			doubleIColl.add(new Double(rand.nextDouble()));
		}
		e2eaPrimitiveTypeBeanList.setDoubleIColl(doubleIColl);

		List<Float> floatIColl = new ArrayList<Float>();
		for (int i = 0; i < 6; i++) {
			floatIColl.add(new Float(rand.nextFloat()));
		}
		e2eaPrimitiveTypeBeanList.setFloatIColl(floatIColl);

		List<Long> longIColl = new ArrayList<Long>();
		for (int i = 0; i < 6; i++) {
			longIColl.add(new Long(rand.nextLong()));
		}
		e2eaPrimitiveTypeBeanList.setLongIColl(longIColl);

		List<Short> shortIColl = new ArrayList<Short>();
		for (int i = 0; i < 6; i++) {
			shortIColl.add(new Short((short) rand.nextInt(Short.MAX_VALUE)));
		}
		e2eaPrimitiveTypeBeanList.setShortIColl(shortIColl);
	}

	/* ========================================================================= */
	/**
	 * test map from javaBean which nested simple object data and List<xxx> to
	 * context using complex type and true byReference and ignore append xxx
	 * represent common complex data
	 */
	public void testSimpleListRevertTypeMap1() {
		try {
			trySimplelistRevertTypeMap("simpleTypeListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple object data and List<xxx> to
	 * context using complex type and default byReference and default append xxx
	 * represent common complex data
	 */
	public void testSimpleListRevertTypeMap2() {
		try {
			trySimplelistRevertTypeMap("simpleTypeDftByRefAppendListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple object data and List<xxx> to
	 * context using complex type and false byReference and default appendxxx
	 * represent common complex data
	 */
	public void testSimpleListRevertTypeMap3() {
		try {
			trySimplelistRevertTypeMap("simpleTypeByRefFalseListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple object data and List<xxx> to
	 * context using complex type and default byReference and false append xxx
	 * represent common complex data
	 */
	public void testSimpleListRevertTypeMap4() {
		try {
			trySimplelistRevertTypeMap("simpleTypeAppendFalseListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple object data and List<xxx> to
	 * context using complex type and default byReference and true append xxx
	 * represent common complex data
	 */
	public void testSimpleListRevertTypeMap5() {
		try {
			trySimplelistRevertTypeMap("simpleTypeAppendTrueListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map javaBean which nested simple type data and its List to context
	 */
	private void trySimplelistRevertTypeMap(String format) throws Exception {
		TypeManager.treatClassAsSimpleType(Calendar.class);
		TypeManager.treatClassAsSimpleType(UUID.class);
		String prefix = "simpleLa.";
		E2eaSimpleTypeBeanList e2eaSimpleTypeBeanList = new E2eaSimpleTypeBeanList();
		fillDefaultValuesToSimpleListBean(e2eaSimpleTypeBeanList);
		Context ctxt = getContext("simpleLaDataCtxt");
		//System.out.println(ctxt.getKeyedCollection());
		WSMapperConverter mapper = getFormat(format);
		mapper.mapObjectToContext(e2eaSimpleTypeBeanList, ctxt);

		KeyedCollection kcoll = ctxt.getKeyedCollection();
		assertSimpleListCtxValueEqual(kcoll, prefix, e2eaSimpleTypeBeanList);

	}

	/**
	 * assert map of javaBean which nested simple and its List to context
	 */
	private static void assertSimpleListCtxValueEqual(KeyedCollection kcoll, String prefix,
			E2eaSimpleTypeBeanList e2eaSimpleTypeBeanList) throws DSEObjectNotFoundException {
		//System.out.println(prefix + "***************");
		assertNotNull(kcoll);
		assertEquals(e2eaSimpleTypeBeanList.getStringField(), kcoll.getValueAt(prefix + "stringField"));
		assertEquals(e2eaSimpleTypeBeanList.getIntegerField(), kcoll.getValueAt(prefix + "integerField"));
		assertEquals(e2eaSimpleTypeBeanList.getBigDecimalField(), kcoll.getValueAt(prefix + "bigDecimalField"));
		assertEquals(e2eaSimpleTypeBeanList.getDateField(), kcoll.getValueAt(prefix + "dateField"));
		assertEquals(e2eaSimpleTypeBeanList.getCalendarField(), kcoll.getValueAt(prefix + "calendarField"));
		assertEquals(e2eaSimpleTypeBeanList.getUuidField(), kcoll.getValueAt(prefix + "uuidField"));

		IndexedCollection stringIColl = (IndexedCollection) kcoll.getElementAt(prefix + "stringIColl");
		if (stringIColl.getElements().size() <= e2eaSimpleTypeBeanList.getStringIColl().size()) {
			// bean's array size big than destination 's
			for (int i = 0; i < stringIColl.getElements().size(); i++) {
				//System.out.println(e2eaSimpleTypeBeanList.getStringIColl().get(i) + ";;" + stringIColl.getElementAt(i));
				assertEquals(e2eaSimpleTypeBeanList.getStringIColl().get(i), stringIColl.getElementAt(i).getValue());
			}
		}
		IndexedCollection integerIColl = (IndexedCollection) kcoll.getElementAt(prefix + "integerIColl");

		if (integerIColl.getElements().size() <= e2eaSimpleTypeBeanList.getIntegerIColl().size()) {

			// bean's array size less than destination 's
			for (int i = 0; i < integerIColl.getElements().size(); i++) {

				assertEquals(e2eaSimpleTypeBeanList.getIntegerIColl().get(i), integerIColl.getElementAt(i).getValue());
			}
			// bean's array size less than destination 's
			IndexedCollection bigDecimalIColl = (IndexedCollection) kcoll.getElementAt(prefix + "bigDecimalIColl");
			if (bigDecimalIColl.getElements().size() <= e2eaSimpleTypeBeanList.getBigDecimalIColl().size()) {
				for (int i = 0; i < bigDecimalIColl.getElements().size(); i++) {
					//System.out.println(bigDecimalIColl.getElementAt(i).getValue());
					assertEquals(e2eaSimpleTypeBeanList.getBigDecimalIColl().get(i), bigDecimalIColl.getElementAt(i).getValue());
				}
			}
			// bean's array less than destination 's
			IndexedCollection dateIColl = (IndexedCollection) kcoll.getElementAt(prefix + "dateIColl");
			if (dateIColl.getElements().size() <= e2eaSimpleTypeBeanList.getDateIColl().size()) {
				for (int i = 0; i < dateIColl.getElements().size(); i++) {
					//System.out.println(dateIColl.getElementAt(i).getValue());
					assertEquals(e2eaSimpleTypeBeanList.getDateIColl().get(i), dateIColl.getElementAt(i).getValue());
				}
			}
			// bean's array less than destination 's
			IndexedCollection calendarIColl = (IndexedCollection) kcoll.getElementAt(prefix + "calendarIColl");
			if (calendarIColl.getElements().size() <= e2eaSimpleTypeBeanList.getCalendarIColl().size()) {
				for (int i = 0; i < calendarIColl.getElements().size(); i++) {
					//System.out.println(calendarIColl.getElementAt(i).getValue());
					assertEquals(e2eaSimpleTypeBeanList.getCalendarIColl().get(i), calendarIColl.getElementAt(i).getValue());
				}
			}

			// bean's array size big than to destination 's
			IndexedCollection uuidIColl = (IndexedCollection) kcoll.getElementAt(prefix + "uuidIColl");
			if (uuidIColl.getElements().size() <= e2eaSimpleTypeBeanList.getCalendarIColl().size()) {
				for (int i = 0; i < uuidIColl.getElements().size(); i++) {
					//System.out.println(uuidIColl.getElementAt(i).getValue());
					assertEquals(e2eaSimpleTypeBeanList.getUuidIColl().get(i), uuidIColl.getElementAt(i).getValue());

				}
			}
		}
	}

	/**
	 * init bean which nested simple and its List object
	 */
	static void fillDefaultValuesToSimpleListBean(E2eaSimpleTypeBeanList e2eaSimpleTypeBeanList) throws ParseException {
		e2eaSimpleTypeBeanList.setStringField("O2CMC2" + rand.nextLong());
		e2eaSimpleTypeBeanList.setIntegerField(new Integer(rand.nextInt()));
		e2eaSimpleTypeBeanList.setDateField(sdf.parse("20010116"));
		e2eaSimpleTypeBeanList.setCalendarField(sdf.getCalendar());
		e2eaSimpleTypeBeanList.setBigDecimalField(new BigDecimal(rand.nextDouble() * rand.nextLong()));
		e2eaSimpleTypeBeanList.setInterference1("O2CMC2" + rand.nextLong());
		e2eaSimpleTypeBeanList.setUuidField(String.valueOf(rand.nextLong()));

		List<String> stringIColl = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			if (i > 0 && i % 2 == 0)
				stringIColl.add(null);
			stringIColl.add("2CMC2O" + rand.nextLong());
		}
		e2eaSimpleTypeBeanList.setStringIColl(stringIColl);

		List<Integer> integerIColl = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			integerIColl.add(new Integer(rand.nextInt()));
		}
		e2eaSimpleTypeBeanList.setIntegerIColl(integerIColl);

		List<Date> dateIColl = new ArrayList<Date>();
		for (int i = 0; i < 6; i++) {
			dateIColl.add(sdf.parse("20010116"));
		}
		e2eaSimpleTypeBeanList.setDateIColl(dateIColl);

		List<Calendar> calendarIColl = new ArrayList<Calendar>();
		for (int i = 0; i < 6; i++) {
			calendarIColl.add(sdf.getCalendar());
		}
		e2eaSimpleTypeBeanList.setCalendarIColl(calendarIColl);

		List<BigDecimal> bigDecimalIColl = new ArrayList<BigDecimal>();
		for (int i = 0; i < 6; i++) {
			bigDecimalIColl.add(new BigDecimal(rand.nextDouble() * rand.nextLong()));
		}
		e2eaSimpleTypeBeanList.setBigDecimalIColl(bigDecimalIColl);

		List<Object> objectIColl = new ArrayList<Object>();
		for (int i = 0; i < 6; i++) {
			objectIColl.add((Object) new Float(rand.nextFloat()));
		}
		e2eaSimpleTypeBeanList.setInterferenceIColl(objectIColl);

		List<String> uuidIColl = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			uuidIColl.add(UUID.randomUUID().toString());
		}
		e2eaSimpleTypeBeanList.setUuidIColl(uuidIColl);

	}

	/* ========================================================================= */

	/**
	 * test map from javaBean which nested javaBean and List<javaBean> to
	 * context using complex type and true byReference and ignore append
	 */
	public void testComplexListRevertTypeMap1() {
		try {
			tryComplexListTypeMap("complexTypeListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple data and List<xxx> to context
	 * using complex type and default byReference and default append
	 */
	public void testComplexListRevertTypeMap2() {
		try {
			tryComplexListTypeMap("complexTypeDftByRefAppendListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple data and List<xxx> to context
	 * using complex type and false byReference and default append
	 */
	public void testComplexListRevertTypeMap3() {
		try {
			tryComplexListTypeMap("complexTypeByRefFalseListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple data and List<xxx> to context
	 * using complex type and default byReference and false append
	 */
	public void testComplexListRevertTypeMap4() {
		try {
			tryComplexListTypeMap("complexTypeAppendFalseListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple data and List<xxx> to context
	 * using complex type and default byReference and true append
	 */
	public void testComplexListRevertTypeMap5() {
		appendEqualTrue = true;
		try {
			tryComplexListTypeMap("complexTypeAppendTrueListRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map javaBean which nested javaBean and its javaBean List to context
	 */
	private void tryComplexListTypeMap(String format) throws Exception, DSEInvalidArgumentException, DSEInvalidClassException {
		TypeManager.treatClassAsSimpleType(Calendar.class);
		TypeManager.treatClassAsSimpleType(UUID.class);

		String[] prefixs = { "complexLa.primitiveLa.", "complexLa.simpleLa.", "complexLa." };
		E2eaComplexTypeBeanList e2eaComplexTypeBeanList = new E2eaComplexTypeBeanList();
		fillDefaultValuesToComplexListBean(e2eaComplexTypeBeanList);
		Context ctxt = getContext("complexLaDataCtxt");
		// //System.out.println(ctxt.getKeyedCollection());
		WSMapperConverter mapper = getFormat(format);
		mapper.mapObjectToContext(e2eaComplexTypeBeanList, ctxt);
		KeyedCollection kcoll = ctxt.getKeyedCollection();
		// //System.out.println(ctxt.getKeyedCollection());
		assertComplexListBeanCtxValueEqual(kcoll, prefixs, e2eaComplexTypeBeanList);

	}

	/**
	 * assert map of javaBean which nested javaBean and its javaBean List to
	 * context
	 */
	static void assertComplexListBeanCtxValueEqual(KeyedCollection kcoll, String[] prefixs,
			E2eaComplexTypeBeanList e2eaComplexTypeBeanList) throws DSEObjectNotFoundException {
		assertNotNull(kcoll);
		assertNotNull(e2eaComplexTypeBeanList.getPrimitiveLa());
		assertNotNull(e2eaComplexTypeBeanList.getSimpleLa());
		assertNotNull(e2eaComplexTypeBeanList.getPrimitiveLaIColl());
		assertNotNull(e2eaComplexTypeBeanList.getPrimitiveLaIColl2());
		assertNotNull(e2eaComplexTypeBeanList.getSimpleLaIColl());
		assertNotNull(e2eaComplexTypeBeanList.getSimpleLaIColl2());

		assertEquals(e2eaComplexTypeBeanList.getPrimitiveLaIColl().size(),
				((Vector) kcoll.getValueAt(prefixs[2] + "primitiveLaIColl")).size());
		if (appendEqualTrue) {
			assertEquals(e2eaComplexTypeBeanList.getPrimitiveLaIColl2().size() + 1,
					((Vector) kcoll.getValueAt(prefixs[2] + "primitiveLaIColl2")).size());
		} else {
			assertEquals(e2eaComplexTypeBeanList.getPrimitiveLaIColl2().size(),
					((Vector) kcoll.getValueAt(prefixs[2] + "primitiveLaIColl2")).size());
		}

		// assertEquals(e2eaComplexTypeBeanList.getSimpleLaIColl().length,((Vector)kcoll.getValueAt(prefix+"simpleLaIColl")).size());
		assertEquals(e2eaComplexTypeBeanList.getSimpleLaIColl2().size(),
				((Vector) kcoll.getValueAt(prefixs[2] + "simpleLaIColl2")).size());

		assertSimpleListCtxValueEqual(kcoll, prefixs[1], e2eaComplexTypeBeanList.getSimpleLa());

		assertPrimitiveListCtxValueEqual(kcoll, prefixs[0], e2eaComplexTypeBeanList.getPrimitiveLa());
	}

	/**
	 * init javaBean which nested javaBean and its javaBean List
	 */
	static void fillDefaultValuesToComplexListBean(E2eaComplexTypeBeanList e2eaComplexTypeBeanList) throws ParseException {
		E2eaPrimitiveTypeBeanList primitiveLa = e2eaComplexTypeBeanList.getPrimitiveLa();

		E2eaSimpleTypeBeanList simpleLa = e2eaComplexTypeBeanList.getSimpleLa();
		fillDefaultValuesToPrimitiveListBean(primitiveLa);
		fillDefaultValuesToSimpleListBean(simpleLa);

		List<E2eaPrimitiveTypeBeanList> primitiveLaIColl = new ArrayList<E2eaPrimitiveTypeBeanList>();
		for (int i = 0; i < 6; i++) {

			primitiveLaIColl.add(primitiveLa);
		}

		e2eaComplexTypeBeanList.setPrimitiveLaIColl(primitiveLaIColl);

		List<E2eaPrimitiveTypeBeanList> primitiveLaIColl2 = new ArrayList<E2eaPrimitiveTypeBeanList>();
		for (int i = 0; i < 6; i++) {
			primitiveLaIColl2.add(primitiveLa);
		}
		e2eaComplexTypeBeanList.setPrimitiveLaIColl2(primitiveLaIColl2);

		List<E2eaSimpleTypeBeanList> simpleLaIColl = new ArrayList<E2eaSimpleTypeBeanList>();
		for (int i = 0; i < 6; i++) {
			simpleLaIColl.add(simpleLa);
		}
		e2eaComplexTypeBeanList.setSimpleLaIColl(simpleLaIColl);

		List<E2eaSimpleTypeBeanList> simpleLaIColl2 = new ArrayList<E2eaSimpleTypeBeanList>();
		for (int i = 0; i < 6; i++) {
			simpleLaIColl2.add(simpleLa);
		}
		e2eaComplexTypeBeanList.setSimpleLaIColl2(simpleLaIColl2);

	}

}
