/**
 * 
 */
package com.ibm.btt.wsc.mapper.test;

import java.util.ArrayList;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.DSEInvalidArgumentException;
import com.ibm.btt.base.DSEInvalidClassException;
import com.ibm.btt.base.DataField;
import com.ibm.btt.base.DataMapperConverterFormat;
import com.ibm.btt.base.ErrorInfo;
import com.ibm.btt.base.FormatElement;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.bean.TypeManager;
import com.ibm.btt.config.InitManager;
import com.ibm.btt.wsc.mapper.beans.UnCloneableField;
import com.ibm.btt.wsc.mapper.beans.WMCWB1244CompleteMatch;

/**
 * @author stlv
 * 
 */
public class ExceptionCases extends MapperTestSuper {

	@Override
	protected void setUp() throws Exception {
		InitManager.reset("jar:///definitions/bttNeg.xml");
	}

	/**
	 * An element Cannot be found in the from context;<br>
	 * The format definition is:<br>
	 * mapper from="NOSUCHELE" to="field1" <br>
	 */
	public void testMapperNoSuchElementInFromCtxt() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception01Mapper");
			String obj = "XXXYYYZZZ";
			obj = (String) mapper.mapContextToObject(ctx);
			System.out.println(obj);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertTrue("Here should be an exception, for element 'NOSUCHELE' Cannot be found from 'Exception01Ctxt' context!",
					dse.getMessage().indexOf("NOSUCHELE") > -1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from element Cannot be found in context!\n" + e);
		}
	}

	/**
	 * An element Cannot be found in the to context;<br>
	 * The format definition is:<br>
	 * mapper from="*" to="NOSUCHELE" <br>
	 */
	public void testMapperNoSuchElementInToCtxt() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception02Mapper");
			String obj = "XXXYYYZZZ";
			mapper.mapObjectToContext(obj, ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertTrue("Here should be an exception, for element 'NOSUCHELE' Cannot be found from 'Exception01Ctxt' context!",
					dse.getMessage().indexOf("NOSUCHELE") > -1);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from element Cannot be found in context!\n" + e);
		}
	}

	/**
	 * Map unsupported array to a BTT context;<br>
	 * The format definition is:<br>
	 * wsMapperConverter dataName="ExceptionKColl" isPrimitive="false"
	 * javaClass="integer[]"<br>
	 */
	public void testMapUnsupportedArrayToCtxt() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception03Mapper");
			int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			mapper.mapObjectToContext(intArray, ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for array type integer(NOT int) is not supported!",
					"Cannot support the data type: integer[]", dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from element Cannot be found in context!\n" + e);
		}
	}

	/**
	 * Map array to a simple data field in context;<br>
	 * The format definition is:<br>
	 * mapper from="array.*" to="aSimpleField"<br>
	 */
	public void testMapArrayToDataField() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception04Mapper");
			int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			mapper.mapObjectToContext(intArray, ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for mapping array to a simple field!",
					"The input and output data types do not match.", dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from element Cannot be found in context!\n" + e);
		}
	}

	/**
	 * Map array to a simple data field in context;<br>
	 * The format definition is:<br>
	 * mapper from="array.*" to="NON_EXIST_ICOLL"<br>
	 */
	public void testMapArrayToNonExistCollection() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception05Mapper");
			int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			mapper.mapObjectToContext(intArray, ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for to element does not exist!",
					"The input and output data types do not match.",
					dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from element Cannot be found in context!\n" + e);
		}
	}

	/**
	 * Map unsupported array to a BTT context;<br>
	 * The format definition is:<br>
	 * wsMapperConverter dataName="ExceptionKColl" isPrimitive="false"
	 * javaClass="integer[]"<br>
	 */
	public void testMapIcollValueToUnsupportedArray() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception06Mapper");
			mapper.mapContextToObject(ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for array type integer(NOT int) is not supported!",
					"Cannot support the data type: integer[]", dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from element Cannot be found in context!\n" + e);
		}
	}

	/**
	 * Map array to a simple data field in context;<br>
	 * The format definition is:<br>
	 * mapper from="aSimpleField" to="array.*"<br>
	 */
	public void testMapDataFieldToArray() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception07Mapper");
			mapper.mapContextToObject(ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for mapping a simple field to an array!",
					"The input and output data types do not match.", dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from element Cannot be found in context!\n" + e);
		}
	}

	/**
	 * Map array to a simple data field in context;<br>
	 * The format definition is:<br>
	 * mapper from="NON_EXIST_ICOLL" to="array.*"<br>
	 */
	public void testMapNonExistCollectionToArray() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception08Mapper");
			mapper.mapContextToObject(ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for to element does not exist!",
					"The input and output data types do not match.",
					dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from element Cannot be found in context!\n" + e);
		}
	}

	/**
	 * Map a value to non exist class;<br>
	 * The format definition is:<br>
	 * wsMapperConverter dataName="ExceptionKColl" isPrimitive="false"
	 * javaClass="st.lv.NonExistClass"<br>
	 */
	public void testMapValueToNonExistClass() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception09Mapper");
			mapper.mapContextToObject(ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidClassException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for class can not be loaded!",
					"Cannot load the class: st.lv.NonExistClass", dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from the class can not be loaded!\n" + e);
		}
	}

	/**
	 * Map a value to non exist class;<br>
	 * The format definition is:<br>
	 * wsMapperConverter dataName="ExceptionKColl" isPrimitive="false"
	 * javaClass="st.lv.NonExistClass[]"<br>
	 */
	public void testMapValueToNonExistArrayClass() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception10Mapper");
			mapper.mapContextToObject(ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidClassException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for class can not be loaded!",
					"Cannot load the class: st.lv.NonExistClass", dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from the class can not be loaded!\n" + e);
		}
	}

	/**
	 * Map a value to non exist class;<br>
	 * The format definition is:<br>
	 * wsMapperConverter dataName="ExceptionKColl" isPrimitive="false"
	 * javaClass="st.lv.NonExistClass[]"<br>
	 */
	public void testMapNonExistJavaClassListToBttCtxt() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception11Mapper");
			mapper.mapObjectToContext(new ArrayList<Object>(), ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidClassException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for class can not be loaded!",
					"Cannot load the class: st.lv.NonExistClass", dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: from the class can not be loaded!\n" + e);
		}
	}

	/**
	 * Map a java bean to a BTT data field;<br>
	 * The format definition is:<br>
	 * Exception12Mapper<br>
	 */
	public void testMapJavaBeanToBttCtxtField() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception12Mapper");
			mapper.mapObjectToContext(new WMCWB1244CompleteMatch(), ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for mapping a java bean to a simple field!",
					"From data element [beanSrcCollection] does mismatch to the To data element [aSimpleField].",
					dse.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: for mapping a java bean to a simple field!\n" + e);
		}
	}

	/**
	 * Map a BTT data field to a java bean;<br>
	 * The format definition is:<br>
	 * Exception13Mapper<br>
	 */
	public void testMapBttCtxtFieldToJavaBean() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			WSMapperConverter mapper = getFormat("Exception13Mapper");
			mapper.mapContextToObject(ctx);
			fail("Exception should be thrown out while mapping values!");
		} catch (DSEInvalidArgumentException dse) {
			dse.printStackTrace();
			assertEquals("Here should be an exception, for mapping a java bean to a simple field!",
					"From data element [aSimpleField] does mismatch to the To data element [beanSrcCollection].",
					dse.getMessage());
		} catch (Exception e) {
//			e.printStackTrace();
			fail("Exception got while testing exception case: for mapping a simple field to a java bean!\n" + e);
		}
	}

	/**
	 * Clone an uncloneable field in ws mapper;<br>
	 * The format definition is:<br>
	 * Exception14Mapper<br>
	 */
	public void testCloneUnClonableField1() {
		try {
			Context ctx = getContext("ExceptionCtxt");
			ctx.setValueAt("aSimpleField", new UnCloneableField());
			// ctx.getKeyedCollection().clone();
			WSMapperConverter mapper = getFormat("Exception14Mapper");
			Object o = mapper.mapContextToObject(ctx);
			assertEquals(UnCloneableField.class, o.getClass());
			assertEquals(ctx.getValueAt("aSimpleField"),o);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Clone an uncloneable field in ws mapper;<br>
	 * The format definition is:<br>
	 * treateSimpleMapper<br>
	 */
	public void testCloneUnClonableField1BeanField() {
		try {
			Context ctx = getContext("treateSimpleCtxt");
			ctx.setValueAt("ucf", new UnCloneableField());
			// ctx.getKeyedCollection().clone();
			WSMapperConverter mapper = getFormat("treateSimpleMapper");
			Object o = mapper.mapContextToObject(ctx);
			assertEquals(UnCloneableField.class, o.getClass());
			assertEquals(ctx.getValueAt("ucf"),o);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Clone an uncloneable field in data mapper;<br>
	 * The format definition is:<br>
	 * Exception15Mapper<br>
	 */
	public void testCloneUnClonableField2() {
		try {
			TypeManager.treatClassAsSimpleType(UnCloneableField.class);
			Context ctx = getContext("ExceptionCtxt");
			Context octx = getContext("ExceptionCtxt");
			ctx.setValueAt("aSimpleField", new UnCloneableField());
			DataMapperConverterFormat mapper = (DataMapperConverterFormat) FormatElement.readObject("Exception15Mapper");
			mapper.mapContents(ctx, octx);
			fail("Exception got while testing exception case: for clone unclonable class.");
		} catch (DSEInvalidArgumentException dse) {
			assertEquals(CloneNotSupportedException.class, dse.getCause().getClass());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception got while testing exception case: for clone unclonable class." + e);
		}
	}

	/**
	 * Map BTT typed data values with BTT data mapper converter;<br>
	 * The format definition is:<br>
	 * Exception16Mapper<br>
	 * *Since 2011-01-14, the convertFomr & convertTo are supported.<br>
	 */
	public void testMapTypedDataValue1() {
		try {
			TypeManager.treatClassAsSimpleType(UnCloneableField.class);
			Context ctx = getContext("ExceptionCtxt");
			Context octx = getContext("ExceptionCtxt");
			ctx.setValueAt("aSimpleTypedField", Integer.parseInt("1024"));
			DataMapperConverterFormat mapper = (DataMapperConverterFormat) FormatElement.readObject("Exception16Mapper");
			mapper.mapContents(ctx, octx);
			assertEquals(ctx.getValueAt("aSimpleTypedField"), octx.getValueAt("aSimpleTypedField"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Map BTT typed data values with BTT data mapper converter;<br>
	 * The format definition is:<br>
	 * Exception17Mapper<br>
	 * *Since 2011-01-14, the convertFomr & convertTo are supported.<br>
	 */
	public void testMapTypedDataValue2() {
		// TODO pending on Message: this function is not supported for current
		// version
		try {
			TypeManager.treatClassAsSimpleType(UnCloneableField.class);
			Context ctx = getContext("ExceptionCtxt");
			ctx.setValueAt("aSimpleTypedField", new Integer(1024));
			WSMapperConverter mapper = getFormat("Exception17Mapper");
			WMCWB1244CompleteMatch obj = (WMCWB1244CompleteMatch) mapper.mapContextToObject(ctx);
			assertEquals(ctx.getValueAt("aSimpleTypedField"), obj.getIntSrcField());

			try {
				// data that can not be cloned
				mapper = getFormat("Exception18Mapper");
				DataField df = (DataField) ctx.getElementAt("aSimpleTypedField");
				df.setErrorInfo(new ErrorInfo(new UnCloneableField()));
				df.setValidValue(12345);
				obj = new WMCWB1244CompleteMatch();
				obj.setIntSrcField(98754);
				mapper.mapObjectToContext(obj, ctx);
				assertEquals(98754,obj.getIntSrcField());
				assertEquals(obj.getIntSrcField(),ctx.getValueAt("aSimpleTypedField"));
			} catch (Exception e) {
				e.printStackTrace();
				fail(e.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("this function is not supported for current version", e.getCause().getMessage());
		}
	}
}