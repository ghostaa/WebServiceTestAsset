package com.ibm.btt.base.ws.format.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class WsMapperTestCases {
	
	public static Test suite(){
		TestSuite suite = new TestSuite(WsMapperTestCases.class.getName());
		
		suite.addTestSuite(Context2ObjectTest.class);
		suite.addTestSuite(Object2ContextTest.class);
		
		return suite;
	}
	
	
	
}
