package com.ibm.btt.wsc.mapper.test;

/*
 * 
 */

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.DSEInvalidArgumentException;
import com.ibm.btt.base.DSEInvalidClassException;
import com.ibm.btt.base.DSEInvalidRequestException;
import com.ibm.btt.base.DSEObjectNotFoundException;
import com.ibm.btt.base.DataField;
import com.ibm.btt.base.IndexedCollection;
import com.ibm.btt.base.KeyedCollection;
import com.ibm.btt.base.Vector;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.bean.TypeManager;
import com.ibm.btt.config.InitManager;
import com.ibm.btt.wsc.mapper.beans.E2eaComplexTypeBean;
import com.ibm.btt.wsc.mapper.beans.E2eaPrimitiveTypeBean;

import com.ibm.btt.wsc.mapper.beans.E2eaSimpleTypeBean;

public class E2EAsteriskRevertTestsArray extends MapperTestSuper {
	private static boolean appendEqualTrue = false;
	static Random rand = new Random();
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@Override
	protected void setUp() throws Exception {
		appendEqualTrue = false;
		InitManager.reset("jar:///definitions/bttE2ea.xml");
	}

	/**
	 * test map from javaBean which nested primitive data and simple 's array to
	 * context using complex type and byReference=true and default append
	 */
	public void testPrimitiveRevertTypeMap1() {
		try {
			tryPrimitiveRevertTypeMap("primitiveTypeRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested primitive data and simple 's array to
	 * context using complex type and default byReference and default append
	 */
	public void testPrimitiveRevertTypeMap2() {
		try {
			tryPrimitiveRevertTypeMap("primitiveTypeDftByRefAppendRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested primitive data and simple 's array to
	 * context using complex type and byReference=false and default append
	 */
	public void testPrimitiveRevertTypeMap3() {
		try {
			tryPrimitiveRevertTypeMap("primitiveTypeByRefFalseRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested primitive data and simple 's array to
	 * context using complex type and default byReference and false append
	 */
	public void testPrimitiveRevertTypeMap4() {
		try {
			tryPrimitiveRevertTypeMap("primitiveTypeAppendFalseRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested primitive data and simple 's array to
	 * context using complex type and default byReference and true append
	 */
	public void testPrimitiveRevertTypeMap5() {
		try {
			tryPrimitiveRevertTypeMap("primitiveTypeAppendTrueRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map complex bean object which nested primitive array to context
	 */
	private void tryPrimitiveRevertTypeMap(String format) throws Exception {

		String prefix = "primitiveLa.";
		E2eaPrimitiveTypeBean ea2EPrimitiveTypeBean = new E2eaPrimitiveTypeBean();

		fillDefaultValuesToPrimitiveBean(ea2EPrimitiveTypeBean);
		Context ctxt = getContext("primitiveLaDataCtxt");
		//System.out.println(ctxt.getKeyedCollection());
		WSMapperConverter mapper = getFormat(format);
		mapper.mapObjectToContext(ea2EPrimitiveTypeBean, ctxt);
		//System.out.println(ctxt.getKeyedCollection());
		KeyedCollection kcoll = ctxt.getKeyedCollection();
		assertPrimitiveCtxValueEqual(kcoll, prefix, ea2EPrimitiveTypeBean);
	}

	/**
	 * set value for javaBean which nested primitive type data and its array
	 * data's array
	 */
	static void fillDefaultValuesToPrimitiveBean(E2eaPrimitiveTypeBean ea2EPrimitiveTypeBean) {

		ea2EPrimitiveTypeBean.setIntField(rand.nextInt());
		ea2EPrimitiveTypeBean.setBooleanField(rand.nextBoolean());
		ea2EPrimitiveTypeBean.setFloatField(rand.nextFloat());
		ea2EPrimitiveTypeBean.setDoubleField(rand.nextDouble());
		ea2EPrimitiveTypeBean.setByteField((byte) rand.nextInt(Byte.MAX_VALUE));
		ea2EPrimitiveTypeBean.setCharField((char) rand.nextInt(Character.MAX_VALUE));
		ea2EPrimitiveTypeBean.setShortField((short) rand.nextInt(Short.MAX_VALUE));
		ea2EPrimitiveTypeBean.setLongField(rand.nextLong());

		ea2EPrimitiveTypeBean.setIntIColl(new int[] { rand.nextInt(), rand.nextInt(), rand.nextInt() });
		ea2EPrimitiveTypeBean.setBooleanIColl(new boolean[] { rand.nextBoolean() });
		ea2EPrimitiveTypeBean.setByteIColl(new byte[] { (byte) rand.nextInt(Byte.MAX_VALUE) });
		ea2EPrimitiveTypeBean.setCharIColl(new char[] { (char) rand.nextInt(Character.MAX_VALUE),
				(char) rand.nextInt(Character.MAX_VALUE), (char) rand.nextInt(Character.MAX_VALUE) });
		ea2EPrimitiveTypeBean.setDoubleIColl(new double[] {});
		ea2EPrimitiveTypeBean.setFloatIColl(new float[] { rand.nextFloat() });
		ea2EPrimitiveTypeBean.setLongIColl(new long[] { rand.nextLong() });
		ea2EPrimitiveTypeBean.setShortIColl(new short[] { (short) rand.nextInt(Short.MAX_VALUE),
				(short) rand.nextInt(Short.MAX_VALUE) });

	}

	/**
	 * assert map of primitive bean which nested primitive type data and its
	 * array to context
	 */
	static void assertPrimitiveCtxValueEqual(KeyedCollection kcoll, String prefix, E2eaPrimitiveTypeBean ea2EPrimitiveTypeBean)
			throws Exception {

		assertNotNull(kcoll);
		assertEquals(ea2EPrimitiveTypeBean.getIntField(), kcoll.getValueAt(prefix + "intField"));
		assertEquals(ea2EPrimitiveTypeBean.isBooleanField(), kcoll.getValueAt(prefix + "booleanField"));
		assertEquals(ea2EPrimitiveTypeBean.getByteField(), kcoll.getValueAt(prefix + "byteField"));
		assertEquals(ea2EPrimitiveTypeBean.getCharField(), kcoll.getValueAt(prefix + "charField"));
		assertEquals(ea2EPrimitiveTypeBean.getFloatField(), kcoll.getValueAt(prefix + "floatField"));
		assertEquals(ea2EPrimitiveTypeBean.getDoubleField(), kcoll.getValueAt(prefix + "doubleField"));
		assertEquals(ea2EPrimitiveTypeBean.getLongField(), kcoll.getValueAt(prefix + "longField"));
		assertEquals(ea2EPrimitiveTypeBean.getShortField(), kcoll.getValueAt(prefix + "shortField"));

		IndexedCollection intIColl = (IndexedCollection) kcoll.getElementAt(prefix + "intIColl");

		// bean's array size equals to destination
		if (intIColl.getElements().size() <= ea2EPrimitiveTypeBean.getIntIColl().length) {
			for (int i = 0; i < intIColl.getElements().size(); i++) {
				assertEquals(ea2EPrimitiveTypeBean.getIntIColl()[i], intIColl.getElementAt(i).getValue());
			}
		}

		IndexedCollection booleanIColl = (IndexedCollection) kcoll.getElementAt(prefix + "booleanIColl");
		// bean's array size less than to destination
		if (booleanIColl.getElements().size() <= ea2EPrimitiveTypeBean.getBooleanIColl().length) {
			for (int i = 0; i < booleanIColl.getElements().size(); i++) {
				assertEquals(ea2EPrimitiveTypeBean.getBooleanIColl()[0], booleanIColl.getElementAt(i).getValue());
			}
		}
		// bean's array size equals to destination 's
		DataField byteIColl = (DataField) kcoll.getElementAt(prefix + "byteIColl");
		byte[] byts = ea2EPrimitiveTypeBean.getByteIColl();
		byte[] bytes = (byte[])byteIColl.getValue();
		assertEquals(byts.length,bytes.length);
		for(int i=0;i<byts.length;i++)
			assertEquals(byts[i],bytes[i]);
		
//		IndexedCollection byteIColl = (IndexedCollection) kcoll.getElementAt(prefix + "byteIColl");
//		if (byteIColl.getElements().size() <= ea2EPrimitiveTypeBean.getByteIColl().length) {
//			for (int i = 0; i < byteIColl.getElements().size(); i++) {
//				assertEquals(ea2EPrimitiveTypeBean.getByteIColl()[i], byteIColl.getElementAt(i).getValue());
//			}
//		}

		// bean's array big than destination 's
		IndexedCollection charIColl = (IndexedCollection) kcoll.getElementAt(prefix + "charIColl");
		if (charIColl.getElements().size() <= ea2EPrimitiveTypeBean.getCharIColl().length) {
			for (int i = 0; i < charIColl.getElements().size(); i++) {
				assertEquals(ea2EPrimitiveTypeBean.getCharIColl()[i], charIColl.getElementAt(i).getValue());
			}
		}
		// bean's array big than destination 's
		IndexedCollection floatIColl = (IndexedCollection) kcoll.getElementAt(prefix + "floatIColl");

		if (floatIColl.getElements().size() <= ea2EPrimitiveTypeBean.getFloatIColl().length) {
			for (int i = 0; i < floatIColl.getElements().size(); i++) {
				assertEquals(ea2EPrimitiveTypeBean.getFloatIColl()[i], floatIColl.getElementAt(i).getValue());
			}
		}
		// bean's array size equals to destination 's
		IndexedCollection doubleIColl = (IndexedCollection) kcoll.getElementAt(prefix + "doubleIColl");
		if (doubleIColl.getElements().size() <= ea2EPrimitiveTypeBean.getDoubleIColl().length) {
			for (int i = 0; i < doubleIColl.getElements().size(); i++) {
				assertEquals(ea2EPrimitiveTypeBean.getDoubleIColl()[i], doubleIColl.getElementAt(i).getValue());

			}
		}
		// bean's array big than destination 's
		IndexedCollection longIColl = (IndexedCollection) kcoll.getElementAt(prefix + "longIColl");
		if (longIColl.getElements().size() <= ea2EPrimitiveTypeBean.getLongIColl().length) {
			for (int i = 0; i < longIColl.getElements().size(); i++) {
				assertEquals(ea2EPrimitiveTypeBean.getLongIColl()[i], longIColl.getElementAt(i).getValue());

			}
		}
		// destination bean's array big than size greater than
		IndexedCollection shortIColl = (IndexedCollection) kcoll.getElementAt(prefix + "shortIColl");
		if (shortIColl.getElements().size() <= ea2EPrimitiveTypeBean.getShortIColl().length) {
			for (int i = 0; i < shortIColl.getElements().size(); i++) {
				assertEquals(ea2EPrimitiveTypeBean.getShortIColl()[i], shortIColl.getElementAt(i).getValue());
			}
		}
	}

	/**
	 * test map from javaBean which nested simple complex data and its array to
	 * context using complex type and true byReference and ignore append
	 */
	public void testSimpleRevertTypeTypeMap1() {

		try {
			trySimpleTypeMap("simpleTypeRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple complex data and its array to
	 * context using complex type and default byReference and default append
	 */
	public void testSimpleRevertTypeTypeMap2() {
		try {
			trySimpleTypeMap("simpleTypeDftByRefAppendRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple complex data and its array to
	 * context using complex type and false byReference and default append
	 */
	public void testSimpleRevertTypeTypeMap3() {
		try {
			trySimpleTypeMap("simpleTypeByRefFalseRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple complex data and its array to
	 * context using complex type and default byReference and false append
	 */
	public void testSimpleRevertTypeTypeMap4() {
		try {
			trySimpleTypeMap("simpleTypeAppendFalseRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested simple complex data and its array to
	 * context using complex type and default byReference and true append
	 */
	public void testSimpleRevertTypeTypeMap5() {
		try {
			trySimpleTypeMap("simpleTypeAppendTrueRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map complex bean object which nested simple type and its array to context
	 */
	private void trySimpleTypeMap(String format) throws Exception {
		TypeManager.treatClassAsSimpleType(Calendar.class);
		TypeManager.treatClassAsSimpleType(UUID.class);
		String prefix = "simpleLa.";
		E2eaSimpleTypeBean e2eaSimpleTypeBean = new E2eaSimpleTypeBean();
		fillDefaultValuesToSimpleBean(e2eaSimpleTypeBean);
		Context ctxt = getContext("simpleLaDataCtxt");
		//System.out.println(ctxt.getKeyedCollection());
		WSMapperConverter mapper = getFormat(format);
		mapper.mapObjectToContext(e2eaSimpleTypeBean, ctxt);
		KeyedCollection kcoll = ctxt.getKeyedCollection();
		//System.out.println(ctxt.getKeyedCollection());
		assertSimpleBeanCtxValueEqual(kcoll, prefix, e2eaSimpleTypeBean);

	}

	/**
	 * javaBean which nested simple Object and its array assert map of javaBean
	 * which nested complex common Object to context
	 */
	static void assertSimpleBeanCtxValueEqual(KeyedCollection kcoll, String prefix, E2eaSimpleTypeBean e2eaSimpleTypeBean)
			throws DSEObjectNotFoundException, DSEInvalidRequestException {

		assertNotNull(kcoll);
		assertEquals(e2eaSimpleTypeBean.getStringField(), kcoll.getValueAt(prefix + "stringField"));
		assertEquals(e2eaSimpleTypeBean.getIntegerField(), kcoll.getValueAt(prefix + "integerField"));
		assertEquals(e2eaSimpleTypeBean.getBigDecimalField(), kcoll.getValueAt(prefix + "bigDecimalField"));
		assertEquals(e2eaSimpleTypeBean.getDateField(), kcoll.getValueAt(prefix + "dateField"));
		assertEquals(e2eaSimpleTypeBean.getCalendarField(), kcoll.getValueAt(prefix + "calendarField"));
		assertEquals(e2eaSimpleTypeBean.getUuidField(), kcoll.getValueAt(prefix + "uuidField"));

		IndexedCollection stringIColl = (IndexedCollection) kcoll.getElementAt(prefix + "stringIColl");
		if (stringIColl.getElements().size() <= e2eaSimpleTypeBean.getStringIColl().length) {
			// bean's array size big than destination 's
			for (int i = 0; i < 1; i++) {
				assertEquals(e2eaSimpleTypeBean.getStringIColl()[i], stringIColl.getElementAt(i).getValue());
			}
		}
		IndexedCollection integerIColl = (IndexedCollection) kcoll.getElementAt(prefix + "integerIColl");
		if (integerIColl.getElements().size() <= e2eaSimpleTypeBean.getIntegerIColl().length) {
			// bean's array size less than destination 's
			for (int i = 0; i < integerIColl.getElements().size(); i++) {
				assertEquals(e2eaSimpleTypeBean.getIntegerIColl()[0], integerIColl.getElementAt(i).getValue());
			}
			// bean's array size less than destination 's
			IndexedCollection bigDecimalIColl = (IndexedCollection) kcoll.getElementAt(prefix + "bigDecimalIColl");
			if (bigDecimalIColl.getElements().size() <= e2eaSimpleTypeBean.getBigDecimalIColl().length) {
				for (int i = 0; i < bigDecimalIColl.getElements().size(); i++) {
					assertEquals(e2eaSimpleTypeBean.getBigDecimalIColl()[i], bigDecimalIColl.getElementAt(i).getValue());
				}
			}
			// bean's array less than destination 's
			IndexedCollection dateIColl = (IndexedCollection) kcoll.getElementAt(prefix + "dateIColl");
			if (dateIColl.getElements().size() <= e2eaSimpleTypeBean.getDateIColl().length) {
				for (int i = 0; i < dateIColl.getElements().size(); i++) {
					assertEquals(e2eaSimpleTypeBean.getDateIColl()[i], dateIColl.getElementAt(i).getValue());
				}
			}
			// bean's array less than destination 's
			IndexedCollection calendarIColl = (IndexedCollection) kcoll.getElementAt(prefix + "calendarIColl");
			if (calendarIColl.getElements().size() <= e2eaSimpleTypeBean.getCalendarIColl().length) {
				for (int i = 0; i < calendarIColl.getElements().size(); i++) {
					assertEquals(e2eaSimpleTypeBean.getCalendarIColl()[i], calendarIColl.getElementAt(i).getValue());
				}
			}

			// bean's array size big than to destination 's
			IndexedCollection uuidIColl = (IndexedCollection) kcoll.getElementAt(prefix + "uuidIColl");
			if (uuidIColl.getElements().size() <= e2eaSimpleTypeBean.getCalendarIColl().length) {
				for (int i = 0; i < uuidIColl.getElements().size(); i++) {
					assertEquals(e2eaSimpleTypeBean.getCalendarIColl()[i], uuidIColl.getElementAt(i).getValue());

				}
			}
		}
	}

	/**
	 * init javaBean which nested simple Object and its array
	 */
	static void fillDefaultValuesToSimpleBean(E2eaSimpleTypeBean e2eaSimpleTypeBean) throws ParseException {

		e2eaSimpleTypeBean.setStringField("O2CMC2" + rand.nextLong());
		e2eaSimpleTypeBean.setIntegerField(new Integer(rand.nextInt()));
		e2eaSimpleTypeBean.setBigDecimalField(new BigDecimal(rand.nextDouble() * rand.nextInt(1024)));
		e2eaSimpleTypeBean.setDateField(sdf.parse("20101010"));
		e2eaSimpleTypeBean.setCalendarField(Calendar.getInstance());
		e2eaSimpleTypeBean.setUuidField(String.valueOf(rand.nextLong()));

		e2eaSimpleTypeBean.setStringIColl(new String[] { "O2CMC1" + rand.nextInt(), "O2CMC2" + rand.nextInt() });
		e2eaSimpleTypeBean.setIntegerIColl(new Integer[] {});
		e2eaSimpleTypeBean.setBigDecimalIColl(new BigDecimal[] { new BigDecimal((rand.nextFloat() * 1024)) });
		e2eaSimpleTypeBean.setDateIColl(new Date[] { rand.nextBoolean() ? new Date() : sdf.parse("20110118"),
				sdf.parse("20110117"), sdf.parse("20110116") });
		e2eaSimpleTypeBean.setCalendarIColl(new Calendar[] { Calendar.getInstance() });
		e2eaSimpleTypeBean.setUuidIColl(new String[] { String.valueOf(rand.nextLong()), String.valueOf(rand.nextLong()) });

	}

	/**
	 * test map from javaBean which nested javaBean and javaBean array to
	 * context using complex type and true byReference and ignore append
	 */
	public void testComplexRevertTypeMap1() {
		try {
			tryComplexTypeMap("complexTypeRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested javaBean and javaBean array to
	 * context using complex type and default byReference and true append
	 */
	public void testComplexRevertTypeMap2() {
		try {
			tryComplexTypeMap("complexTypeDftByRefAppendRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested javaBean and javaBean array to
	 * context using complex type and false byReference and default append
	 */
	public void testComplexRevertTypeMap3() {
		try {
			tryComplexTypeMap("complexTypeByRefFalseRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested javaBean and javaBean array to
	 * context using complex type and default byReference and false append
	 */
	public void testComplexRevertTypeMap4() {
		try {
			tryComplexTypeMap("complexTypeAppendFalseRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * test map from javaBean which nested javaBean and javaBean array to
	 * context using complex type and default byReference and true append
	 */
	public void testComplexRevertTypeMap5() {
		appendEqualTrue = true;
		try {
			tryComplexTypeMap("complexTypeAppendTrueRevertFmt");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * map javaBean which nested javaBean and javaBean array
	 */
	private void tryComplexTypeMap(String format) throws Exception, DSEInvalidArgumentException, DSEInvalidClassException {
		TypeManager.treatClassAsSimpleType(Calendar.class);
		TypeManager.treatClassAsSimpleType(UUID.class);

		String prefix = "complexLa.";
		E2eaComplexTypeBean e2eaComplexTypeBean = new E2eaComplexTypeBean();
		fillDefaultValuesToComplexBean(e2eaComplexTypeBean);
		Context ctxt = getContext("complexLaDataCtxt");
		//System.out.println(ctxt.getKeyedCollection());
		WSMapperConverter mapper = getFormat(format);
		mapper.mapObjectToContext(e2eaComplexTypeBean, ctxt);
		KeyedCollection kcoll = ctxt.getKeyedCollection();
		//System.out.println(ctxt.getKeyedCollection());
		assertComplexBeanCtxValueEqual(kcoll, prefix, e2eaComplexTypeBean);

	}

	/**
	 * assert for javaBean which nested javaBean and javaBean array
	 */
	static void assertComplexBeanCtxValueEqual(KeyedCollection kcoll, String prefix, E2eaComplexTypeBean e2eaComplexTypeBean)
			throws Exception {

		assertNotNull(kcoll);
		assertNotNull(e2eaComplexTypeBean.getPrimitiveLa());
		assertNotNull(e2eaComplexTypeBean.getSimpleLa());
		assertNotNull(e2eaComplexTypeBean.getPrimitiveLaIColl());
		assertNotNull(e2eaComplexTypeBean.getPrimitiveLaIColl2());
		assertNotNull(e2eaComplexTypeBean.getSimpleLaIColl());
		assertNotNull(e2eaComplexTypeBean.getSimpleLaIColl2());
		//System.out.println(kcoll.getValueAt(prefix + "primitiveLaIColl").getClass());
		assertEquals(e2eaComplexTypeBean.getPrimitiveLaIColl().length,
				((Vector) kcoll.getValueAt(prefix + "primitiveLaIColl")).size());
		if (appendEqualTrue) {
			assertEquals(e2eaComplexTypeBean.getPrimitiveLaIColl2().length + 1,
					((Vector) kcoll.getValueAt(prefix + "primitiveLaIColl2")).size());
		} else {
			assertEquals(e2eaComplexTypeBean.getPrimitiveLaIColl2().length,
					((Vector) kcoll.getValueAt(prefix + "primitiveLaIColl2")).size());
		}
		// assertEquals(e2eaComplexTypeBean.getSimpleLaIColl().length,((Vector)kcoll.getValueAt(prefix+"simpleLaIColl")).size());
		assertEquals(e2eaComplexTypeBean.getSimpleLaIColl2().length,
				((Vector) kcoll.getValueAt(prefix + "simpleLaIColl2")).size());

		assertPrimitiveCtxValueEqual(kcoll, prefix + "primitiveLa.", e2eaComplexTypeBean.getPrimitiveLa());
		assertSimpleBeanCtxValueEqual(kcoll, prefix + "simpleLa.", e2eaComplexTypeBean.getSimpleLa());

	}

	/**
	 * init javaBean which nested javaBean and javaBean array
	 */
	static void fillDefaultValuesToComplexBean(E2eaComplexTypeBean e2eaComplexTypeBean) throws ParseException {
		E2eaPrimitiveTypeBean primitiveLa = e2eaComplexTypeBean.getPrimitiveLa();
		E2eaSimpleTypeBean simpleLa = e2eaComplexTypeBean.getSimpleLa();
		fillDefaultValuesToPrimitiveBean(primitiveLa);
		fillDefaultValuesToSimpleBean(simpleLa);

		e2eaComplexTypeBean.setPrimitiveLaIColl(new E2eaPrimitiveTypeBean[] { primitiveLa });
		e2eaComplexTypeBean.setPrimitiveLaIColl2(new E2eaPrimitiveTypeBean[] { primitiveLa });
		e2eaComplexTypeBean.setSimpleLaIColl(new E2eaSimpleTypeBean[] { simpleLa });
		e2eaComplexTypeBean.setSimpleLaIColl2(new E2eaSimpleTypeBean[] { simpleLa });

	}
}
