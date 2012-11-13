package com.ibm.btt.base.ws.format.test;

import java.io.IOException;

import com.ibm.btt.base.Context;
import com.ibm.btt.base.ContextFactory;
import com.ibm.btt.base.DSEInvalidRequestException;
import com.ibm.btt.base.FormatElement;
import com.ibm.btt.base.ws.WSMapperConverter;
import com.ibm.btt.config.InitManager;

import junit.framework.TestCase;

public class WSMapperConverterTestFramework extends TestCase {

	//prepare the environment for btt
	protected void setUp() throws Exception {
		super.setUp();
		InitManager.reset("jar:///definitions/btt.xml");
	}

	//clean the environment for btt
	protected void tearDown() throws Exception {
		super.tearDown();
		InitManager.cleanUp();
	}
	
	//read context object by name
	public static Context getContext(String ctxtName) throws DSEInvalidRequestException {
		return ContextFactory.createContext(ctxtName, false);
	}

	//get WSMapperConverter instance by name
	public static WSMapperConverter getFormat(String fmtName) throws IOException {
		return (WSMapperConverter) FormatElement.readObject(fmtName);
	}

}
