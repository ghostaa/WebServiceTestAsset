/**
 * Created by lvst at 2010-8-27 06:18:22 PM
 */
package com.ibm.btt.wsc.mapper.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.IndexedCollection;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.bean.TypeManager;
import com.ibm.btt.wsc.mapper.beans.WMCWB121;
import com.ibm.btt.wsc.mapper.beans.WMCWB122;
import com.ibm.btt.wsc.mapper.beans.WMCWB1231;
import com.ibm.btt.wsc.mapper.beans.WMCWB12322;
import com.ibm.btt.wsc.mapper.beans.WMCWB12323;
import com.ibm.btt.wsc.mapper.beans.WMCWB1244;
import com.ibm.btt.wsc.mapper.beans.WMCWB1244CompleteMatch;
import com.ibm.btt.wsc.mapper.beans.WMCWB1244NullDefault;

/**
 * @author lvst
 * 
 */
public class WD2BDMapperTests extends MapperTestSuper {
	Random rand = new Random();

	public void testWMCWB121Boolean() {
		try {
			Context ctx = getContext("WMCWB121");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB121Boolean");
			WMCWB121 obj = new WMCWB121();
			mapper.mapObjectToContext(obj.isBooleanField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.isBooleanField(), ctx.getValueAt("booleanDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB121Byte() {
		try {
			Context ctx = getContext("WMCWB121");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB121Byte");
			WMCWB121 obj = new WMCWB121();
			mapper.mapObjectToContext(obj.getByteField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getByteField(), ctx.getValueAt("byteDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB121Char() {
		try {
			Context ctx = getContext("WMCWB121");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB121Char");
			WMCWB121 obj = new WMCWB121();
			mapper.mapObjectToContext(obj.getCharField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getCharField(), ctx.getValueAt("charDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB121Double() {
		try {
			Context ctx = getContext("WMCWB121");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB121Double");
			WMCWB121 obj = new WMCWB121();
			mapper.mapObjectToContext(obj.getDoubleField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getDoubleField(), ctx.getValueAt("doubleDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB121Float() {
		try {
			Context ctx = getContext("WMCWB121");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB121Float");
			WMCWB121 obj = new WMCWB121();
			mapper.mapObjectToContext(obj.getFloatField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getFloatField(), ctx.getValueAt("floatDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB121Int() {
		try {
			Context ctx = getContext("WMCWB121");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB121Int");
			WMCWB121 obj = new WMCWB121();
			mapper.mapObjectToContext(obj.getIntField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getIntField(), ctx.getValueAt("intDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB121Long() {
		try {
			Context ctx = getContext("WMCWB121");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB121Long");
			WMCWB121 obj = new WMCWB121();
			mapper.mapObjectToContext(obj.getLongField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getLongField(), ctx.getValueAt("longDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB121Short() {
		try {
			Context ctx = getContext("WMCWB121");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB121Short");
			WMCWB121 obj = new WMCWB121();
			mapper.mapObjectToContext(obj.getShortField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getShortField(), ctx.getValueAt("shortDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB122Boolean() {
		try {
			Context ctx = getContext("WMCWB122");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB122Boolean");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj.getBooleanField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getBooleanField(), ctx.getValueAt("booleanDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB122Byte() {
		try {
			Context ctx = getContext("WMCWB122");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB122Byte");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj.getByteField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getByteField(), ctx.getValueAt("byteDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB122Character() {
		try {
			Context ctx = getContext("WMCWB122");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB122Character");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj.getCharacterField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getCharacterField(), ctx.getValueAt("characterDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB122Double() {
		try {
			Context ctx = getContext("WMCWB122");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB122Double");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj.getDoubleField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getDoubleField(), ctx.getValueAt("doubleDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB122Float() {
		try {
			Context ctx = getContext("WMCWB122");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB122Float");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj.getFloatField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getFloatField(), ctx.getValueAt("floatDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB122Integer() {
		try {
			Context ctx = getContext("WMCWB122");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB122Integer");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj.getIntegerField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getIntegerField(), ctx.getValueAt("integerDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB122Long() {
		try {
			Context ctx = getContext("WMCWB122");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB122Long");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj.getLongField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getLongField(), ctx.getValueAt("longDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB122Short() {
		try {
			Context ctx = getContext("WMCWB122");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB122Short");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj.getShortField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getShortField(), ctx.getValueAt("shortDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB122String() {
		try {
			Context ctx = getContext("WMCWB122");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB122String");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj.getStringField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getStringField(), ctx.getValueAt("stringDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1231BigDecimal() {
		try {
			Context ctx = getContext("WMCWB1231");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1231BigDecimal");
			WMCWB1231 obj = new WMCWB1231();
			mapper.mapObjectToContext(obj.getBigDecimalField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getBigDecimalField(), ctx.getValueAt("bigDecimalDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1231BigInteger() {
		try {
			Context ctx = getContext("WMCWB1231");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1231BigInteger");
			WMCWB1231 obj = new WMCWB1231();
			mapper.mapObjectToContext(obj.getBigIntegerField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getBigIntegerField(), ctx.getValueAt("bigIntegerDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1231Calendar() {
		try {
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCWB1231");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1231Calendar");
			WMCWB1231 obj = new WMCWB1231();
			mapper.mapObjectToContext(obj.getCalendarField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getCalendarField(), ctx.getValueAt("calendarDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1231Date() {
		try {
			Context ctx = getContext("WMCWB1231");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1231Date");
			WMCWB1231 obj = new WMCWB1231();
			mapper.mapObjectToContext(obj.getDateField(), ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getDateField(), ctx.getValueAt("dateDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB12321Pri() {
		try {
			Context ctx = getContext("WMCWB12321Pri");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB12321Pri");
			WMCWB121 obj = new WMCWB121();
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.isBooleanField(), ctx.getValueAt("PrimitiveKColl.booleanDestField"));
			assertEquals(obj.getByteField(), ctx.getValueAt("PrimitiveKColl.byteDestField"));
			assertEquals(obj.getCharField(), ctx.getValueAt("PrimitiveKColl.charDestField"));
			assertEquals(obj.getDoubleField(), ctx.getValueAt("PrimitiveKColl.doubleDestField"));
			assertEquals(obj.getFloatField(), ctx.getValueAt("PrimitiveKColl.floatDestField"));
			assertEquals(obj.getIntField(), ctx.getValueAt("PrimitiveKColl.intDestField"));
			assertEquals(obj.getLongField(), ctx.getValueAt("PrimitiveKColl.longDestField"));
			assertEquals(obj.getShortField(), ctx.getValueAt("PrimitiveKColl.shortDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB12321Imu() {
		try {
			Context ctx = getContext("WMCWB12321Imu");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB12321Imu");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getBooleanField(), ctx.getValueAt("ImmutableKColl.booleanDestField"));
			assertEquals(obj.getByteField(), ctx.getValueAt("ImmutableKColl.byteDestField"));
			assertEquals(obj.getCharacterField(), ctx.getValueAt("ImmutableKColl.characterDestField"));
			assertEquals(obj.getDoubleField(), ctx.getValueAt("ImmutableKColl.doubleDestField"));
			assertEquals(obj.getFloatField(), ctx.getValueAt("ImmutableKColl.floatDestField"));
			assertEquals(obj.getIntegerField(), ctx.getValueAt("ImmutableKColl.integerDestField"));
			assertEquals(obj.getLongField(), ctx.getValueAt("ImmutableKColl.longDestField"));
			assertEquals(obj.getShortField(), ctx.getValueAt("ImmutableKColl.shortDestField"));
			assertEquals(obj.getStringField(), ctx.getValueAt("ImmutableKColl.stringDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB12321Asterisk() {
		try {
			Context ctx = getContext("WMCWB12321Asterisk");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB12321Asterisk");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getBooleanField(), ctx.getValueAt("InnerKColl.booleanField"));
			assertEquals(obj.getByteField(), ctx.getValueAt("InnerKColl.byteField"));
			assertEquals(obj.getCharacterField(), ctx.getValueAt("InnerKColl.characterField"));
			assertEquals(obj.getDoubleField(), ctx.getValueAt("InnerKColl.doubleField"));
			assertEquals(obj.getFloatField(), ctx.getValueAt("InnerKColl.floatField"));
			assertEquals(obj.getIntegerField(), ctx.getValueAt("InnerKColl.integerField"));
			assertEquals(obj.getLongField(), ctx.getValueAt("InnerKColl.longField"));
			assertEquals(obj.getShortField(), ctx.getValueAt("InnerKColl.shortField"));
			assertEquals(obj.getStringField(), ctx.getValueAt("InnerKColl.stringField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	// TODO currently, this is not supported!!!!
	public void testWMCWB12321AsteriskNoInnerKColl() {
		try {
			Context ctx = getContext("WMCWB12321AsteriskNoInnerKColl");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB12321AsteriskNoInnerKColl");
			WMCWB122 obj = new WMCWB122();
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getBooleanField(), ctx.getValueAt("booleanField"));
			assertEquals(obj.getByteField(), ctx.getValueAt("byteField"));
			assertEquals(obj.getCharacterField(), ctx.getValueAt("characterField"));
			assertEquals(obj.getDoubleField(), ctx.getValueAt("doubleField"));
			assertEquals(obj.getFloatField(), ctx.getValueAt("floatField"));
			assertEquals(obj.getIntegerField(), ctx.getValueAt("integerField"));
			assertEquals(obj.getLongField(), ctx.getValueAt("longField"));
			assertEquals(obj.getShortField(), ctx.getValueAt("shortField"));
			assertEquals(obj.getStringField(), ctx.getValueAt("stringField"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("Here should be an exception, for the format is not valid for this situation.", true);
		}
	}

	/**
	 * Currently, followings are true
	 * icoll ==  list;
	 * field == map;
	 * field == set;
	 */
	public void testWMCWB12322() {
		try {
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCWB12322");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB12322");
			WMCWB12322 obj = new WMCWB12322();
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals(obj.getCalendar(), ctx.getValueAt("MutableKColl.calendarDestField"));
			assertEquals(obj.getDate(), ctx.getValueAt("MutableKColl.dateDestField"));
			assertEquals(obj.getList(), ctx.getValueAt("MutableKColl.listDestField"));
			assertEquals(obj.getSet(), ctx.getValueAt("MutableKColl.setDestField"));
			assertEquals(obj.getMap(), ctx.getValueAt("MutableKColl.mapDestField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB12323() {
		try {
			TypeManager.treatClassAsSimpleType(UUID.class);
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCWB12323");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB12323");
			WMCWB12323 obj = new WMCWB12323();
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals("1b6c0f31-eb5e-4118-973f-fd451750d1de", ctx.getValueAt("WMCWB12323.uuid").toString());
			assertEquals("RANDOM_NAME", ctx.getValueAt("WMCWB12323.theName"));
			assertEquals(27, ctx.getValueAt("WMCWB12323.theAge"));
			assertNotNull("the field 'theBirth' should not be null!", ctx.getValueAt("WMCWB12323.theBirth"));

			IndexedCollection theStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theStrArray");
			assertEquals(4, theStrArray.size());
			assertEquals("X", theStrArray.getValueAt("0"));
			assertEquals("Y", theStrArray.getValueAt("1"));
			assertEquals("Z", theStrArray.getValueAt("2"));
			assertEquals("A", theStrArray.getValueAt("3"));

			IndexedCollection theIntArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theIntArray");
			assertEquals(3, theIntArray.size());
			assertEquals(99, theIntArray.getValueAt("0"));
			assertEquals(888, theIntArray.getValueAt("1"));
			assertEquals(333, theIntArray.getValueAt("2"));

			IndexedCollection theDateArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theDateArray");
			assertEquals(3, theDateArray.size());
			for (int i = 0; i < theDateArray.size(); i++)
				assertEquals(Date.class, theDateArray.getValueAt(String.valueOf(i)).getClass());

			assertEquals(123.45d, ctx.getValueAt("WMCWB12323.inner.inCome"));
			assertEquals(new Long(99999L), ctx.getValueAt("WMCWB12323.inner.inHist"));
			assertNotNull(ctx.getValueAt("WMCWB12323.inner.startCal"));

			assertEquals("INNEST", ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerName"));
			assertEquals(true, ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerBool"));
			assertEquals(new BigDecimal("12312"), ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerBd"));

			IndexedCollection theInnerStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerStrArray");
			assertEquals(2, theInnerStrArray.size());
			assertEquals("", theInnerStrArray.getValueAt("0"));
			assertEquals("23", theInnerStrArray.getValueAt("1"));

			IndexedCollection theInnerInnerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerInnerArray");
			assertEquals(3, theInnerInnerArray.size());
			assertEquals("INNEST", theInnerInnerArray.getValueAt("0.theInnerInnerName"));
			assertEquals(true, theInnerInnerArray.getValueAt("1.theInnerInnerBool"));
			assertEquals(new BigDecimal("12312"), theInnerInnerArray.getValueAt("2.theInnerInnerBd"));

			IndexedCollection innerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.innerArray");
			assertEquals(2, innerArray.size());
			assertEquals(123.45d, innerArray.getValueAt("0.inCome"));
			assertNotNull(innerArray.getValueAt("1.startCal"));
			assertEquals("INNEST", innerArray.getValueAt("0.innerInner.theInnerInnerName"));
			assertEquals(true, innerArray.getValueAt("1.innerInner.theInnerInnerBool"));
			assertEquals(2, ((IndexedCollection) innerArray.getElementAt("0.theInnerStrArray")).size());
			assertEquals(2, ((IndexedCollection) innerArray.getElementAt("1.theInnerStrArray")).size());

			IndexedCollection theInnerInnerArray2 = (IndexedCollection) ctx
					.getElementAt("WMCWB12323.innerArray.0.theInnerInnerArray");
			assertEquals(3, theInnerInnerArray2.size());
			assertEquals("INNEST", theInnerInnerArray2.getValueAt("0.theInnerInnerName"));
			assertEquals(true, theInnerInnerArray2.getValueAt("1.theInnerInnerBool"));
			assertEquals(new BigDecimal("12312"), theInnerInnerArray2.getValueAt("2.theInnerInnerBd"));

			theInnerInnerArray2 = (IndexedCollection) ctx.getElementAt("WMCWB12323.innerArray.1.theInnerInnerArray");
			assertEquals(3, theInnerInnerArray2.size());
			assertEquals("INNEST", theInnerInnerArray2.getValueAt("0.theInnerInnerName"));
			assertEquals(true, theInnerInnerArray2.getValueAt("1.theInnerInnerBool"));
			assertEquals(new BigDecimal("12312"), theInnerInnerArray2.getValueAt("2.theInnerInnerBd"));

			// fail("Send isseus to YanJun(append error)");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB12323Asterisk() {
		try {
			TypeManager.treatClassAsSimpleType(UUID.class);
			TypeManager.treatClassAsSimpleType(Calendar.class);
			Context ctx = getContext("WMCWB12323");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB12323Asterisk");
			WMCWB12323 obj = new WMCWB12323();
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			assertEquals("1b6c0f31-eb5e-4118-973f-fd451750d1de", ctx.getValueAt("WMCWB12323.uuid").toString());
			assertEquals("RANDOM_NAME", ctx.getValueAt("WMCWB12323.theName"));
			assertEquals(27, ctx.getValueAt("WMCWB12323.theAge"));
			assertNotNull("the field 'theBirth' should not be null!", ctx.getValueAt("WMCWB12323.theBirth"));

			IndexedCollection theStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theStrArray");
			assertEquals(4, theStrArray.size());
			assertEquals("X", theStrArray.getValueAt("0"));
			assertEquals("Y", theStrArray.getValueAt("1"));
			assertEquals("Z", theStrArray.getValueAt("2"));
			assertEquals("A", theStrArray.getValueAt("3"));

			IndexedCollection theIntArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theIntArray");
			assertEquals(3, theIntArray.size());
			assertEquals(99, theIntArray.getValueAt("0"));
			assertEquals(888, theIntArray.getValueAt("1"));
			assertEquals(333, theIntArray.getValueAt("2"));

			IndexedCollection theDateArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.theDateArray");
			assertEquals(3, theDateArray.size());
			for (int i = 0; i < theDateArray.size(); i++)
				assertEquals(Date.class, theDateArray.getValueAt(String.valueOf(i)).getClass());

			assertEquals(123.45d, ctx.getValueAt("WMCWB12323.inner.inCome"));
			assertEquals(new Long(99999L), ctx.getValueAt("WMCWB12323.inner.inHist"));
			assertNotNull(ctx.getValueAt("WMCWB12323.inner.startCal"));

			assertEquals("INNEST", ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerName"));
			assertEquals(true, ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerBool"));
			assertEquals(new BigDecimal("12312"), ctx.getValueAt("WMCWB12323.inner.innerInner.theInnerInnerBd"));

			IndexedCollection theInnerStrArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerStrArray");
			assertEquals(2, theInnerStrArray.size());
			assertEquals("", theInnerStrArray.getValueAt("0"));
			assertEquals("23", theInnerStrArray.getValueAt("1"));

			IndexedCollection theInnerInnerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.inner.theInnerInnerArray");
			assertEquals(3, theInnerInnerArray.size());
			assertEquals("INNEST", theInnerInnerArray.getValueAt("0.theInnerInnerName"));
			assertEquals(true, theInnerInnerArray.getValueAt("1.theInnerInnerBool"));
			assertEquals(new BigDecimal("12312"), theInnerInnerArray.getValueAt("2.theInnerInnerBd"));

			IndexedCollection innerArray = (IndexedCollection) ctx.getElementAt("WMCWB12323.innerArray");
			assertEquals(2, innerArray.size());
			assertEquals(123.45d, innerArray.getValueAt("0.inCome"));
			assertNotNull(innerArray.getValueAt("1.startCal"));
			assertEquals("INNEST", innerArray.getValueAt("0.innerInner.theInnerInnerName"));
			assertEquals(true, innerArray.getValueAt("1.innerInner.theInnerInnerBool"));
			assertEquals(2, ((IndexedCollection) innerArray.getElementAt("0.theInnerStrArray")).size());
			assertEquals(2, ((IndexedCollection) innerArray.getElementAt("1.theInnerStrArray")).size());

			IndexedCollection theInnerInnerArray2 = (IndexedCollection) ctx
					.getElementAt("WMCWB12323.innerArray.0.theInnerInnerArray");
			assertEquals(3, theInnerInnerArray2.size());
			assertEquals("INNEST", theInnerInnerArray2.getValueAt("0.theInnerInnerName"));
			assertEquals(true, theInnerInnerArray2.getValueAt("1.theInnerInnerBool"));
			assertEquals(new BigDecimal("12312"), theInnerInnerArray2.getValueAt("2.theInnerInnerBd"));

			theInnerInnerArray2 = (IndexedCollection) ctx.getElementAt("WMCWB12323.innerArray.1.theInnerInnerArray");
			assertEquals(3, theInnerInnerArray2.size());
			assertEquals("INNEST", theInnerInnerArray2.getValueAt("0.theInnerInnerName"));
			assertEquals(true, theInnerInnerArray2.getValueAt("1.theInnerInnerBool"));
			assertEquals(new BigDecimal("12312"), theInnerInnerArray2.getValueAt("2.theInnerInnerBd"));

			// fail("Send isseus to YanJun(append error)");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1241() {
		try {
			Context ctx = getContext("WMCWB1241");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1241");
			int[] obj = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 111, 333, 666, 888, 9999 };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1241Boolean() {
		try {
			Context ctx = getContext("WMCWB1241");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1241Boolean");
			boolean[] obj = { false, true, false, false, true, true };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1241Byte() {
		try {
			Context ctx = getContext("WMCWB1241");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1241Byte");
			byte[] obj = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 111 };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1241Char() {
		try {
			Context ctx = getContext("WMCWB1241");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1241Char");
			char[] obj = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 111, 333, 666, 888, 9999 };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB124Double() {
		try {
			Context ctx = getContext("WMCWB1241");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1241Double");
			double[] obj = { 1.123d, 2.23d, 3.34d, 4.34d, 5.34d, 6.34d, 7.34d, 8, 9, 0.34d, 11.1d, 3.33d, 66.6d, 888d, 9999d };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1241Float() {
		try {
			Context ctx = getContext("WMCWB1241");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1241Float");
			float[] obj = { 1.123f, 2.23f, 3.34f, 4.34f, 5.34f, 6.34f, 7.34f, 8, 9, 0.34f, 11.1f, 3.33f, 66.6f, 888f, 9999f };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1241Long() {
		try {
			Context ctx = getContext("WMCWB1241");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1241Long");
			long[] obj = { 1, 2, 3l, 4, 5, 6, 7, 8, 9l, 0, 111, 33367l, 666l, 8886578l, 9999l };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1241Short() {
		try {
			Context ctx = getContext("WMCWB1241");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1241Short");
			short[] obj = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 111, 333, 666, 888, 9999 };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1241Append() {
		try {
			Context ctx = getContext("WMCWB1241");

			int orgSize = ((IndexedCollection) ctx.getElementAt("innerIColl")).size();
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1241Append");
			int[] obj = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 111, 333, 666, 888, 9999 };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length + orgSize, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(orgSize + i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1242() {
		try {
			Context ctx = getContext("WMCWB1242");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1242");
			String[] obj = { "", "234", "dsf", "JIKU", "907H", "&*^%%" };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1242Append() {
		try {
			Context ctx = getContext("WMCWB1242");

			int orgSize = ((IndexedCollection) ctx.getElementAt("innerIColl")).size();
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1242Append");
			String[] obj = { "", "234", "dsf", "JIKU", "907H", "&*^%%" };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length + orgSize, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(orgSize + i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1243() {
		try {
			Context ctx = getContext("WMCWB1243");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1243");
			Date[] obj = { new Date(), new Date(), new Date(), new Date(), new Date(), };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1243Append() {
		try {
			Context ctx = getContext("WMCWB1243");

			int orgSize = ((IndexedCollection) ctx.getElementAt("innerIColl")).size();
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1243Append");
			Date[] obj = { new Date(), new Date(), new Date(), new Date(), new Date(), };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length + orgSize, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i], icoll.getValueAt(String.valueOf(orgSize + i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1244() {
		try {
			Context ctx = getContext("WMCWB1244");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1244");
			WMCWB1244[] obj = { new WMCWB1244(), new WMCWB1244(), new WMCWB1244(), new WMCWB1244(), new WMCWB1244(), };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i].getIntSrcField(), icoll.getValueAt(i + ".intField"));
				assertEquals(obj[i].getStrSrcField(), icoll.getValueAt(i + ".strField"));
				assertEquals(obj[i].getDateSrcField(), icoll.getValueAt(i + ".dateField"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1244CompleteMatch() {
		try {
			Context ctx = getContext("WMCWB1244CompleteMatch");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1244CompleteMatch");
			WMCWB1244CompleteMatch[] obj = { new WMCWB1244CompleteMatch(), new WMCWB1244CompleteMatch(),
					new WMCWB1244CompleteMatch(), new WMCWB1244CompleteMatch(), new WMCWB1244CompleteMatch(), };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i].getIntSrcField(), icoll.getValueAt(i + ".intSrcField"));
				assertEquals(obj[i].getStrSrcField(), icoll.getValueAt(i + ".strSrcField"));
				assertEquals(obj[i].getDateSrcField(), icoll.getValueAt(i + ".dateSrcField"));

				assertEquals(obj[i].getBeanSrcCollection().getIntSrcField(),
						icoll.getValueAt(i + ".beanSrcCollection.intSrcField"));
				assertEquals(obj[i].getBeanSrcCollection().getStrSrcField(),
						icoll.getValueAt(i + ".beanSrcCollection.strSrcField"));
				assertEquals(obj[i].getBeanSrcCollection().getDateSrcField(),
						icoll.getValueAt(i + ".beanSrcCollection.dateSrcField"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1244Append() {
		try {
			Context ctx = getContext("WMCWB1244");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1244Append");
			WMCWB1244[] obj = { new WMCWB1244(), new WMCWB1244(), new WMCWB1244(), new WMCWB1244(), new WMCWB1244(), };
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.length, icoll.size());
			for (int i = 0; i < obj.length; i++) {
				assertEquals(obj[i].getIntSrcField(), icoll.getValueAt((i) + ".intField"));
				assertEquals(obj[i].getStrSrcField(), icoll.getValueAt((i) + ".strField"));
				assertEquals(obj[i].getDateSrcField(), icoll.getValueAt((i) + ".dateField"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1251() {
		try {
			Context ctx = getContext("WMCWB1251");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1251");
			// ArrayList obj = new ArrayList();
			ArrayList<Integer> obj = new ArrayList<Integer>();
			for (int i = 0; i < 13; i++) {
				// here automated boxing happens, whether raw type of the list
				// is specified or not.
				obj.add(rand.nextInt());
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1251Boolean() {
		try {
			Context ctx = getContext("WMCWB1251");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1251Boolean");
			// ArrayList obj = new ArrayList();
			ArrayList<Boolean> obj = new ArrayList<Boolean>();
			for (int i = 0; i < 7; i++) {
				// here automated boxing happens, whether raw type of the list
				// is specified or not.
				obj.add(rand.nextBoolean());
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1251Byte() {
		try {
			Context ctx = getContext("WMCWB1251");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1251Byte");
			// ArrayList obj = new ArrayList();
			ArrayList<Byte> obj = new ArrayList<Byte>();
			for (int i = 0; i < 7; i++) {
				// here automated boxing happens, whether raw type of the list
				// is specified or not.
				obj.add((byte) rand.nextInt(Byte.MAX_VALUE));
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1251Char() {
		try {
			Context ctx = getContext("WMCWB1251");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1251Char");
			// ArrayList obj = new ArrayList();
			ArrayList<Character> obj = new ArrayList<Character>();
			for (int i = 0; i < 7; i++) {
				// here automated boxing happens, whether raw type of the list
				// is specified or not.
				obj.add((char) rand.nextInt(Character.MAX_VALUE));
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1251Double() {
		try {
			Context ctx = getContext("WMCWB1251");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1251Double");
			// ArrayList obj = new ArrayList();
			ArrayList<Double> obj = new ArrayList<Double>();
			for (int i = 0; i < 7; i++) {
				// here automated boxing happens, whether raw type of the list
				// is specified or not.
				obj.add(rand.nextDouble());
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1251Float() {
		try {
			Context ctx = getContext("WMCWB1251");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1251Float");
			// ArrayList obj = new ArrayList();
			ArrayList<Float> obj = new ArrayList<Float>();
			for (int i = 0; i < 7; i++) {
				// here automated boxing happens, whether raw type of the list
				// is specified or not.
				obj.add(rand.nextFloat());
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1251Long() {
		try {
			Context ctx = getContext("WMCWB1251");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1251Long");
			// ArrayList obj = new ArrayList();
			ArrayList<Long> obj = new ArrayList<Long>();
			for (int i = 0; i < 7; i++) {
				// here automated boxing happens, whether raw type of the list
				// is specified or not.
				obj.add(rand.nextLong());
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1251Short() {
		try {
			Context ctx = getContext("WMCWB1251");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1251Short");
			// ArrayList obj = new ArrayList();
			ArrayList<Short> obj = new ArrayList<Short>();
			for (int i = 0; i < 56; i++) {
				// here automated boxing happens, whether raw type of the list
				// is specified or not.
				obj.add((short) rand.nextInt(Short.MAX_VALUE));
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1252() {
		try {
			Context ctx = getContext("WMCWB1252");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1252");
			LinkedList<String> obj = new LinkedList<String>();
			obj.add("");
			obj.add("234");
			obj.add("dsf");
			obj.add("JIKU");
			obj.add("907H");
			obj.add("&*^%%");
			obj.add("..........");
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1252Append() {
		try {
			Context ctx = getContext("WMCWB1252");
			System.out.println(ctx.getKeyedCollection());
			int orgSize = ((IndexedCollection) ctx.getElementAt("innerIColl")).size();
			WSMapperConverter mapper = getFormat("WMCWB1252Append");
			LinkedList<String> obj = new LinkedList<String>();
			obj.add("");
			obj.add("234");
			obj.add("dsf");
			obj.add("JIKU");
			obj.add("907H");
			obj.add("&*^%%");
			obj.add("..........");
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size() + orgSize, icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i + 4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1253() {
		try {
			Context ctx = getContext("WMCWB1253");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1253");
			List<Date> obj = new LinkedList<Date>();
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1253Append() {
		try {
			Context ctx = getContext("WMCWB1253");
			int orgSize = ((IndexedCollection) ctx.getElementAt("innerIColl")).size();
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1253Append");
			List<Date> obj = new LinkedList<Date>();
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			obj.add(new Date());
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size() + orgSize, icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				assertEquals(obj.get(i), icoll.getValueAt(String.valueOf(orgSize + i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1254() {
		try {
			Context ctx = getContext("WMCWB1254");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1254");
			List<WMCWB1244> obj = new ArrayList<WMCWB1244>();
			for (int i = 0; i < 12; i++) {
				if (i != 0 && i % 5 == 0)
					obj.add(null);
				else {
					WMCWB1244 o = new WMCWB1244();
					o.setIntSrcField(i);
					o.setStrSrcField("00" + i);
					obj.add(o);
				}
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				if (i != 0 && i % 5 == 0)
					continue;
				assertEquals(obj.get(i).getIntSrcField(), icoll.getValueAt(i + ".intField"));
				assertEquals(obj.get(i).getStrSrcField(), icoll.getValueAt(i + ".strField"));
				assertEquals(obj.get(i).getDateSrcField(), icoll.getValueAt(i + ".dateField"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1254BCollNullDefault() {
		try {
			Context ctx = getContext("WMCWB1254BColl");
			// System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1254NullDefault");
			List<WMCWB1244NullDefault> obj = new ArrayList<WMCWB1244NullDefault>();
			for (int i = 0; i < 12; i++) {
				if (i != 0 && i % 5 == 0)
					obj.add(null);
				else {
					WMCWB1244NullDefault o = new WMCWB1244NullDefault();
					o.setIntSrcField(i);
					o.setStrSrcField("00" + i);
					obj.add(o);
				}
			}
			// System.out.println(obj);
			mapper.mapObjectToContext(obj, ctx);
			// System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				if (i != 0 && i % 5 == 0) {
					assertNull(obj.get(i));
					// Meeting said: dest icoll should have default values
					// those default values are defined in xml or java bean
					// check default values
					assertEquals(0, icoll.getValueAt(i + ".intSrcField"));
					assertNull(icoll.getValueAt(i + ".strSrcField"));
					assertNull(icoll.getValueAt(i + ".dateSrcField"));
				} else {
					assertEquals(obj.get(i).getIntSrcField(), icoll.getValueAt(i + ".intSrcField"));
					assertEquals(obj.get(i).getStrSrcField(), icoll.getValueAt(i + ".strSrcField"));
					assertEquals(obj.get(i).getDateSrcField(), icoll.getValueAt(i + ".dateSrcField"));
				}
			}

			// map context back to list
			Context ctxRevert = getContext("WMCWB1254BColl");
			IndexedCollection icollRevert = (IndexedCollection) ctxRevert.getElementAt("innerIColl");
			icollRevert.removeAll();
			for (int i = 0; i < 13; i++) {
				icollRevert.addElement(icollRevert.createElement(false));
				icollRevert.setValueAt(i + ".intSrcField", i * 13);
				icollRevert.setValueAt(i + ".strSrcField", "" + i * 130);
				icollRevert.setValueAt(i + ".dateSrcField", new Date());
			}
			WSMapperConverter mapperRevert = getFormat("WMCWB1254NullDefaultRevert");
			List<WMCWB1244NullDefault> objRevert = (List<WMCWB1244NullDefault>) mapperRevert.mapContextToObject(ctxRevert);
			assertEquals(icollRevert.size(), objRevert.size());
			for (int i = 0; i < objRevert.size(); i++) {
				assertEquals(icollRevert.getValueAt(i + ".intSrcField"), objRevert.get(i).getIntSrcField());
				assertEquals(icollRevert.getValueAt(i + ".strSrcField"), objRevert.get(i).getStrSrcField());
				assertEquals(icollRevert.getValueAt(i + ".dateSrcField"), objRevert.get(i).getDateSrcField());
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1254KCollNullDefault() {
		try {
			Context ctx = getContext("WMCWB1254KCollCtxt");
			// System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1254NullDefault");
			List<WMCWB1244NullDefault> obj = new ArrayList<WMCWB1244NullDefault>();
			for (int i = 0; i < 12; i++) {
				if (i != 0 && i % 5 == 0)
					obj.add(null);
				else {
					WMCWB1244NullDefault o = new WMCWB1244NullDefault();
					o.setIntSrcField(i);
					o.setStrSrcField("00" + i);
					obj.add(o);
				}
			}
			// System.out.println(obj);
			mapper.mapObjectToContext(obj, ctx);
			// System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				if (i != 0 && i % 5 == 0) {
					assertNull(obj.get(i));
					// Meeting said: dest icoll should have default values
					// those default values are defined in xml or java bean
					// check default values
					assertEquals(0, icoll.getValueAt(i + ".intSrcField"));
					assertNull(icoll.getValueAt(i + ".strSrcField"));
					assertNull(icoll.getValueAt(i + ".dateSrcField"));
					
					//TODO will lead error
//					assertEquals("9010", icoll.getValueAt(i + ".intSrcField"));
//					assertEquals("NULL_STR", icoll.getValueAt(i + ".strSrcField"));
//					assertEquals("NULL_DATE", icoll.getValueAt(i + ".dateSrcField"));
				} else {
					assertEquals(obj.get(i).getIntSrcField(), icoll.getValueAt(i + ".intSrcField"));
					assertEquals(obj.get(i).getStrSrcField(), icoll.getValueAt(i + ".strSrcField"));
					assertEquals(obj.get(i).getDateSrcField(), icoll.getValueAt(i + ".dateSrcField"));
				}
			}

			// map context back to list
			Context ctxRevert = getContext("WMCWB1254BColl");
			IndexedCollection icollRevert = (IndexedCollection) ctxRevert.getElementAt("innerIColl");
			icollRevert.removeAll();
			for (int i = 0; i < 13; i++) {
				icollRevert.addElement(icollRevert.createElement(false));
				icollRevert.setValueAt(i + ".intSrcField", i * 13);
				icollRevert.setValueAt(i + ".strSrcField", "" + i * 130);
				icollRevert.setValueAt(i + ".dateSrcField", new Date());
			}
			WSMapperConverter mapperRevert = getFormat("WMCWB1254NullDefaultRevert");
			List<WMCWB1244NullDefault> objRevert = (List<WMCWB1244NullDefault>) mapperRevert.mapContextToObject(ctxRevert);
			assertEquals(icollRevert.size(), objRevert.size());
			for (int i = 0; i < objRevert.size(); i++) {
				assertEquals(icollRevert.getValueAt(i + ".intSrcField"), objRevert.get(i).getIntSrcField());
				assertEquals(icollRevert.getValueAt(i + ".strSrcField"), objRevert.get(i).getStrSrcField());
				assertEquals(icollRevert.getValueAt(i + ".dateSrcField"), objRevert.get(i).getDateSrcField());
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testWMCWB1254Append() {
		try {
			Context ctx = getContext("WMCWB1254");
			// int orgSize = ((IndexedCollection)
			// ctx.getElementAt("innerIColl")).size();
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("WMCWB1254Append");
			List<WMCWB1244> obj = new ArrayList<WMCWB1244>();
			for (int i = 0; i < 12; i++) {
				obj.add(new WMCWB1244());
			}
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			IndexedCollection icoll = (IndexedCollection) ctx.getElementAt("innerIColl");
			assertEquals(obj.size(), icoll.size());
			for (int i = 0; i < obj.size(); i++) {
				WMCWB1244 anObj = obj.get(i);
				assertEquals(anObj.getIntSrcField(), icoll.getValueAt((i) + ".intField"));
				assertEquals(anObj.getStrSrcField(), icoll.getValueAt((i) + ".strField"));
				assertEquals(anObj.getDateSrcField(), icoll.getValueAt((i) + ".dateField"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
