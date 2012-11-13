/**
 * Created by lvst at 2010-8-30 05:34:24 PM
 */
package com.ibm.btt.wsc.mapper.test;

import java.io.IOException;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.config.InitManager;

/**
 * @author lvst
 * 
 */
public class NegativeCases extends MapperTestSuper {

	@Override
	protected void setUp() throws Exception {
		InitManager.reset("jar:///definitions/bttNeg.xml");
	}

	public void testNEGWMC211() {
		try {
			Context ctx = getContext("NEGWMC211");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("NEGWMC211");
			String obj = "XXXYYYZZZ";
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
			// TODO Will be taken as primitive types!
			assertEquals("Will be taken as primitive types!", obj, ctx.getValueAt("field1"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	public void testNEGWMC212() {
		try {
			Context ctx = getContext("NEGWMC212");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("NEGWMC212");
			String obj = "XXXYYYZZZ";
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
		} catch (Exception e) {
			e.printStackTrace();
			Exception er = (Exception) e.getCause();
			assertEquals(IOException.class, er.getClass());
			assertTrue(er.getMessage().indexOf("Mandatory attribute 'javaClass' has not been introduced")>-1);
		}
	}

	public void testNEGWMC213() {
		try {
			// TODO if not equals "true" it should be "false"
			Context ctx = getContext("NEGWMC213");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("NEGWMC213");
			String obj = "XXXYYYZZZ";
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
		} catch (Exception e) {
			e.printStackTrace();
			Exception er = (Exception) e.getCause();
			assertEquals(IOException.class, er.getClass());
			assertTrue(er.getMessage().indexOf("Mandatory attribute 'javaClass' has not been introduced")>-1);
		}
	}

	public void testNEGWMC215() {
		try {
			Context ctx = getContext("NEGWMC213");
			System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("NEGWMC215");
			String obj = "XXXYYYZZZ";
			mapper.mapObjectToContext(obj, ctx);
			System.out.println(ctx.getKeyedCollection());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(
					"Here should be an IOException while initializing WSMapperConverter Format.",
					e.getMessage().indexOf("Error with operation tag: <wsMapperConverter") > -1);
		}
	}

}
