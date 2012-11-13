package com.ibm.btt.wsc.mapper.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class WsMapperTestCases {

	public static Test suite() {
		TestSuite suite = new TestSuite(WsMapperTestCases.class.getName());
		// $JUnit-BEGIN$
		suite.addTestSuite(NegativeCases.class);
		suite.addTestSuite(ExceptionCases.class);
		suite.addTestSuite(BD2WDMapperSimpleStructure.class);
		suite.addTestSuite(BD2WDMapperComplexStructure.class);
		suite.addTestSuite(WD2BDMapperTests.class);
		suite.addTestSuite(E2EAsteriskTestsArray.class);
		suite.addTestSuite(E2EAsteriskTestsList.class);
		suite.addTestSuite(E2EAsteriskRevertTestsArray.class);
		suite.addTestSuite(E2EAsteriskRevertTestsList.class);
		suite.addTestSuite(ThreeLevelBeanMapTest.class);
		// $JUnit-END$
		return suite;
	}

}
