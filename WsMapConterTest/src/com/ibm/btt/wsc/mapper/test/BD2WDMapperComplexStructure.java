/**
 * Created by lvst at 2010-8-26 05:06:40 PM
 */
package com.ibm.btt.wsc.mapper.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.DataField;
import com.ibm.btt.base.IndexedCollection;
import com.ibm.btt.base.KeyedCollection;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.bean.BeanCollection;
import com.ibm.btt.bean.TypeManager;
import com.ibm.btt.wsc.mapper.beans.BWFromBeanSimple;
import com.ibm.btt.wsc.mapper.beans.Inner4Array;
import com.ibm.btt.wsc.mapper.beans.WMCBW1112;
import com.ibm.btt.wsc.mapper.beans.WMCBW1116;
import com.ibm.btt.wsc.mapper.beans.WMCBW1121121;
import com.ibm.btt.wsc.mapper.beans.WMCBW11223;
import com.ibm.btt.wsc.mapper.beans.WMCBW11231;
import com.ibm.btt.wsc.mapper.beans.WMCBW11231DestBean;
import com.ibm.btt.wsc.mapper.beans.WMCWB12323;
import com.ibm.btt.wsc.mapper.beans.WMCWB12323List;

/**
 * @author lvst
 * 
 */
public class BD2WDMapperComplexStructure extends MapperTestSuper {
	Random rand = new Random();

	public void testWMCBW112111() {
		try {
			Context ctx = getContext("WMCBW112111");
			ctx.setValueAt("levelOneKColl.levelTwoIColl.0", "Lv");
			ctx.setValueAt("levelOneKColl.levelTwoIColl.1", "Shuang");
			ctx.setValueAt("levelOneKColl.levelTwoIColl.2", "Tao");
			WSMapperConverter mapper = getFormat("WMCBW112111");
			System.out.println(mapper);
			System.out.println(ctx.getKeyedCollection());
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(String.class.getName()) > -1);
			String[] ret = (String[]) obj;
			assertEquals(3, ret.length);
			assertEquals(ctx.getValueAt("levelOneKColl.levelTwoIColl.0").toString(), ret[0]);
			assertEquals(ctx.getValueAt("levelOneKColl.levelTwoIColl.1").toString(), ret[1]);
			assertEquals(ctx.getValueAt("levelOneKColl.levelTwoIColl.2").toString(), ret[2]);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW1121121() {
		try {
			Context ctx = getContext("WMCBW1121121");
			ctx.setValueAt("levelOneKColl.levelTwoIColl.0.strField", "Lv");
			ctx.setValueAt("levelOneKColl.levelTwoIColl.1.intField", 1234);
			ctx.setValueAt("levelOneKColl.levelTwoIColl.2.doubleField", 12.3456d);
			WSMapperConverter mapper = getFormat("WMCBW1121121");
			System.out.println(ctx.getKeyedCollection());
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			WMCBW1121121[] ret = (WMCBW1121121[]) obj;
			assertEquals(3, ret.length);
			assertEquals(ctx.getValueAt("levelOneKColl.levelTwoIColl.0.strField"), ret[0].getStrField());
			assertEquals(Integer.valueOf(ctx.getValueAt("levelOneKColl.levelTwoIColl.1.intField").toString()).intValue(),
					ret[1].getIntField());
			assertEquals(Double.valueOf(ctx.getValueAt("levelOneKColl.levelTwoIColl.2.doubleField").toString()).doubleValue(),
					ret[2].getDoubleField());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW112113() {
		// TODO 2d,3d array, are not supported by ws mapper, user can map them
		// by their selves
		try {
			Context ctx = getContext("WMCBW112113");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW112113");
			System.out.println(ctx.getKeyedCollection());
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			WMCBW1121121[] ret = (WMCBW1121121[]) obj;
			assertEquals(3, ret.length);

			for (int i = 0; i < ret.length; i++) {
				assertEquals(ctx.getValueAt("levelOneKColl.levelTwoIColl.0." + i + ".strField"), ret[i].getStrField());
				assertEquals(Integer.valueOf(ctx.getValueAt("levelOneKColl.levelTwoIColl.0." + i + ".intField").toString())
						.intValue(), ret[i].getIntField());
				assertEquals(Double.valueOf(ctx.getValueAt("levelOneKColl.levelTwoIColl.0." + i + ".doubleField").toString())
						.doubleValue(), ret[i].getDoubleField());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW112121() {
		try {
			Context ctx = getContext("WMCBW112121");
			ctx.setValueAt("levelOneKColl.levelTwoKColl.strField", "LvShuangTao");
			ctx.setValueAt("levelOneKColl.levelTwoKColl.intField", new Integer(11111));
			ctx.setValueAt("levelOneKColl.levelTwoKColl.doubleField", new Double(10223.332d));
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW112121");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW1112.class, obj.getClass());
			WMCBW1112 ret = (WMCBW1112) obj;
			assertEquals(ctx.getValueAt("levelOneKColl.levelTwoKColl.strField"), ret.getField1());
			assertEquals(ctx.getValueAt("levelOneKColl.levelTwoKColl.intField"), ret.getField2());
			assertEquals(ctx.getValueAt("levelOneKColl.levelTwoKColl.doubleField"), ret.getField3());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW112122() {
		try {
			Context ctx = getContext("WMCBW112122");
			for (int i = 0; i < 5; i++) {
				ctx.setValueAt("levelOneKColl.levelTwoKColl.levelThreeIColl." + i, new Double(rand.nextDouble()));
			}
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW112122");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(Double.class.getName()) > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11213() {
		try {
			Context ctx = getContext("WMCBW11213");
			ctx.setValueAt("levelOneKColl.WMCBW11213.strMandatory", "stlv@cn.ibm.com");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11213");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW1116.class, obj.getClass());
			WMCBW1116 ret = (WMCBW1116) obj;
			assertEquals(ctx.getValueAt("levelOneKColl.WMCBW11213.strMandatory"), ret.getStrMandatory());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11214() {
		try {
			Context ctx = getContext("WMCBW11214");
			for (int i = 0; i < 5; i++)
				ctx.setValueAt("levelOneKColl.WMCBW11214." + i + ".strMandatory", String.valueOf(rand.nextFloat()));
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11214");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(WMCBW1116.class.getName()) > 0);
			WMCBW1116[] ret = (WMCBW1116[]) obj;
			assertEquals(5, ret.length);
			for (int i = 0; i < ret.length; i++) {
				assertEquals(ctx.getValueAt("levelOneKColl.WMCBW11214." + i + ".strMandatory"), ret[i].getStrMandatory());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW112222() {
		// TODO for array that have more than one dimension, you should convert
		// it to one dimension array, since btt data mapper format does not
		// support that
		try {
			Context ctx = getContext("WMCBW112222");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 2; k++) {
						ctx.setValueAt("levelOneIColl." + i + "." + j + "." + k, new Float(rand.nextFloat()).toString());
					}
				}
			}
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW112222");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			if (obj instanceof String[]) {
				String[] strs = (String[]) obj;
				for (int i = 0; i < strs.length; i++) {
					assertEquals(ctx.getValueAt("levelOneIColl.0.0." + i), strs[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11223() {
		try {
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCBW11223");
			for (int i = 0; i < 3; i++) {
				ctx.setValueAt("levelOneIColl." + i + ".charPrimitiveFromField", (char) rand.nextInt(Character.MAX_VALUE));
				ctx.setValueAt("levelOneIColl." + i + ".shortPrimitiveFromField", (short) rand.nextInt(Short.MAX_VALUE));
				ctx.setValueAt("levelOneIColl." + i + ".booleanPrimitiveFromField", rand.nextBoolean());
				ctx.setValueAt("levelOneIColl." + i + ".bytePrimitiveFromField", (byte) rand.nextInt(Byte.MAX_VALUE));
				ctx.setValueAt("levelOneIColl." + i + ".booleanFromField", rand.nextBoolean());
				ctx.setValueAt("levelOneIColl." + i + ".characterFromField",
						new Character((char) rand.nextInt(Character.MAX_VALUE)));
				ctx.setValueAt("levelOneIColl." + i + ".byteFromField", new Byte((byte) rand.nextInt(Byte.MAX_VALUE)));
				ctx.setValueAt("levelOneIColl." + i + ".shortFromField", new Short((short) rand.nextInt(Short.MAX_VALUE)));
				ctx.setValueAt("levelOneIColl." + i + ".dateFromField", new Date());
				ctx.setValueAt("levelOneIColl." + i + ".calendarFromField", Calendar.getInstance());
			}
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11223");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(WMCBW11223.class.getName()) > 0);
			WMCBW11223[] ret = (WMCBW11223[]) obj;
			assertEquals(3, ret.length);
			for (int i = 0; i < 3; i++) {
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".charPrimitiveFromField"), ret[i].getCharPrimitiveToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".shortPrimitiveFromField"),
						ret[i].getShortPrimitiveToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".booleanPrimitiveFromField"),
						ret[i].isBooleanPrimitiveToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".bytePrimitiveFromField"), ret[i].getBytePrimitiveToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".booleanFromField"), ret[i].getBooleanToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".characterFromField"), ret[i].getCharacterToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".byteFromField"), ret[i].getByteToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".shortFromField"), ret[i].getShortToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".dateFromField"), ret[i].getDateToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".calendarFromField"), ret[i].getCalendarToField());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11223TypeMisMatch() {
		try {
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCBW11223");
			for (int i = 0; i < 3; i++) {
				ctx.setValueAt("levelOneIColl." + i + ".charPrimitiveFromField", (char) rand.nextInt(Character.MAX_VALUE));
				ctx.setValueAt("levelOneIColl." + i + ".shortPrimitiveFromField", (short) rand.nextInt(Short.MAX_VALUE));
				ctx.setValueAt("levelOneIColl." + i + ".booleanPrimitiveFromField", rand.nextBoolean());
				ctx.setValueAt("levelOneIColl." + i + ".bytePrimitiveFromField", (byte) rand.nextInt(Byte.MAX_VALUE));
				ctx.setValueAt("levelOneIColl." + i + ".booleanFromField", rand.nextBoolean());
				ctx.setValueAt("levelOneIColl." + i + ".characterFromField",
						new Character((char) rand.nextInt(Character.MAX_VALUE)));
				ctx.setValueAt("levelOneIColl." + i + ".byteFromField", new Byte((byte) rand.nextInt(Byte.MAX_VALUE)));
				ctx.setValueAt("levelOneIColl." + i + ".shortFromField", new Short((short) rand.nextInt(Short.MAX_VALUE)));
				ctx.setValueAt("levelOneIColl." + i + ".dateFromField", new Date());
				ctx.setValueAt("levelOneIColl." + i + ".calendarFromField", Calendar.getInstance());
			}
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11223TypeMisMatch");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertTrue(obj.getClass().getName().indexOf(WMCBW11223.class.getName()) > 0);
			WMCBW11223[] ret = (WMCBW11223[]) obj;
			assertEquals(3, ret.length);
			for (int i = 0; i < 3; i++) {
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".charPrimitiveFromField"), ret[i].getCharacterToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".shortPrimitiveFromField"), ret[i].getShortToField());

				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".booleanPrimitiveFromField"), ret[i].getBooleanToField());

				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".bytePrimitiveFromField"), ret[i].getByteToField());

				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".booleanFromField"), ret[i].isBooleanPrimitiveToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".characterFromField"), ret[i].getCharPrimitiveToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".byteFromField"), ret[i].getBytePrimitiveToField());
				assertEquals(ctx.getValueAt("levelOneIColl." + i + ".shortFromField"), ret[i].getShortPrimitiveToField());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11231() {
		try {
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCBW11231");
			// ctx.tryGetElementAt("WMCBW11231.innerBeanNull.shortPrimitiveFromField");
			// ctx.setValueAt("WMCBW11231.innerBeanNull.shortPrimitiveFromField",
			// (short)123);
			BeanCollection bcoll = (BeanCollection) ctx.getElementAt("WMCBW11231");
			bcoll.setCreateInstance(true);
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11231");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW11231DestBean.class, obj.getClass());
			WMCBW11231DestBean dest = (WMCBW11231DestBean) obj;
			WMCBW11231 src = (WMCBW11231) ((BeanCollection) ctx.getElementAt("WMCBW11231")).getBean();
			assertEquals(src.getStringField(), dest.getStringDestField());
			assertEquals(src.getIntegerField(), dest.getIntegerDestField());
			assertEquals(src.getDateField(), dest.getDateDestField());

			Integer[] intSrcArray = src.getIntegerArray();
			Integer[] intDestArray = dest.getIntegerDestArray();
			assertNotNull(intDestArray);
			assertEquals(intSrcArray.length, intDestArray.length);
			for (int i = 0; i < intSrcArray.length; i++) {
				assertEquals(intSrcArray[i], intDestArray[i]);
			}

			String[] strSrcArray = src.getStringArray();
			String[] strDestArray = dest.getStringDestArray();
			assertNotNull(strDestArray);
			assertEquals(strSrcArray.length, strDestArray.length);
			for (int i = 0; i < strSrcArray.length; i++) {
				assertEquals(strSrcArray[i], strDestArray[i]);
			}

			assertEquals(2, dest.getDateDestArray().length);
			// assertNull(dest.getInnerDestBeanNull());

			assertEquals(src.getInnerBean().getCharacterFromField(), dest.getInnerDestBean().getCharacterToField());

			BWFromBeanSimple[] srcBeanInner = src.getInnerBeanArray();
			WMCBW11223[] destBeanInner = dest.getInnerDestBeanArray();
			assertNotNull(destBeanInner);
			assertEquals(srcBeanInner.length, destBeanInner.length);
			for (int i = 0; i < srcBeanInner.length; i++) {
				assertEquals(srcBeanInner[i].getCharacterFromField(), destBeanInner[i].getCharacterToField());
			}

			String[][] src2dArray = src.getStr2dArray();
			String[][] dest2dArray = dest.getStr2dArrayDest();
			assertNotNull(dest2dArray);
			assertEquals(src2dArray.length, dest2dArray.length);
			for (int i = 0; i < src2dArray.length; i++)
				for (int j = 0; j < src2dArray[i].length; j++)
					assertEquals(src2dArray[i][j], dest2dArray[i][j]);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testWMCBW11231BeanAsterisk() {
		try {
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCBW11231");
			// ctx.tryGetElementAt("WMCBW11231.innerBeanNull.shortPrimitiveFromField");
			// ctx.setValueAt("WMCBW11231.innerBeanNull.shortPrimitiveFromField",
			// (short)123);
			BeanCollection bcoll = (BeanCollection) ctx.getElementAt("WMCBW11231");
			bcoll.setCreateInstance(true);
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCBW11231BeanAsterisk");
			Object obj = mapper.mapContextToObject(ctx);
			assertNotNull(obj);
			assertEquals(WMCBW11231.class, obj.getClass());
			WMCBW11231 dest = (WMCBW11231) obj;
			WMCBW11231 src = (WMCBW11231) ((BeanCollection) ctx.getElementAt("WMCBW11231")).getBean();
			assertEquals(src.getStringField(), dest.getStringField());
			assertEquals(src.getIntegerField(), dest.getIntegerField());
			assertEquals(src.getDateField(), dest.getDateField());

			Integer[] intSrcArray = src.getIntegerArray();
			Integer[] intDestArray = dest.getIntegerArray();
			assertNotNull(intDestArray);
			assertEquals(intSrcArray.length, intDestArray.length);
			for (int i = 0; i < intSrcArray.length; i++) {
				assertEquals(intSrcArray[i], intDestArray[i]);
			}

			String[] strSrcArray = src.getStringArray();
			String[] strDestArray = dest.getStringArray();
			assertNotNull(strDestArray);
			assertEquals(strSrcArray.length, strDestArray.length);
			for (int i = 0; i < strSrcArray.length; i++) {
				assertEquals(strSrcArray[i], strDestArray[i]);
			}

			assertEquals(0, dest.getDateArray().length);
			// assertNull(dest.getInnerDestBeanNull());

			assertEquals(src.getInnerBean().getCharacterFromField(), dest.getInnerBean().getCharacterFromField());

			BWFromBeanSimple[] srcBeanInner = src.getInnerBeanArray();
			BWFromBeanSimple[] destBeanInner = dest.getInnerBeanArray();
			assertNotNull(destBeanInner);
			assertEquals(srcBeanInner.length, destBeanInner.length);
			for (int i = 0; i < srcBeanInner.length; i++) {
				assertEquals(srcBeanInner[i].getCharacterFromField(), destBeanInner[i].getCharacterFromField());
			}

			String[][] src2dArray = src.getStr2dArray();
			String[][] dest2dArray = dest.getStr2dArray();
			assertNotNull(dest2dArray);
			assertEquals(src2dArray.length, dest2dArray.length);
			// TODO 2d array is not supported by web service
			// comment by HuangYanJun
			// for (int i = 0; i < src2dArray.length; i++)
			// for (int j = 0; j < src2dArray[i].length; j++)
			// assertEquals(src2dArray[i][j], dest2dArray[i][j]);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	// revert -> testWMCWB12323Asterisk
	public void testWMCWB12323RevertAsterisk() {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			TypeManager.treatClassAsSimpleType(UUID.class);
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCWB12323");
			// set values for direct kcoll
			ctx.setValueAt("WMCWB12323.uuid", "1b6c0f31-eb5e-4118-973f-fd451750d1de");
			ctx.setValueAt("WMCWB12323.theName", "Lvst");
			ctx.setValueAt("WMCWB12323.theAge", "26");
			ctx.setValueAt("WMCWB12323.theBirth", sdf.parse("20101122"));
			for (int i = 0; i < 3; i++) {
				ctx.setValueAt("WMCWB12323.theStrArray." + i, "Lvst00" + i);
				ctx.setValueAt("WMCWB12323.theIntArray." + i, i * 1024);
				ctx.setValueAt("WMCWB12323.theDateArray." + i, sdf.parse("2010121" + i));
			}

			// inner kcoll set values
			ctx.setValueAt("WMCWB12323.inner.inCome", 1024.34d);
			ctx.setValueAt("WMCWB12323.inner.inHist", 99999L);
			ctx.setValueAt("WMCWB12323.inner.startCal", Calendar.getInstance());

			// inner inner kcoll set values
			ctx.setValueAt("WMCWB12323.inner.innerInner.theInnerInnerName", "IVAN");
			ctx.setValueAt("WMCWB12323.inner.innerInner.theInnerInnerBool", true);
			ctx.setValueAt("WMCWB12323.inner.innerInner.theInnerInnerBd", BigDecimal.TEN);
			for (int i = 0; i < 1; i++) {
				// inner kcoll set values
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".inCome", 1024.34d);
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".inHist", 99999L);
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".startCal", Calendar.getInstance());

				// inner inner kcoll set values
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".innerInner.theInnerInnerName", "IVAN");
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".innerInner.theInnerInnerBool", true);
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".innerInner.theInnerInnerBd", BigDecimal.ZERO);
			}

			IndexedCollection theInnerStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerStrArray");
			for (int i = 0; i < 4; i++) {
				DataField df = (DataField) theInnerStrArray.createElement(true);
				df.setValue("i0" + i * 1024);
				theInnerStrArray.addElement(df);
			}

			IndexedCollection theInnerInnerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerInnerArray");
			for (int i = 0; i < 3; i++) {
				KeyedCollection kcoll = (KeyedCollection) theInnerInnerArray.createElement(false);
				kcoll.setValueAt("theInnerInnerName", "Ivan" + i * 100);
				kcoll.setValueAt("theInnerInnerBool", i % 2 == 0);
				kcoll.setValueAt("theInnerInnerBd", new BigDecimal(i * 100));
				theInnerInnerArray.addElement(kcoll);
			}

			IndexedCollection innerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.innerArray");
			innerArray.removeAll();
			// TODO if icoll.size() > array's length, how to deal with?
			for (int count = 0; count < 5; count++) {
				KeyedCollection inner = (KeyedCollection) innerArray.createElement(true);
				inner.setValueAt("inCome", 1024.34d);
				inner.setValueAt("inHist", 99999L);
				inner.setValueAt("startCal", Calendar.getInstance());

				// inner inner kcoll set values
				inner.setValueAt("innerInner.theInnerInnerName", "IVAN");
				inner.setValueAt("innerInner.theInnerInnerBool", true);
				inner.setValueAt("innerInner.theInnerInnerBd", BigDecimal.ZERO);

				IndexedCollection theInnerStrArrayInner = (IndexedCollection) inner.getElementAt("theInnerStrArray");
				for (int i = 0; i < 4; i++) {
					DataField df = (DataField) theInnerStrArrayInner.createElement(true);
					df.setValue("i0" + i * 1024);
					theInnerStrArrayInner.addElement(df);
				}
				IndexedCollection theInnerInnerArrayInner = (IndexedCollection) inner.getElementAt("theInnerInnerArray");
				for (int i = 0; i < 3; i++) {
					KeyedCollection kcoll = (KeyedCollection) theInnerInnerArrayInner.createElement(false);
					kcoll.setValueAt("theInnerInnerName", "Ivan" + i * 100);
					kcoll.setValueAt("theInnerInnerBool", i % 2 == 0);
					kcoll.setValueAt("theInnerInnerBd", new BigDecimal(i * 100));
					theInnerInnerArrayInner.addElement(kcoll);
				}
				innerArray.addElement(inner);
			}

			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB12323RevertAsterisk");
			Object o = mapper.mapContextToObject(ctx);
			WMCWB12323 obj = (WMCWB12323) o;
			assertEquals(ctx.getValueAt("WMCWB12323.uuid"), obj.getUuid());
			assertEquals(ctx.getValueAt("WMCWB12323.theName"), obj.getTheName());
			assertEquals(ctx.getValueAt("WMCWB12323.theAge"), String.valueOf(obj.getTheAge()));
			assertEquals(sdf.parse("20101122"), obj.getTheBirth());

			IndexedCollection theStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theStrArray");
			// TODO append value "ignore" may lead this mismatch
			assertEquals(theStrArray.size(), obj.getTheStrArray().length);
			assertEquals(theStrArray.getValueAt("0"), obj.getTheStrArray()[0]);
			assertEquals(theStrArray.getValueAt("1"), obj.getTheStrArray()[1]);
			assertEquals(theStrArray.getValueAt("2"), obj.getTheStrArray()[2]);

			IndexedCollection theIntArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theIntArray");
			assertEquals(theIntArray.size(), obj.getTheIntArray().length);
			assertEquals(theIntArray.getValueAt("0"), obj.getTheIntArray()[0]);
			assertEquals(theIntArray.getValueAt("1"), obj.getTheIntArray()[1]);
			assertEquals(theIntArray.getValueAt("2"), obj.getTheIntArray()[2]);

			IndexedCollection theDateArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theDateArray");
			assertEquals(theDateArray.size(), obj.getTheDateArray().length);
			for (int i = 0; i < theDateArray.size(); i++) {
				assertEquals(theDateArray.getValueAt(String.valueOf(i)), obj.getTheDateArray()[i]);
			}
			assertEquals(ctx.getValueAt("WMCWB12323.inner.inCome"), new Double(obj.getInner().getInCome()));
			assertEquals(ctx.getValueAt("WMCWB12323.inner.inHist"), new Long(obj.getInner().getInHist()));
			assertEquals(ctx.getValueAt("WMCWB12323.inner.startCal"), obj.getInner().getStartCal());

			assertEquals(ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerName"), obj.getInner().getInnerInner()
					.getTheInnerInnerName());
			assertEquals(true, ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerBool"));
			assertEquals(ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerBd"), obj.getInner().getInnerInner()
					.getTheInnerInnerBd());

			theInnerStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerStrArray");
			assertEquals(theInnerStrArray.size(), obj.getInner().getTheInnerStrArray().length);
			for (int i = 0; i < theInnerStrArray.size(); i++) {
				assertEquals(theInnerStrArray.getValueAt(String.valueOf(i)), obj.getInner().getTheInnerStrArray()[i]);
			}

			theInnerInnerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerInnerArray");
			assertEquals(theInnerInnerArray.size(), obj.getInner().getTheInnerInnerArray().length);
			for (int i = 0; i < theInnerInnerArray.size(); i++) {
				assertEquals(theInnerInnerArray.getValueAt(i + ".theInnerInnerName"),
						obj.getInner().getTheInnerInnerArray()[i].getTheInnerInnerName());
				assertEquals(theInnerInnerArray.getValueAt(i + ".theInnerInnerBool"),
						obj.getInner().getTheInnerInnerArray()[i].isTheInnerInnerBool());
				assertEquals(theInnerInnerArray.getValueAt(i + ".theInnerInnerBd"),
						obj.getInner().getTheInnerInnerArray()[i].getTheInnerInnerBd());
			}

			innerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.innerArray");
			assertEquals(innerArray.size(), obj.getInnerArray().length);
			Inner4Array[] theInnerArray = obj.getInnerArray();
			for (int count = 0; count < innerArray.size(); count++) {
				KeyedCollection inner = (KeyedCollection) innerArray.getElementAt(count);
				Inner4Array theInner = theInnerArray[count];

				assertEquals(inner.getValueAt("inCome"), theInner.getInCome());
				assertEquals(inner.getValueAt("inHist"), theInner.getInHist());
				assertEquals(inner.getValueAt("startCal"), theInner.getStartCal());

				assertEquals(inner.getValueAt("innerInner.theInnerInnerName"), theInner.getInnerInner().getTheInnerInnerName());
				assertEquals(inner.getValueAt("innerInner.theInnerInnerBool"), theInner.getInnerInner().isTheInnerInnerBool());
				assertEquals(inner.getValueAt("innerInner.theInnerInnerBd"), theInner.getInnerInner().getTheInnerInnerBd());

				IndexedCollection theInnerStrArrayInner = (IndexedCollection) inner.getElementAt("theInnerStrArray");
				for (int i = 0; i < 4; i++) {
					assertEquals(theInnerStrArrayInner.getValueAt(String.valueOf(i)), theInner.getTheInnerStrArray()[i]);
				}
				IndexedCollection theInnerInnerArrayInner = (IndexedCollection) inner.getElementAt("theInnerInnerArray");
				for (int i = 0; i < 3; i++) {
					assertEquals(theInnerInnerArrayInner.getValueAt(i + ".theInnerInnerName"),
							theInner.getTheInnerInnerArray()[i].getTheInnerInnerName());
					assertEquals(theInnerInnerArrayInner.getValueAt(i + ".theInnerInnerBool"),
							theInner.getTheInnerInnerArray()[i].isTheInnerInnerBool());
					assertEquals(theInnerInnerArrayInner.getValueAt(i + ".theInnerInnerBd"),
							theInner.getTheInnerInnerArray()[i].getTheInnerInnerBd());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	public void testWMCWB12323ListRevertAsterisk() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			TypeManager.treatClassAsSimpleType(UUID.class);
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCWB12323");
			// set values for direct kcoll
			ctx.setValueAt("WMCWB12323.uuid", "1b6c0f31-eb5e-4118-973f-fd451750d1de");
			ctx.setValueAt("WMCWB12323.theName", "Lvst");
			ctx.setValueAt("WMCWB12323.theAge", "26");
			ctx.setValueAt("WMCWB12323.theBirth", sdf.parse("20101122"));
			for (int i = 0; i < 3; i++) {
				ctx.setValueAt("WMCWB12323.theStrArray." + i, "Lvst00" + i);
				ctx.setValueAt("WMCWB12323.theIntArray." + i, i * 1024);
				ctx.setValueAt("WMCWB12323.theDateArray." + i, sdf.parse("2010121" + i));
			}

			// inner kcoll set values
			ctx.setValueAt("WMCWB12323.inner.inCome", 1024.34d);
			ctx.setValueAt("WMCWB12323.inner.inHist", 99999L);
			ctx.setValueAt("WMCWB12323.inner.startCal", Calendar.getInstance());

			// inner inner kcoll set values
			ctx.setValueAt("WMCWB12323.inner.innerInner.theInnerInnerName", "IVAN");
			ctx.setValueAt("WMCWB12323.inner.innerInner.theInnerInnerBool", true);
			ctx.setValueAt("WMCWB12323.inner.innerInner.theInnerInnerBd", BigDecimal.TEN);
			for (int i = 0; i < 1; i++) {
				// inner kcoll set values
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".inCome", 1024.34d);
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".inHist", 99999L);
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".startCal", Calendar.getInstance());

				// inner inner kcoll set values
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".innerInner.theInnerInnerName", "IVAN");
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".innerInner.theInnerInnerBool", true);
				ctx.setValueAt("WMCWB12323.innerArray." + i + ".innerInner.theInnerInnerBd", BigDecimal.ZERO);
			}

			IndexedCollection theInnerStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerStrArray");
			for (int i = 0; i < 4; i++) {
				DataField df = (DataField) theInnerStrArray.createElement(true);
				df.setValue("i0" + i * 1024);
				theInnerStrArray.addElement(df);
			}

			IndexedCollection theInnerInnerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerInnerArray");
			for (int i = 0; i < 3; i++) {
				KeyedCollection kcoll = (KeyedCollection) theInnerInnerArray.createElement(false);
				kcoll.setValueAt("theInnerInnerName", "Ivan" + i * 100);
				kcoll.setValueAt("theInnerInnerBool", i % 2 == 0);
				kcoll.setValueAt("theInnerInnerBd", new BigDecimal(i * 100));
				theInnerInnerArray.addElement(kcoll);
			}

			IndexedCollection innerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.innerArray");
			innerArray.removeAll();
			for (int count = 0; count < 5; count++) {
				KeyedCollection inner = (KeyedCollection) innerArray.createElement(true);
				inner.setValueAt("inCome", 1024.34d);
				inner.setValueAt("inHist", 99999L);
				inner.setValueAt("startCal", Calendar.getInstance());

				// inner inner kcoll set values
				inner.setValueAt("innerInner.theInnerInnerName", "IVAN");
				inner.setValueAt("innerInner.theInnerInnerBool", true);
				inner.setValueAt("innerInner.theInnerInnerBd", BigDecimal.ZERO);

				IndexedCollection theInnerStrArrayInner = (IndexedCollection) inner.getElementAt("theInnerStrArray");
				for (int i = 0; i < 4; i++) {
					DataField df = (DataField) theInnerStrArrayInner.createElement(true);
					df.setValue("i0" + i * 1024);
					theInnerStrArrayInner.addElement(df);
				}
				IndexedCollection theInnerInnerArrayInner = (IndexedCollection) inner.getElementAt("theInnerInnerArray");
				for (int i = 0; i < 3; i++) {
					KeyedCollection kcoll = (KeyedCollection) theInnerInnerArrayInner.createElement(false);
					kcoll.setValueAt("theInnerInnerName", "Ivan" + i * 100);
					kcoll.setValueAt("theInnerInnerBool", i % 2 == 0);
					kcoll.setValueAt("theInnerInnerBd", new BigDecimal(i * 100));
					theInnerInnerArrayInner.addElement(kcoll);
				}
				innerArray.addElement(inner);
			}

			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB12323ListRevertAsterisk");
			Object o = mapper.mapContextToObject(ctx);
			WMCWB12323List obj = (WMCWB12323List) o;
			assertEquals(ctx.getValueAt("WMCWB12323.uuid"), obj.getUuid());
			assertEquals(ctx.getValueAt("WMCWB12323.theName"), obj.getTheName());
			assertEquals(ctx.getValueAt("WMCWB12323.theAge"), String.valueOf(obj.getTheAge()));
			assertEquals(sdf.parse("20101122"), obj.getTheBirth());

			IndexedCollection theStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theStrArray");
			// TODO append value "ignore" may lead this mismatch
			assertEquals(theStrArray.size(), obj.getTheStrArray().size());
			assertEquals(theStrArray.getValueAt("0"), obj.getTheStrArray().get(0));
			assertEquals(theStrArray.getValueAt("1"), obj.getTheStrArray().get(1));
			assertEquals(theStrArray.getValueAt("2"), obj.getTheStrArray().get(2));

			IndexedCollection theIntArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theIntArray");
			assertEquals(theIntArray.size(), obj.getTheIntArray().size());
			assertEquals(theIntArray.getValueAt("0"), obj.getTheIntArray().get(0));
			assertEquals(theIntArray.getValueAt("1"), obj.getTheIntArray().get(1));
			assertEquals(theIntArray.getValueAt("2"), obj.getTheIntArray().get(2));

			IndexedCollection theDateArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theDateArray");
			assertEquals(theDateArray.size(), obj.getTheDateArray().size());
			for (int i = 0; i < theDateArray.size(); i++) {
				assertEquals(theDateArray.getValueAt(String.valueOf(i)), obj.getTheDateArray().get(i));
			}
			assertEquals(ctx.getValueAt("WMCWB12323.inner.inCome"), new Double(obj.getInner().getInCome()));
			assertEquals(ctx.getValueAt("WMCWB12323.inner.inHist"), new Long(obj.getInner().getInHist()));
			assertEquals(ctx.getValueAt("WMCWB12323.inner.startCal"), obj.getInner().getStartCal());

			assertEquals(ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerName"), obj.getInner().getInnerInner()
					.getTheInnerInnerName());
			assertEquals(true, ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerBool"));
			assertEquals(ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerBd"), obj.getInner().getInnerInner()
					.getTheInnerInnerBd());

			theInnerStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerStrArray");
			assertEquals(theInnerStrArray.size(), obj.getInner().getTheInnerStrArray().size());
			for (int i = 0; i < theInnerStrArray.size(); i++) {
				assertEquals(theInnerStrArray.getValueAt(String.valueOf(i)), obj.getInner().getTheInnerStrArray().get(i));
			}

			theInnerInnerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerInnerArray");
			assertEquals(theInnerInnerArray.size(), obj.getInner().getTheInnerInnerArray().size());
			for (int i = 0; i < theInnerInnerArray.size(); i++) {
				assertEquals(theInnerInnerArray.getValueAt(i + ".theInnerInnerName"), obj.getInner().getTheInnerInnerArray()
						.get(i).getTheInnerInnerName());
				assertEquals(theInnerInnerArray.getValueAt(i + ".theInnerInnerBool"), obj.getInner().getTheInnerInnerArray()
						.get(i).isTheInnerInnerBool());
				assertEquals(theInnerInnerArray.getValueAt(i + ".theInnerInnerBd"),
						obj.getInner().getTheInnerInnerArray().get(i).getTheInnerInnerBd());
			}

			innerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.innerArray");
			assertEquals(innerArray.size(), obj.getInnerArray().size());
			List<com.ibm.btt.wsc.mapper.beans.Inner> theInnerArray = obj.getInnerArray();
			for (int count = 0; count < innerArray.size(); count++) {
				KeyedCollection inner = (KeyedCollection) innerArray.getElementAt(count);
				com.ibm.btt.wsc.mapper.beans.Inner theInner = theInnerArray.get(count);

				assertEquals(inner.getValueAt("inCome"), theInner.getInCome());
				assertEquals(inner.getValueAt("inHist"), theInner.getInHist());
				assertEquals(inner.getValueAt("startCal"), theInner.getStartCal());

				assertEquals(inner.getValueAt("innerInner.theInnerInnerName"), theInner.getInnerInner().getTheInnerInnerName());
				assertEquals(inner.getValueAt("innerInner.theInnerInnerBool"), theInner.getInnerInner().isTheInnerInnerBool());
				assertEquals(inner.getValueAt("innerInner.theInnerInnerBd"), theInner.getInnerInner().getTheInnerInnerBd());

				IndexedCollection theInnerStrArrayInner = (IndexedCollection) inner.getElementAt("theInnerStrArray");
				for (int i = 0; i < 4; i++) {
					assertEquals(theInnerStrArrayInner.getValueAt(String.valueOf(i)), theInner.getTheInnerStrArray().get(i));
				}
				IndexedCollection theInnerInnerArrayInner = (IndexedCollection) inner.getElementAt("theInnerInnerArray");
				for (int i = 0; i < 3; i++) {
					assertEquals(theInnerInnerArrayInner.getValueAt(i + ".theInnerInnerName"), theInner.getTheInnerInnerArray()
							.get(i).getTheInnerInnerName());
					assertEquals(theInnerInnerArrayInner.getValueAt(i + ".theInnerInnerBool"), theInner.getTheInnerInnerArray()
							.get(i).isTheInnerInnerBool());
					assertEquals(theInnerInnerArrayInner.getValueAt(i + ".theInnerInnerBd"), theInner.getTheInnerInnerArray()
							.get(i).getTheInnerInnerBd());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

}
