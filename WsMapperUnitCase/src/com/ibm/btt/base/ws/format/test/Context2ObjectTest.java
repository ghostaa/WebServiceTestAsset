package com.ibm.btt.base.ws.format.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.IndexedCollection;
import com.ibm.btt.base.KeyedCollection;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.base.ws.format.test.bean.JavaBean;
import com.ibm.btt.base.ws.format.test.bean.SubJavaBean;
import com.ibm.btt.bean.BeanCollection;

public class Context2ObjectTest extends WSMapperConverterTestFramework {

	private Random rand = new Random();
	
	public void testMapContextToList(){
		try {
			Context ctx = getContext("Ctxt_Context2List");

			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("IColl_Context2List");
			icoll.setValueAt("0", "hello");
			icoll.setValueAt("1", "world");

			WSMapperConverter mapper = getFormat("fmt_Context2List");
			Object obj = mapper.mapContextToObject(ctx);

			assertNotNull(obj);

			@SuppressWarnings("unchecked")
			List<String> retVals = (List<String>) obj;
			assertEquals(3, retVals.size());
	
			assertEquals(retVals.get(0), "hello");
			assertEquals(retVals.get(1), "world");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	//Test Context2Object(ie. java.lang.String)
	public void testMapContextToString() {
		try {
			Context ctx = getContext("Ctxt_Context2String");
			
			WSMapperConverter mapper = getFormat("fmt_Context2String");
			Object obj = mapper.mapContextToObject(ctx);
			
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(String.class.getName()) > -1);
			assertEquals("A String", obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testMapContextToStringArray(){
		try {
			Context ctx = getContext("Ctxt_Context2StringArray");
			ctx.setValueAt("IColl_Context2StringArray.0", "test 1");
			ctx.setValueAt("IColl_Context2StringArray.1", "test 2");
			ctx.setValueAt("IColl_Context2StringArray.2", "test 3");
			
			WSMapperConverter mapper = getFormat("fmt_Context2StringArray");
			Object obj = mapper.mapContextToObject(ctx);
			
			assertNotNull(obj);
			
			assertTrue(obj.getClass().getName().indexOf(String.class.getName()) > -1);
			
			String[] ret = (String[]) obj;
			assertEquals(3, ret.length);
			
			assertEquals(ctx.getValueAt("IColl_Context2StringArray.0").toString(), ret[0]);
			assertEquals(ctx.getValueAt("IColl_Context2StringArray.1").toString(), ret[1]);
			assertEquals(ctx.getValueAt("IColl_Context2StringArray.2").toString(), ret[2]);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testMapContextToIntArray(){
		try {
			Context ctx = getContext("Ctxt_Context2IntArray");

			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("IColl_Context2IntArray");
			for (int i = 0; i < icoll.size(); i++){
				icoll.setValueAt(String.valueOf(i), rand.nextInt());
			}

			WSMapperConverter mapper = getFormat("fmt_Context2IntArray");
			Object obj = mapper.mapContextToObject(ctx);
			
			assertNotNull(obj);
			
			int[] retVals = (int[]) obj;
			assertEquals(3, retVals.length);
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testMapContextToFloatArray(){
		try {
			Context ctx = getContext("Ctxt_Context2FloatArray");

			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("IColl_Context2FloatArray");
			for (int i = 0; i < icoll.size(); i++){
				icoll.setValueAt(String.valueOf(i), rand.nextFloat());
			}

			WSMapperConverter mapper = getFormat("fmt_Context2FloatArray");
			Object obj = mapper.mapContextToObject(ctx);
			
			assertNotNull(obj);
			
			float[] retVals = (float[]) obj;
			assertEquals(3, retVals.length);
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testMapContextToLongArray() {
		try {
			
			Context ctx = getContext("Ctxt_Context2LongArray");

			ctx.setValueAt("IColl_Context2LongArray.0", 12L);
			ctx.setValueAt("IColl_Context2LongArray.1", 24L);
			ctx.setValueAt("IColl_Context2LongArray.2", 36L);
			
			WSMapperConverter mapper = getFormat("fmt_Context2LongArray");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			
			long[] retVals = (long[]) obj;
			assertEquals(3, retVals.length);
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(ctx.getValueAt("IColl_Context2LongArray." + String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testMapContextToDoubleArray() {
		try {
			Context ctx = getContext("Ctxt_Context2DoubleArray");
			
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("IColl_Context2DoubleArray");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextDouble());
			
			WSMapperConverter mapper = getFormat("fmt_Context2DoubleArray");
			Object obj = mapper.mapContextToObject(ctx);
			
			assertNotNull(obj);
			
			double[] retVals = (double[]) obj;
			assertEquals(3, retVals.length);
			
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testMapContextToCharArray() {
		try {
			Context ctx = getContext("Ctxt_Context2CharArray");

			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("IColl_Context2CharArray");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), (char) rand.nextInt(Character.MAX_VALUE));
			
			WSMapperConverter mapper = getFormat("fmt_Context2CharArray");
			Object obj = mapper.mapContextToObject(ctx);
			
			assertNotNull(obj);
			
			char[] retVals = (char[]) obj;
			assertEquals(3, retVals.length);
			
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	
	public void testMapContextToShortArray() {
		try {
			
			Context ctx = getContext("Ctxt_Context2ShortArray");

//			ctx.setValueAt("IColl_Context2ShortArray.0", (short)12);
//			ctx.setValueAt("IColl_Context2ShortArray.1", (short)24);
//			ctx.setValueAt("IColl_Context2ShortArray.2", (short)36);
			
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("IColl_Context2ShortArray");
			for (int i = 0; i < icoll.size(); i++){
				icoll.setValueAt(String.valueOf(i), (short) rand.nextInt(Short.MAX_VALUE));
			}
			
			WSMapperConverter mapper = getFormat("fmt_Context2ShortArray");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			
			short[] retVals = (short[]) obj;
			assertEquals(3, retVals.length);
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(ctx.getValueAt("IColl_Context2ShortArray." + String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testMapContextToByteArray() {
		try {
			Context ctx = getContext("Ctxt_Context2ByteArray");
			
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("IColl_Context2ByteArray");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), (byte) rand.nextInt(Byte.MAX_VALUE));

			WSMapperConverter mapper = getFormat("fmt_Context2ByteArray");

			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			
			byte[] retVals = (byte[]) obj;
			assertEquals(3, retVals.length);
			
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testMapContextToBooleanArray() {
		try {
			Context ctx = getContext("Ctxt_Context2BooleanArray");
			
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("IColl_Context2BooleanArray");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextBoolean());

			WSMapperConverter mapper = getFormat("fmt_Context2BooleanArray");

			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			
			boolean[] retVals = (boolean[]) obj;
			assertEquals(3, retVals.length);
			
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	
	public void testMapContextToBoolean() {
		try {
			Context ctx = getContext("Ctxt_Context2Boolean");
			Boolean boolValue = true;
			ctx.setValueAt("booleanField", boolValue);
			
			WSMapperConverter mapper = getFormat("fmt_Context2Boolean");
			Object obj = mapper.mapContextToObject(ctx);
			
			assertNotNull(obj);
			assertEquals(boolValue, obj);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	//Context to Number(ie. Integer Object)
	public void testMapContextToInteger() {
		try {
			Context ctx = getContext("Ctxt_Context2Integer");
			
			Integer integerValue = rand.nextInt();
			ctx.setValueAt("integerField", integerValue);
			
			WSMapperConverter mapper = getFormat("fmt_Context2Integer");
			Object obj = mapper.mapContextToObject(ctx);
			
			assertNotNull(obj);
			assertEquals(integerValue, obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testMapContextToCharacter() {
		try {
			Context ctx = getContext("Ctxt_Context2Character");
			
			Character characterValue = (char)(rand.nextInt(Character.MAX_VALUE));
			ctx.setValueAt("characterField", characterValue);
			
			WSMapperConverter mapper = getFormat("fmt_Context2Character");
			Object obj = mapper.mapContextToObject(ctx);
			
			assertNotNull(obj);
			assertEquals(characterValue, obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testMapContextToJavaBean() {
		try {
			Context ctx = getContext("Ctxt_Context2JavaBean");
			
			//assign value for primitve value
			byte byteValue = (byte)rand.nextInt(Byte.MAX_VALUE);
			ctx.setValueAt("byteField", byteValue);
			
			char charValue = (char)rand.nextInt(Character.MAX_VALUE);
			ctx.setValueAt("charField", charValue);

			short shortValue = (short)rand.nextInt(Short.MAX_VALUE);
			ctx.setValueAt("shortField", shortValue);
			
			int intValue = rand.nextInt();
			ctx.setValueAt("intField", intValue);
			
			long longValue = rand.nextLong();
			ctx.setValueAt("longField", longValue);
			
			float floatValue = rand.nextFloat();
			ctx.setValueAt("floatField", floatValue);
			
			double doubleValue = rand.nextDouble();
			ctx.setValueAt("doubleField", doubleValue);

			//assign value for primitive array
//			IndexedCollection icollByteArray = (IndexedCollection) ctx.getElementAt("IColl_Context2JavaBean_ByteArray");
//			for (int i = 0; i < icollByteArray.size(); i++)
//				icollByteArray.setValueAt(String.valueOf(i), (byte) rand.nextInt(Byte.MAX_VALUE));

			IndexedCollection icollCharArray = (IndexedCollection) ctx.getElementAt("IColl_Context2JavaBean_CharArray");
			for (int i = 0; i < icollCharArray.size(); i++)
				icollCharArray.setValueAt(String.valueOf(i), (char) rand.nextInt(Character.MAX_VALUE));

			IndexedCollection icollShortArray = (IndexedCollection) ctx.getElementAt("IColl_Context2JavaBean_ShortArray");
			for (int i = 0; i < icollShortArray.size(); i++){
				icollShortArray.setValueAt(String.valueOf(i), (short) rand.nextInt(Short.MAX_VALUE));
			}

			IndexedCollection icollIntArray = (IndexedCollection) ctx.getElementAt("IColl_Context2JavaBean_IntArray");
			for (int i = 0; i < icollIntArray.size(); i++){
				icollIntArray.setValueAt(String.valueOf(i), rand.nextInt());
			}

			IndexedCollection icollLongArray = (IndexedCollection) ctx.getElementAt("IColl_Context2JavaBean_LongArray");
			for (int i = 0; i < icollLongArray.size(); i++)
				icollLongArray.setValueAt(String.valueOf(i), rand.nextLong());

			IndexedCollection icollFloatArray = (IndexedCollection) ctx.getElementAt("IColl_Context2JavaBean_FloatArray");
			for (int i = 0; i < icollFloatArray.size(); i++){
				icollFloatArray.setValueAt(String.valueOf(i), rand.nextFloat());
			}

			IndexedCollection icollDoubleArray = (IndexedCollection) ctx.getElementAt("IColl_Context2JavaBean_DoubleArray");
			for (int i = 0; i < icollDoubleArray.size(); i++)
				icollDoubleArray.setValueAt(String.valueOf(i), rand.nextDouble());

			//assign value for String array		
			ctx.setValueAt("IColl_Context2JavaBean_StringArray.0", "test 1");
			ctx.setValueAt("IColl_Context2JavaBean_StringArray.1", "test 2");
			ctx.setValueAt("IColl_Context2JavaBean_StringArray.2", "test 3");
			ctx.setValueAt("IColl_Context2JavaBean_StringArray.3", "test 4");
			ctx.setValueAt("IColl_Context2JavaBean_StringArray.4", "test 5");

			//assign value for ArrayList
			IndexedCollection icollArrayList = (IndexedCollection) ctx.getElementAt("IColl_Context2JavaBean_ArrayList");
			icollArrayList.setValueAt("0", "hello");
			icollArrayList.setValueAt("1", "world");
			
			//assign value for SubJavaBean
			ctx.setValueAt("KColl_Context2JavaBean_SubJavaBean.strObjectFieldInSubJavaBean", "There is nothing");
			ctx.setValueAt("KColl_Context2JavaBean_SubJavaBean.intFieldInSubJavaBean", 12345);

			//assign value for SubJavaBean array
			IndexedCollection icollSubJavaBeanArray = (IndexedCollection)ctx.getElementAt("IColl_Context2JavaBean_SubJavaBeanArray");
			
			KeyedCollection kcollElement = (KeyedCollection)icollSubJavaBeanArray.getElementAt("0");
			kcollElement.setValueAt("strObjectFieldInSubJavaBean", "hello");
			kcollElement.setValueAt("intFieldInSubJavaBean", 321);
			
			kcollElement = (KeyedCollection)icollSubJavaBeanArray.getElementAt("1");
			kcollElement.setValueAt("strObjectFieldInSubJavaBean", "world");
			kcollElement.setValueAt("intFieldInSubJavaBean", 123);
			
			//assign value for SubJavaBean ArrayList
			IndexedCollection icollSubJavaBeanList = (IndexedCollection)ctx.getElementAt("IColl_Context2JavaBean_SubJavaBeanList");
			
			kcollElement = (KeyedCollection)icollSubJavaBeanList.getElementAt("0");
			kcollElement.setValueAt("strObjectFieldInSubJavaBean", "hello");
			kcollElement.setValueAt("intFieldInSubJavaBean", 321);
			
			kcollElement = (KeyedCollection)icollSubJavaBeanList.getElementAt("1");
			kcollElement.setValueAt("strObjectFieldInSubJavaBean", "world");
			kcollElement.setValueAt("intFieldInSubJavaBean", 123);
			
			
			//Map
			WSMapperConverter mapper = getFormat("fmt_Context2JavaBean");

			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);

			assertEquals(obj.getClass(), JavaBean.class);
			JavaBean bean = (JavaBean)obj;

			//test for primitive attribute
			assertEquals(byteValue, bean.getPrimitiveByte());
			assertEquals(charValue, bean.getPrimitiveChar());
			assertEquals(shortValue, bean.getPrimitiveShort());
			assertEquals(intValue, bean.getPrimitiveInt());
			assertEquals(longValue, bean.getPrimitiveLong());
			assertEquals(floatValue, bean.getPrimitiveFloat());
			assertEquals(doubleValue, bean.getPrimitiveDouble());

//			//test for primitive array attribute
//			byte[] byteArray = bean.getPrimitiveByteArray();
//			assertEquals(3, byteArray.length);
//			for (int i = 0; i < byteArray.length; i++) {
//				assertEquals(icollByteArray.getValueAt(String.valueOf(i)), byteArray[i]);
//			}

			char[] charArray = bean.getPrimitiveCharArray();
			assertEquals(3, charArray.length);
			for (int i = 0; i < charArray.length; i++) {
				assertEquals(icollCharArray.getValueAt(String.valueOf(i)), charArray[i]);
			}

			short[] shortArray = bean.getPrimitiveShortArray();
			assertEquals(3, shortArray.length);
			for (int i = 0; i < shortArray.length; i++) {
				assertEquals(icollShortArray.getValueAt(String.valueOf(i)), shortArray[i]);
			}

			int[] intArray = bean.getPrimitiveIntArray();
			assertEquals(3, intArray.length);
			for (int i = 0; i < intArray.length; i++) {
				assertEquals(icollIntArray.getValueAt(String.valueOf(i)), intArray[i]);
			}

			long[] longArray = bean.getPrimitiveLongArray();
			assertEquals(3, longArray.length);
			for (int i = 0; i < longArray.length; i++) {
				assertEquals(icollLongArray.getValueAt(String.valueOf(i)), longArray[i]);
			}

			float[] floatArray = bean.getPrimitiveFloatArray();
			assertEquals(3, floatArray.length);
			for (int i = 0; i < floatArray.length; i++) {
				assertEquals(icollFloatArray.getValueAt(String.valueOf(i)), floatArray[i]);
			}

			double[] doubleArray = bean.getPrimitiveDoubleArray();
			assertEquals(3, doubleArray.length);
			for (int i = 0; i < doubleArray.length; i++) {
				assertEquals(icollDoubleArray.getValueAt(String.valueOf(i)), doubleArray[i]);
			}

			//test for String attribute
			assertTrue((bean.getStringObject().getClass().getName().indexOf(String.class.getName()) > -1));
			assertEquals("This is A String", bean.getStringObject());

			//test for String array attribute	
			String[] stringArray = bean.getStringObjectArray();
			assertEquals(5, stringArray.length);
			assertEquals(ctx.getValueAt("IColl_Context2JavaBean_StringArray.0").toString(), stringArray[0]);
			assertEquals(ctx.getValueAt("IColl_Context2JavaBean_StringArray.1").toString(), stringArray[1]);
			assertEquals(ctx.getValueAt("IColl_Context2JavaBean_StringArray.2").toString(), stringArray[2]);

			//test for ArrayList attribute			
			@SuppressWarnings("unchecked")
			ArrayList<String> stringObjectList = (ArrayList<String>) bean.getStringObjectList();
			assertEquals(3, stringObjectList.size());
			assertEquals(stringObjectList.get(0), "hello");
			assertEquals(stringObjectList.get(1), "world");
			
			//test for SubJavaBean attribute
			SubJavaBean subJavaBeanResult = bean.getSubJavaBean();
			assertEquals(subJavaBeanResult.getClass(), SubJavaBean.class);
			assertEquals(subJavaBeanResult.getSomeThing(), "There is nothing");
			assertEquals(subJavaBeanResult.getIntValue(), 12345);
			
			//test for SubJavaBean array attribute
			SubJavaBean[] subJavaBeanArray = bean.getSubJavaBeanArray(); 
			assertEquals(subJavaBeanArray.length, icollSubJavaBeanArray.size());
			for(int i=0; i<subJavaBeanArray.length; i++){
				SubJavaBean tempBean = subJavaBeanArray[i];
				assertEquals(tempBean.getSomeThing(), icollSubJavaBeanArray.getValueAt(i + ".strObjectFieldInSubJavaBean"));
				assertEquals(tempBean.getIntValue(), icollSubJavaBeanArray.getValueAt(i + ".intFieldInSubJavaBean"));
			}
			
			//test for SubJavaBean ArrayList attribute
			List<SubJavaBean> subJavaBeanList = bean.getSubJavaBeanList();
			assertEquals(subJavaBeanList.size(), icollSubJavaBeanList.size());
			for(int i=0; i<subJavaBeanList.size(); i++){
				SubJavaBean tempBean = subJavaBeanList.get(i);
				assertEquals(tempBean.getSomeThing(), icollSubJavaBeanList.getValueAt(i + ".strObjectFieldInSubJavaBean"));
				assertEquals(tempBean.getIntValue(), icollSubJavaBeanList.getValueAt(i + ".intFieldInSubJavaBean"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
}
