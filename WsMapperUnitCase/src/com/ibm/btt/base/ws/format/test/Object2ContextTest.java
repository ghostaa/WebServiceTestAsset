package com.ibm.btt.base.ws.format.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.DataElement;
import com.ibm.btt.base.IndexedCollection;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.base.ws.format.test.bean.Bean;
import com.ibm.btt.base.ws.format.test.bean.JavaBean;
import com.ibm.btt.base.ws.format.test.bean.SubJavaBean;

public class Object2ContextTest extends WSMapperConverterTestFramework {
	Random rand = new Random();
	// This is a defect case
	public void testMapListToContext() {
		try {
			Context ctx = getContext("Ctxt_List2Context");

			List<String> listObject = new ArrayList<String>();
			listObject.add("Hello");
			listObject.add("World");

			WSMapperConverter mapper = getFormat("fmt_List2Context");

			mapper.mapObjectToContext(listObject, ctx);

			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_List2Context");

			assertNotNull(iColl);
			assertEquals(listObject.size(), iColl.size());
			for (int i = 0; i < listObject.size(); i++) {
				assertEquals(listObject.get(i), iColl.getValueAt(String
						.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapStringArrayToContext() {
		try {
			Context ctx = getContext("Ctxt_StringArray2Context");

			WSMapperConverter mapper = getFormat("fmt_StringArray2Context");

			String[] obj = { "", "234", "dsF", "907H", "&*^%%" };
			mapper.mapObjectToContext(obj, ctx);

			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_StringArray2Context");

			assertNotNull(iColl);
			assertEquals(obj.length, iColl.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], iColl.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapBeanArrayToContext() {
		try {
			Context ctx = getContext("Ctxt_BeanArray2Context");

			WSMapperConverter mapper = getFormat("fmt_BeanArray2Context");

			Bean bean1 = new Bean("Bai Yue", 26);
			Bean bean2 = new Bean("Angel", 25);
			Bean[] beanArray = new Bean[] { bean1, bean2 };

			mapper.mapObjectToContext(beanArray, ctx);

			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_BeanArray2Context");

			assertNotNull(iColl);
			assertEquals(beanArray.length, iColl.size());
			assertEquals(bean1.getName(), iColl
					.getValueAt("0.strObjectFieldInBean"));
			assertEquals(bean1.getAge(), iColl.getValueAt("0.intFieldInBean"));
			assertEquals(bean2.getName(), iColl
					.getValueAt("1.strObjectFieldInBean"));
			assertEquals(bean2.getAge(), iColl.getValueAt("1.intFieldInBean"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapByteArrayToContext() {
		try {

			Context ctx = getContext("Ctxt_ByteArray2Context");

			WSMapperConverter mapper = getFormat("fmt_ByteArray2Context");

			byte[] byteArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 111 };
			mapper.mapObjectToContext(byteArray, ctx);

			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_ByteArray2Context");
			assertNotNull(iColl);

			assertEquals(byteArray.length, iColl.size());

			for (int i = 0; i < byteArray.length; i++) {
				assertEquals(byteArray[i], iColl.getValueAt(String.valueOf(i)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapCharArrayToContext() {
		try {

			Context ctx = getContext("Ctxt_CharArray2Context");

			WSMapperConverter mapper = getFormat("fmt_CharArray2Context");

			char[] charArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 111, 333, 666,
					888, 9999 };
			mapper.mapObjectToContext(charArray, ctx);

			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_CharArray2Context");
			assertNotNull(iColl);
			assertEquals(charArray.length, iColl.size());
			for (int i = 0; i < charArray.length; i++) {
				assertEquals(charArray[i], iColl.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapBooleanArrayToContext() {
		try {
			Context ctx = getContext("Ctxt_BooleanArray2Context");

			WSMapperConverter mapper = getFormat("fmt_BooleanArray2Context");

			boolean[] booleanArray = { false, true, false, false, true, true };
			mapper.mapObjectToContext(booleanArray, ctx);

			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_BooleanArray2Context");
			assertNotNull(iColl);

			assertEquals(booleanArray.length, iColl.size());
			for (int i = 0; i < booleanArray.length; i++) {
				assertEquals(booleanArray[i], iColl.getValueAt(String
						.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapShortArrayToContext() {
		try {
			Context ctx = getContext("Ctxt_ShortArray2Context");
			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_ShortArray2Context");

			WSMapperConverter mapper = getFormat("fmt_ShortArray2Context");

			short[] shortArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			mapper.mapObjectToContext(shortArray, ctx);

			assertNotNull(iColl);
			assertEquals(shortArray.length, iColl.size());

			for (int i = 0; i < shortArray.length; i++) {
				assertEquals(shortArray[i], iColl.getValueAt(String.valueOf(i)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapIntArrayToContext() {
		try {
			Context ctx = getContext("Ctxt_IntArray2Context");

			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_IntArray2Context");
			int oriLength = iColl.size();

			int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

			WSMapperConverter mapper = getFormat("fmt_IntArray2Context");
			mapper.mapObjectToContext(intArray, ctx);

			iColl = (IndexedCollection) ctx
					.getElementAt("IColl_IntArray2Context");
			int newLength = iColl.size();

			assertNotNull(iColl);

			assertEquals(5, oriLength);
			assertEquals(intArray.length, newLength);
			for (int i = 0; i < intArray.length; i++) {
				assertEquals(intArray[i], iColl.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapLongArrayToContext() {
		try {
			Context ctx = getContext("Ctxt_LongArray2Context");

			WSMapperConverter mapper = getFormat("fmt_LongArray2Context");
			long[] longArray = { 1, 2, 3l, 4, 5, 6, 7, 8, 9l, 0, 111, 33367l,
					666l, 8886578l, 9999l };
			mapper.mapObjectToContext(longArray, ctx);

			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_LongArray2Context");
			assertNotNull(iColl);
			assertEquals(longArray.length, iColl.size());
			for (int i = 0; i < longArray.length; i++) {
				assertEquals(longArray[i], iColl.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapFloatArrayToContext() {
		try {
			Context ctx = getContext("Ctxt_FloatArray2Context");

			WSMapperConverter mapper = getFormat("fmt_FloatArray2Context");

			float[] floatArray = { 1.123f, 2.23f, 3.34f, 4.34f, 5.34f, 6.34f,
					7.34f, 8, 9, 0.34f, 11.1f, 3.33f, 66.6f, 888f, 9999f };
			mapper.mapObjectToContext(floatArray, ctx);

			IndexedCollection iColl = (IndexedCollection) ctx
					.getElementAt("IColl_FloatArray2Context");
			assertNotNull(iColl);
			assertEquals(floatArray.length, iColl.size());
			for (int i = 0; i < floatArray.length; i++) {
				assertEquals(floatArray[i], iColl.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testMapDoubleArrayToContext() {
		try {
			Context ctx = getContext("Ctxt_DoubleArray2Context");

			WSMapperConverter mapper = getFormat("fmt_DoubleArray2Context");
			
			double[] doubleArray = { 1.123d, 2.23d, 3.34d, 4.34d, 5.34d, 6.34d, 7.34d, 8, 9, 0.34d,
					11.1d, 3.33d, 66.6d, 888d, 9999d };
			mapper.mapObjectToContext(doubleArray, ctx);

			IndexedCollection iColl = (IndexedCollection) ctx.getElementAt("IColl_DoubleArray2Context");
			assertNotNull(iColl);
			assertEquals(doubleArray.length, iColl.size());
			for (int i = 0; i < doubleArray.length; i++) {
				assertEquals(doubleArray[i], iColl.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	public void testMapStringToContext() {
		try {
			Context ctx = getContext("Ctxt_String2Context");

			WSMapperConverter mapper = getFormat("fmt_String2Context");

			String strObject= "Hello World!";
			mapper.mapObjectToContext(strObject, ctx);

			DataElement field = ctx.getElementAt("stringObject");
			assertNotNull(field);
			assertEquals(strObject, field.getValue());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	public void testMapJavaBeanToContext() {
		try {
			Context ctx = getContext("Ctxt_JavaBean2Context");
			
			WSMapperConverter mapper = getFormat("fmt_JavaBean2Context");
			
			JavaBean javaBean = new JavaBean();
			
			//assign value for the primitive attribute of javaBean
			byte byteValue = (byte)98;
			javaBean.setPrimitiveByte(byteValue);

			char charValue = (char)97;
			javaBean.setPrimitiveChar(charValue);
			
			short shortValue = (short)37455;
			javaBean.setPrimitiveShort(shortValue);
			
			int intValue = 65598;
			javaBean.setPrimitiveInt(intValue);
			
			long longValue = 9999L;
			javaBean.setPrimitiveLong(longValue);
			
			float floatValue = 2847.59f;
			javaBean.setPrimitiveFloat(floatValue);
			
			double doubleValue = 493879503.5839;
			javaBean.setPrimitiveDouble(doubleValue);
			
//			//assign value for the primitive array attribute of javaBean
//			byte[] byteArray = new byte[5];
//			for(int i=0; i<byteArray.length; i++){
//				byteArray[i] = (byte)rand.nextInt(Byte.MAX_VALUE);
//			}
//			javaBean.setPrimitiveByteArray(byteArray);
			
			char[] charArray = new char[5];
			for(int i=0; i<charArray.length; i++){
				charArray[i] = (char)rand.nextInt(Character.MAX_VALUE);
			}
			javaBean.setPrimitiveCharArray(charArray);
			
			short[] shortArray = new short[5];
			for(int i=0; i<shortArray.length; i++){
				shortArray[i] = (short)rand.nextInt(Short.MAX_VALUE);
			}
			javaBean.setPrimitiveShortArray(shortArray);
			
			int[] intArray = new int[5];
			for(int i=0; i<intArray.length; i++){
				intArray[i] = (int)rand.nextInt();
			}
			javaBean.setPrimitiveIntArray(intArray);
			
			long[] longArray = new long[5];
			for(int i=0; i<longArray.length; i++){
				longArray[i] = rand.nextLong();
			}
			javaBean.setPrimitiveLongArray(longArray);
			
			float[] floatArray = new float[5];
			for(int i=0; i<floatArray.length; i++){
				floatArray[i] = rand.nextFloat();
			}
			javaBean.setPrimitiveFloatArray(floatArray);
			
			double[] doubleArray = new double[5];
			for(int i=0; i<doubleArray.length; i++){
				doubleArray[i] = rand.nextDouble();
			}
			javaBean.setPrimitiveDoubleArray(doubleArray);
			
			//assign value for String object
			String strObject = "Hello World!";
			javaBean.setStringObject(strObject);
			
			//assign value for String object array
			String[] stringObjectArray = new String[]{"", "baiyue", "huangyanjun", "hello", "world"};
			javaBean.setStringObjectArray(stringObjectArray);
			
			//assign value for ArrayList<String>
			List<String> stringArrayList = new ArrayList<String>();
			stringArrayList.add("Hello");
			stringArrayList.add("World");
			stringArrayList.add("BaiYue");
			javaBean.setStringObjectList(stringArrayList);
			
			//assign value for SubJavaBean
			SubJavaBean subJavaBean = new SubJavaBean("baiyue", 43);
			javaBean.setSubJavaBean(subJavaBean);
			
			//assign value for SubJavaBean array
			SubJavaBean[] subJavaBeanArray = {new SubJavaBean("huangyanjun", 54), new SubJavaBean("lv shuang tao", 24)};
			javaBean.setSubJavaBeanArray(subJavaBeanArray);
			
			//assign value for SubJavaBean List
			List<SubJavaBean> subJavaBeanList = new ArrayList<SubJavaBean>();
			subJavaBeanList.add(new SubJavaBean("wangjianfeng", 52));
			subJavaBeanList.add(new SubJavaBean("xiashuang", 34));
			subJavaBeanList.add(new SubJavaBean("maqian", 22));
			javaBean.setSubJavaBeanList(subJavaBeanList);
			
			//Map
			mapper.mapObjectToContext(javaBean, ctx);
//		
			
			//test for primitive value
			assertEquals(byteValue, ctx.getValueAt("byteField"));
			assertEquals(charValue, ctx.getValueAt("charField"));
			assertEquals(shortValue, ctx.getValueAt("shortField"));
			assertEquals(intValue, ctx.getValueAt("intField"));
			assertEquals(longValue, ctx.getValueAt("longField"));
			assertEquals(floatValue, ctx.getValueAt("floatField"));
			assertEquals(doubleValue, ctx.getValueAt("doubleField"));
			
//			//test for primitve array(byte)
//			IndexedCollection iColl_PrimitiveByteArray = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_ByteArray");
//			assertEquals(byteArray.length, iColl_PrimitiveByteArray.size());
//			for(int i=0; i<byteArray.length; i++){
//				assertEquals(byteArray[i], iColl_PrimitiveByteArray.getValueAt(String.valueOf(i)));
//			}
			
			//test for primitve array(char)
			IndexedCollection iColl_PrimitiveCharArray = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_CharArray");
			assertEquals(charArray.length, iColl_PrimitiveCharArray.size());
			for(int i=0; i<charArray.length; i++){
				assertEquals(charArray[i], iColl_PrimitiveCharArray.getValueAt(String.valueOf(i)));
			}
			
			//test for primitve array(short)
			IndexedCollection iColl_PrimitiveShortArray = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_ShortArray");
			assertEquals(shortArray.length, iColl_PrimitiveShortArray.size());
			for(int i=0; i<shortArray.length; i++){
				assertEquals(shortArray[i], iColl_PrimitiveShortArray.getValueAt(String.valueOf(i)));
			}
			
			//test for primitve array(int)
			IndexedCollection iColl_PrimitiveIntArray = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_IntArray");
			assertEquals(intArray.length, iColl_PrimitiveIntArray.size());
			for(int i=0; i<intArray.length; i++){
				assertEquals(intArray[i], iColl_PrimitiveIntArray.getValueAt(String.valueOf(i)));
			}
			
			//test for primitve array(long)
			IndexedCollection iColl_PrimitiveLongArray = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_LongArray");
			assertEquals(longArray.length, iColl_PrimitiveLongArray.size());
			for(int i=0; i<longArray.length; i++){
				assertEquals(longArray[i], iColl_PrimitiveLongArray.getValueAt(String.valueOf(i)));
			}
			
			//test for primitve array(float)
			IndexedCollection iColl_PrimitiveFloatArray = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_FloatArray");
			assertEquals(floatArray.length, iColl_PrimitiveFloatArray.size());
			for(int i=0; i<floatArray.length; i++){
				assertEquals(floatArray[i], iColl_PrimitiveFloatArray.getValueAt(String.valueOf(i)));
			}
			
			//test for primitve array(double)
			IndexedCollection iColl_PrimitiveDoubleArray = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_DoubleArray");
			assertEquals(doubleArray.length, iColl_PrimitiveDoubleArray.size());
			for(int i=0; i<doubleArray.length; i++){
				assertEquals(doubleArray[i], iColl_PrimitiveDoubleArray.getValueAt(String.valueOf(i)));
			}
			
			//test for String object
			assertEquals(strObject,ctx.getValueAt("strObjectField"));
			
			//test for String object array
			IndexedCollection iColl_StringObjectArray = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_StringArray");
			assertEquals(stringObjectArray.length, iColl_StringObjectArray.size());
			for(int i=0; i<stringObjectArray.length; i++){
				assertEquals(stringObjectArray[i], iColl_StringObjectArray.getValueAt(String.valueOf(i)));
			}

			//test for ArrayList<String>
			IndexedCollection iColl_ArrayList = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_ArrayList");
			assertEquals(stringArrayList.size(), iColl_ArrayList.size());
			for(int i=0; i<stringArrayList.size(); i++){
				assertEquals(stringArrayList.get(i), iColl_ArrayList.getValueAt(String.valueOf(i)));
			}
			
			//test for SubJavaBean
			assertEquals(subJavaBean.getSomeThing(), ctx.getValueAt("KColl_JavaBean2Context_SubJavaBean.strObjectFieldInSubJavaBean"));
			assertEquals(subJavaBean.getIntValue(), ctx.getValueAt("KColl_JavaBean2Context_SubJavaBean.intFieldInSubJavaBean"));
		
			//test for SubJavaBean array
			IndexedCollection iColl_SubJavaBeanArray = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_SubJavaBeanArray");
			System.out.println(iColl_SubJavaBeanArray);
			assertEquals(subJavaBeanArray.length, iColl_SubJavaBeanArray.size());
			for(int i=0; i<subJavaBeanArray.length; i++){
				assertEquals(subJavaBeanArray[i].getSomeThing(), iColl_SubJavaBeanArray.getValueAt(i+ ".strObjectFieldInSubJavaBean"));
				assertEquals(subJavaBeanArray[i].getIntValue(), iColl_SubJavaBeanArray.getValueAt(i+ ".intFieldInSubJavaBean"));
			}
			
			//test for SubJavaBean List
			IndexedCollection iColl_SubJavaBeanList = (IndexedCollection)ctx.getElementAt("IColl_JavaBean2Context_SubJavaBeanList");
			System.out.println(iColl_SubJavaBeanList);
			System.out.println(iColl_SubJavaBeanList.size());
			assertEquals(iColl_SubJavaBeanList.size(), iColl_SubJavaBeanList.size());
			for(int i=0; i<subJavaBeanList.size(); i++){
				assertEquals(subJavaBeanList.get(i).getSomeThing(), iColl_SubJavaBeanList.getValueAt(i+ ".strObjectFieldInSubJavaBean"));
				assertEquals(subJavaBeanList.get(i).getIntValue(), iColl_SubJavaBeanList.getValueAt(i+ ".intFieldInSubJavaBean"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
