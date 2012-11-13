/**
 * Created by lvst at 2010-8-25 04:25:28 PM
 */
package com.ibm.btt.wsc.mapper.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.IndexedCollection;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.bean.TypeManager;
import com.ibm.btt.wsc.mapper.beans.WMCBW1112;
import com.ibm.btt.wsc.mapper.beans.WMCBW11141;
import com.ibm.btt.wsc.mapper.beans.WMCBW11142;
import com.ibm.btt.wsc.mapper.beans.WMCBW1116;
import com.ibm.btt.wsc.mapper.beans.WMCBW1116PartConvTypeWS;

/**
 * @author lvst
 * 
 */
public class BD2WDMapperSimpleStructure extends MapperTestSuper {
	Random rand = new Random();
	String exceptStr="can not be mapped to the primitive";

	public void testWMCBW1111() {
		try {
			Context ctx = getContext("WMCBW1111");
			WSMapperConverter mapper = getFormat("WMCBW1111");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals("value1", obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW1111Boolean() {
		try {
			Context ctx = getContext("WMCBW1111");
			boolean bool = rand.nextBoolean();
			ctx.setValueAt("field1", bool);
			WSMapperConverter mapper = getFormat("WMCBW1111Boolean");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(bool, obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW1111Integer() {
		try {
			Context ctx = getContext("WMCBW1111");
			int in = rand.nextInt();
			ctx.setValueAt("field1", in);
			WSMapperConverter mapper = getFormat("WMCBW1111Integer");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(in, obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW1111Character() {
		try {
			Context ctx = getContext("WMCBW1111");
			char ch = (char) rand.nextInt(Character.MAX_VALUE);
			ctx.setValueAt("field1", ch);
			WSMapperConverter mapper = getFormat("WMCBW1111Character");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(ch, obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW1111Pri() {
		try {
			Context ctx = getContext("WMCBW1111");
			ctx.setValueAt("field1", (int) 1024);
			WSMapperConverter mapper = getFormat("WMCBW1111Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals((int) 1024, obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW1111Err() {
		try {
			Context ctx = getContext("WMCBW1111");
			WSMapperConverter mapper = getFormat("WMCBW1111Err");
			mapper.mapContextToObject(ctx);
			fail("He should be an exception!");
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(e.getMessage().indexOf("NOT_A_VALID_JAVA_CLASS") > -1);
		}
	}

	public void testWMCBW1112() {
		try {
			Context ctx = getContext("WMCBW1112");
			WSMapperConverter mapper = getFormat("WMCBW1112");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW1112.class.getName(), obj.getClass().getName());
			WMCBW1112 ret = (WMCBW1112) obj;
			assertEquals("value1", ret.getField1());
			assertEquals(1048576, ret.getField2().intValue());
			assertEquals(1048.576d, ret.getField3());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11131() {
		try {
			Context ctx = getContext("WMCBW11131");
			WSMapperConverter mapper = getFormat("WMCBW11131");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(String.class.getName()) > 0);
			String[] str = (String[]) obj;
			assertEquals(3, str.length);
			for (int i = 0; i < str.length; i++) {
				assertEquals("value4innerIcollField", str[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11131List() {
		try {
			Context ctx = getContext("WMCBW11131");
			WSMapperConverter mapper = getFormat("WMCBW11131List");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(obj.getClass(), ArrayList.class);
			ArrayList<String> str = (ArrayList<String>) obj;
			assertEquals(3, str.size());
			for (int i = 0; i < str.size(); i++) {
				assertEquals("value4innerIcollField", str.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11131Boolean() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextBoolean());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131Boolean");
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

	public void testWMCBW11131BooleanList() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextBoolean());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131BooleanList");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			ArrayList retVals = (ArrayList) obj;
			assertEquals(3, retVals.size());
			for (int i = 0; i < retVals.size(); i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11131Byte() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), (byte) rand.nextInt(Byte.MAX_VALUE));
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131Byte");
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

	public void testWMCBW11131Char() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), (char) rand.nextInt(Character.MAX_VALUE));
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131Char");
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

	public void testWMCBW11131Double() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextDouble());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131Double");
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

	public void testWMCBW11131DoubleList() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextDouble());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131DoubleList");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			List retVals = (List) obj;
			assertEquals(3, retVals.size());
			for (int i = 0; i < retVals.size(); i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11131Float() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextFloat());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131Float");
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

	public void testWMCBW11131Int() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextInt());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131Int");
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

	public void testWMCBW11131IntList() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextInt());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131IntList");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			List retVals = (List) obj;
			assertEquals(3, retVals.size());
			for (int i = 0; i < retVals.size(); i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11131Long() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextLong());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131Long");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			long[] retVals = (long[]) obj;
			assertEquals(3, retVals.length);
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11131LongList() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextLong());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131LongList");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			List retVals = (List) obj;
			assertEquals(3, retVals.size());
			for (int i = 0; i < retVals.size(); i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11131Short() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), (short) rand.nextInt(Short.MAX_VALUE));
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131Short");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			short[] retVals = (short[]) obj;
			assertEquals(3, retVals.length);
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11132() {
		try {
			Context ctx = getContext("WMCBW11132");
			WSMapperConverter mapper = getFormat("WMCBW11132");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(WMCBW1112.class.getName()) > 0);
			WMCBW1112[] retBeans = (WMCBW1112[]) obj;
			assertEquals(9, retBeans.length);
			for (int i = 0; i < retBeans.length; i++) {
				assertEquals("Compare value at index: " + i, "value1", retBeans[i].getField1());
				assertEquals("Compare value at index: " + i, 1048576, retBeans[i].getField2().intValue());
				assertEquals("Compare value at index: " + i, 1048.576d, retBeans[i].getField3());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11132List() {
		try {
			Context ctx = getContext("WMCBW11132");
			WSMapperConverter mapper = getFormat("WMCBW11132List");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(ArrayList.class, obj.getClass());
			ArrayList<WMCBW1112> retBeans = (ArrayList<WMCBW1112>) obj;
			assertEquals(9, retBeans.size());
			for (int i = 0; i < retBeans.size(); i++) {
				WMCBW1112 anRetBean = retBeans.get(i);
				assertEquals("Compare value at index: " + i, "value1", anRetBean.getField1());
				assertEquals("Compare value at index: " + i, 1048576, anRetBean.getField2().intValue());
				assertEquals("Compare value at index: " + i, 1048.576d, anRetBean.getField3());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11141() {
		try {
			Context ctx = getContext("WMCBW11141");
			WSMapperConverter mapper = getFormat("WMCBW11141");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW11141.class.getName(), obj.getClass().getName());
			WMCBW11141 ret = (WMCBW11141) obj;
			assertEquals(1024, ret.getIntPrimitiveField());
			assertEquals(1048576L, ret.getLongPrimitiveField());
			assertEquals('L', ret.getCharPrimitiveField());
			assertEquals(8192, ret.getShortPrimitiveField());
			assertEquals(1024.512f, ret.getFloatPrimitiveField());
			assertEquals(1048576.2048d, ret.getDoublePrimitiveField());
			assertEquals(true, ret.isBooleanPrimitiveField());
			assertEquals(64, ret.getBytePrimitiveField());
			assertEquals(new Character('L'), ret.getCharacterField());
			assertEquals("LvShuangTao", ret.getStringField());
			assertNull(ret.getBooleanField());
			assertNull(ret.getByteField());
			assertNull(ret.getDoubleField());
			assertNull(ret.getFloatField());
			assertNull(ret.getIntegerField());
			assertNull(ret.getLongField());
			assertNull(ret.getShortField());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11141Asterisk() {
		try {
			Context ctx = getContext("WMCBW11141");
			WSMapperConverter mapper = getFormat("WMCBW11141Asterisk");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW11141.class.getName(), obj.getClass().getName());
			WMCBW11141 ret = (WMCBW11141) obj;
			assertEquals(1024, ret.getIntPrimitiveField());
			assertEquals(1048576L, ret.getLongPrimitiveField());
			assertEquals('L', ret.getCharPrimitiveField());
			assertEquals(8192, ret.getShortPrimitiveField());
			assertEquals(1024.512f, ret.getFloatPrimitiveField());
			assertEquals(1048576.2048d, ret.getDoublePrimitiveField());
			assertEquals(true, ret.isBooleanPrimitiveField());
			assertEquals(64, ret.getBytePrimitiveField());
			assertEquals(new Character('L'), ret.getCharacterField());
			assertEquals("LvShuangTao", ret.getStringField());
			assertNull(ret.getBooleanField());
			assertNull(ret.getByteField());
			assertNull(ret.getDoubleField());
			assertNull(ret.getFloatField());
			assertNull(ret.getIntegerField());
			assertNull(ret.getLongField());
			assertNull(ret.getShortField());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11142() {
		try {
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCBW11142");
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			List<Object> list = new ArrayList<Object>();
			list.add("abc");
			Set<Object> set = new HashSet<Object>();
			set.add("cba");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("abc", "abcdefg");
			ctx.setValueAt("WMCBW11142BColl.date", date);
			ctx.setValueAt("WMCBW11142BColl.calendar", cal);
			ctx.setValueAt("WMCBW11142BColl.list", list);
			ctx.setValueAt("WMCBW11142BColl.set", set);
			ctx.setValueAt("WMCBW11142BColl.map", map);
			WSMapperConverter mapper = getFormat("WMCBW11142");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW11142.class.getName(), obj.getClass().getName());
			WMCBW11142 ret = (WMCBW11142) obj;
			assertEquals(date, ret.getDate());
			assertEquals(cal, ret.getCalendar());
			assertEquals(list, ret.getList());
			assertEquals(set, ret.getSet());
			assertEquals(map, ret.getMap());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11142Clone() {
		try {
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCBW11142");
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			List<Object> list = new ArrayList<Object>();
			list.add("abc");
			Set<Object> set = new HashSet<Object>();
			set.add("cba");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("abc", "abcdefg");
			ctx.setValueAt("WMCBW11142BColl.date", date);
			ctx.setValueAt("WMCBW11142BColl.calendar", cal);
			ctx.setValueAt("WMCBW11142BColl.list", list);
			ctx.setValueAt("WMCBW11142BColl.set", set);
			ctx.setValueAt("WMCBW11142BColl.map", map);
			WSMapperConverter mapper = getFormat("WMCBW11142Clone");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW11142.class.getName(), obj.getClass().getName());
			WMCBW11142 ret = (WMCBW11142) obj;
			assertEquals(date, ret.getDate());
			assertEquals(cal, ret.getCalendar());
			assertEquals(list, ret.getList());
			assertEquals(set, ret.getSet());
			assertEquals(map, ret.getMap());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11151() {
		try {
			Context ctx = getContext("WMCBW11151");
			WSMapperConverter mapper = getFormat("WMCBW11151");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(Integer.class, obj.getClass());
			assertEquals(1048576, ((Integer) obj).intValue());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11151NoConvType() {
		try {
			Context ctx = getContext("WMCBW11151");
			WSMapperConverter mapper = getFormat("WMCBW11151NoConvType");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(Integer.class, obj.getClass());
			assertEquals(1048576, ((Integer) obj).intValue());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11151WrongConvType() {
		try {
			Context ctx = getContext("WMCBW11151");
			WSMapperConverter mapper = getFormat("WMCBW11151WrongConvType");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(Integer.class, obj.getClass());
			assertEquals(1048576, ((Integer) obj).intValue());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11152() {
		try {
			Context ctx = getContext("WMCBW11152");
			WSMapperConverter mapper = getFormat("WMCBW11152");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(String.class, obj.getClass());
			assertEquals("LvShuangTao", obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			fail("DEFECT:25863 "+e.toString());
		}
	}

	public void testWMCBW1116() {
		try {
			Context ctx = getContext("WMCBW1116");
			WSMapperConverter mapper = getFormat("WMCBW1116");
			String strVal = "LLvShuangTao";
			ctx.setValueAt("WMCBW1116.strMandatory", strVal);
			// this field is not mapped from context to bean
			ctx.setValueAt("WMCBW1116.strOptional", strVal);
			Integer intVal = new Integer(1234567);
			ctx.setValueAt("WMCBW1116.intOptional", intVal);
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW1116.class, obj.getClass());
			WMCBW1116 ret = (WMCBW1116) obj;
			assertEquals(strVal, ret.getStrMandatory());
			assertNotSame(strVal, ret.getStrOptional());
			assertEquals(intVal, ret.getIntOptional());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW1116PartConvTypeWS() {
		try {
			Context ctx = getContext("WMCBW1116PartConvTypeWS");
			WSMapperConverter mapper = getFormat("WMCBW1116PartConvTypeWS");
			String strVal = "LLvShuangTao";
			ctx.setValueAt("WMCBW1116PartConvTypeWS.strMandatory", strVal);
			ctx.setValueAt("WMCBW1116PartConvTypeWS.strOptional", strVal);
			Integer intVal = new Integer(1234567);
			ctx.setValueAt("WMCBW1116PartConvTypeWS.intOptional", intVal);
			String anotherVal = "someone just like";
			ctx.setValueAt("WMCBW1116PartConvTypeWS.strNoWsConvMandatory", anotherVal);
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW1116PartConvTypeWS.class, obj.getClass());
			WMCBW1116PartConvTypeWS ret = (WMCBW1116PartConvTypeWS) obj;
			assertEquals(anotherVal, ret.getStrNoWsConvMandatory());
			assertEquals(strVal, ret.getStrMandatory());
			assertEquals(strVal, ret.getStrOptional());
			assertEquals(intVal, ret.getIntOptional());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW1117() {
		try {
			Context ctx = getContext("WMCBW1117");
			String strVal = "LLvShuangTao";
			ctx.setValueAt("WMCBW1117.1.strMandatory", strVal);
			ctx.setValueAt("WMCBW1117.1.strOptional", strVal);
			Integer intVal = new Integer(1234567);
			ctx.setValueAt("WMCBW1117.1.intOptional", intVal);
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW1117");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(WMCBW1116.class.getName()) > 0);
			WMCBW1116[] rets = (WMCBW1116[]) obj;
			assertEquals(3, rets.length);

			assertEquals(ctx.getValueAt("WMCBW1117.1.strMandatory").toString(), rets[1].getStrMandatory());
			assertEquals(Integer.valueOf(ctx.getValueAt("WMCBW1117.1.intOptional").toString()), rets[1].getIntOptional());
			for (int i = 0; i < rets.length; i++) {
				if (i == 1)
					continue;
				assertEquals(ctx.getValueAt("WMCBW1117." + i + ".strMandatory").toString(), rets[i].getStrMandatory());
				assertEquals(Integer.valueOf(ctx.getValueAt("WMCBW1117." + i + ".intOptional").toString()),
						rets[i].getIntOptional());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW1117PartConvTypeWS() {
		try {
			Context ctx = getContext("WMCBW1117PartConvTypeWS");
			String strVal = "LLvShuangTao";
			ctx.setValueAt("WMCBW1117PartConvTypeWS.2.strMandatory", strVal);
			ctx.setValueAt("WMCBW1117PartConvTypeWS.2.strOptional", strVal);
			Integer intVal = new Integer(1234567);
			ctx.setValueAt("WMCBW1117PartConvTypeWS.2.intOptional", intVal);
			String anotherVal = "someone just like";
			ctx.setValueAt("WMCBW1117PartConvTypeWS.2.strNoWsConvMandatory", anotherVal);
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW1117PartConvTypeWS");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(WMCBW1116.class.getName()) > 0);
			WMCBW1116PartConvTypeWS[] rets = (WMCBW1116PartConvTypeWS[]) obj;
			assertEquals(3, rets.length);
			assertEquals(ctx.getValueAt("WMCBW1117PartConvTypeWS.2.strMandatory").toString(), rets[2].getStrMandatory());
			assertEquals(Integer.valueOf(ctx.getValueAt("WMCBW1117PartConvTypeWS.2.intOptional").toString()),
					rets[2].getIntOptional());
			assertEquals(ctx.getValueAt("WMCBW1117PartConvTypeWS.2.strOptional"), rets[2].getStrOptional());
			assertEquals(ctx.getValueAt("WMCBW1117PartConvTypeWS.2.strNoWsConvMandatory"), rets[2].getStrNoWsConvMandatory());

			for (int i = 0; i < rets.length; i++) {
				if (i == 2)
					continue;
				assertEquals(ctx.getValueAt("WMCBW1117PartConvTypeWS." + i + ".strMandatory").toString(),
						rets[i].getStrMandatory());
				assertEquals(Integer.valueOf(ctx.getValueAt("WMCBW1117PartConvTypeWS." + i + ".intOptional").toString()),
						rets[i].getIntOptional());
				assertEquals(ctx.getValueAt("WMCBW1117PartConvTypeWS." + i + ".strOptional"), rets[i].getStrOptional());
				assertEquals(ctx.getValueAt("WMCBW1117PartConvTypeWS." + i + ".strNoWsConvMandatory"),
						rets[i].getStrNoWsConvMandatory());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	/**
	 * add cases for isPrimitive=true validation
	 */
	public void testWMCWB121Int_Pri() {
		try {
			Context ctx = getContext("WMCWB121");
			int input=1;
			ctx.setValueAt("intDestField", input);
			WSMapperConverter mapper = getFormat("WMCWB121Int_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(input, obj);
		} catch (Exception e) {
			if(e.toString().indexOf(exceptStr)<0){
				e.printStackTrace();
				fail(e.toString());
			}
			
			
			
		}
	}
	
	public void testWMCWB121Long_Pri() {
		try {
			Context ctx = getContext("WMCWB121");
			long input=10988990;
			ctx.setValueAt("longDestField", input);
			WSMapperConverter mapper = getFormat("WMCWB121Long_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(input, obj);
		} catch (Exception e) {
			if(e.toString().indexOf(exceptStr)<0){
				e.printStackTrace();
				fail(e.toString());
			}
		}
	}
	
	public void testWMCWB121Char_Pri() {
		try {
			Context ctx = getContext("WMCWB121");
			char input = (char) rand.nextInt(Character.MAX_VALUE);
			ctx.setValueAt("charDestField", input);
			WSMapperConverter mapper = getFormat("WMCWB121Char_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(input, obj);
		} catch (Exception e) {
			if(e.toString().indexOf(exceptStr)<0){
				e.printStackTrace();
				fail(e.toString());
			}
		}
	}
	
	public void testWMCWB121Short_Pri() {
		try {
			Context ctx = getContext("WMCWB121");
			short input = (short) rand.nextInt(Short.MAX_VALUE);
			ctx.setValueAt("shortDestField", input);
			WSMapperConverter mapper = getFormat("WMCWB121Short_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(input, obj);
		} catch (Exception e) {
			if(e.toString().indexOf(exceptStr)<0){
				e.printStackTrace();
				fail(e.toString());
			}
		}
	}
	
	public void testWMCWB121Float_Pri() {
		try {
			Context ctx = getContext("WMCWB121");
			float input = rand.nextFloat();
			ctx.setValueAt("floatDestField", input);
			WSMapperConverter mapper = getFormat("WMCWB121Float_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(input, obj);
		} catch (Exception e) {
			if(e.toString().indexOf(exceptStr)<0){
				e.printStackTrace();
				fail(e.toString());
			}
		}
	}
	
	public void testWMCWB121Double_Pri() {
		try {
			Context ctx = getContext("WMCWB121");
			double input = rand.nextDouble();
			ctx.setValueAt("doubleDestField", input);
			WSMapperConverter mapper = getFormat("WMCWB121Double_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(input, obj);
		} catch (Exception e) {
			if(e.toString().indexOf(exceptStr)<0){
				e.printStackTrace();
				fail(e.toString());
			}
		}
	}
	
	public void testWMCWB121Boolean_Pri() {
		try {
			Context ctx = getContext("WMCWB121");
			boolean input = rand.nextBoolean();
			ctx.setValueAt("booleanDestField", input);
			WSMapperConverter mapper = getFormat("WMCWB121Boolean_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(input, obj);
		} catch (Exception e) {
			if(e.toString().indexOf(exceptStr)<0){
				e.printStackTrace();
				fail(e.toString());
			}
		}
	}
	
	public void testWMCWB121Byte_Pri() {
		try {
			Context ctx = getContext("WMCWB121");
			byte input =(byte) rand.nextInt(Byte.MAX_VALUE);
			ctx.setValueAt("byteDestField", input);
			WSMapperConverter mapper = getFormat("WMCWB121Byte_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(input, obj);
		} catch (Exception e) {
			if(e.toString().indexOf(exceptStr)<0){
				e.printStackTrace();
				fail(e.toString());
			}
		}
	}
	
	
	public void testWMCBW11131IntList_Pri() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextInt()+"");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131IntList_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			List retVals = (List) obj;
			assertEquals(3, retVals.size());
			for (int i = 0; i < retVals.size(); i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	
	/**
	public void testWMCBW11131Long_Pri() {
		try {
			Context ctx = getContext("WMCBW11131");
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("WMCBW11131IColl");
			for (int i = 0; i < icoll.size(); i++)
				icoll.setValueAt(String.valueOf(i), rand.nextLong());
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11131Long_Pri");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			long[] retVals = (long[]) obj;
			assertEquals(3, retVals.length);
			for (int i = 0; i < retVals.length; i++) {
				assertEquals(icoll.getValueAt(String.valueOf(i)), retVals[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	**/
	
	
	
}
	
	
