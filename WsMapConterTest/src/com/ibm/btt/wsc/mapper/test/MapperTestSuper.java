/**
 * Created by lvst at 2010-8-26 04:57:47 PM
 */
package com.ibm.btt.wsc.mapper.test;

import java.io.IOException;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.ContextFactory;
import com.ibm.btt.base.DSEInvalidRequestException;
import com.ibm.btt.base.FormatElement;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.config.InitManager;

import junit.framework.TestCase;

/**
 * @author lvst
 * 
 */
public class MapperTestSuper extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		InitManager.reset("jar:///definitions/btt.xml");
	}

	public static Context getContext(String ctxtName) throws DSEInvalidRequestException {
		return ContextFactory.createContext(ctxtName, false);
	}

	public static WSMapperConverter getFormat(String fmtName) throws IOException {
		return (WSMapperConverter) FormatElement.readObject(fmtName);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		InitManager.cleanUp();
	}
}
