package com.ibm.btt.wsc.mapper.test;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.config.InitManager;
import com.ibm.btt.wsc.mapper.beans.TestBean0;
import com.ibm.btt.wsc.mapper.beans.TestBean1;
import com.ibm.btt.wsc.mapper.beans.TestBean2;
import com.ibm.btt.wsc.mapper.beans.TestBean3;

/**
 * @author hyj
 */
public class ThreeLevelBeanMapTest extends MapperTestSuper {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		InitManager.reset("jar:///definitions/btt.xml");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		InitManager.cleanUp();
	}

	/**
	 * Map from BTT data to web service data, with 3 levels indexed collection
	 */
	public void testContextToWSDL() {
		try {
			Context ctx = getContext("opCtx");
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 7; j++) {
					for (int k = 0; k < 3; k++) {
						ctx.setValueAt("returnType.bean." + i + ".bean." + j + ".bean." + k + ".field0", i + j + k + 1024);
						ctx.setValueAt("returnType.bean." + i + ".bean." + j + ".bean." + k + ".field1", "ValueOfString"
								+ String.valueOf(i) + String.valueOf(j) + String.valueOf(k));
					}
				}
			}
			// System.out.println(ctx.getKeyedCollection());
			WSMapperConverter mapper = getFormat("inputFmt");

			TestBean0 o = (TestBean0) mapper.mapContextToObject(ctx);
			assertNotNull(o);
			assertNotNull(o.getBean());
			assertEquals(5, o.getBean().size());
			assertEquals(7, o.getBean().get(0).getBean().size());
			assertEquals(3, o.getBean().get(0).getBean().get(0).getBean().size());

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 7; j++) {
					for (int k = 0; k < 3; k++) {
						TestBean3 tb3 = o.getBean().get(i).getBean().get(j).getBean().get(k);
						assertEquals(ctx.getValueAt("returnType.bean." + i + ".bean." + j + ".bean." + k + ".field0"),
								tb3.getField0());
						assertEquals(ctx.getValueAt("returnType.bean." + i + ".bean." + j + ".bean." + k + ".field1"),
								tb3.getField1());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Map from web service data to BTT data, with 3 levels indexed collection
	 */
	public void testWSDLToContext() {
		try {
			// prepare the bean object and initialize values needed
			TestBean0 tb0 = new TestBean0();
			for (int i = 0; i < 15; i++) {
				TestBean1 tb1 = new TestBean1();
				for (int j = 0; j < 17; j++) {
					TestBean2 tb2 = new TestBean2();
					for (int k = 0; k < 13; k++) {
						TestBean3 tb3 = new TestBean3();
						tb3.setField0(i + j + k + 512);
						tb3.setField1("SingleString" + String.valueOf(i) + String.valueOf(j) + String.valueOf(k));
						tb2.getBean().add(tb3);
					}
					tb1.getBean().add(tb2);
				}
				tb0.getBean().add(tb1);
			}

			// mapping data from web service to btt context
			Context ctx = getContext("opCtx");
			WSMapperConverter mapper = getFormat("outputFmt");
			mapper.mapObjectToContext(tb0, ctx);
			// System.out.println(ctx.getKeyedCollection());
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 17; j++) {
					for (int k = 0; k < 13; k++) {
						TestBean3 tb3 = tb0.getBean().get(i).getBean().get(j).getBean().get(k);
						assertEquals(tb3.getField0(),
								ctx.getValueAt("returnType.bean." + i + ".bean." + j + ".bean." + k + ".field0"));
						assertEquals(tb3.getField1(),
								ctx.getValueAt("returnType.bean." + i + ".bean." + j + ".bean." + k + ".field1"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
