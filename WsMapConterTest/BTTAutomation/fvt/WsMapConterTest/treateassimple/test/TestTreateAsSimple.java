package treateassimple.test;

import com.ibm.btt.base.DataElement;
import com.ibm.btt.bean.TypeManager;
import com.ibm.btt.config.InitManager;

public class TestTreateAsSimple {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		TypeManager.treatClassAsSimpleType(BeanB.class);
		InitManager.reset("jar:///definitions/bttNeg.xml");
		DataElement deP = (DataElement) DataElement.readObject("beanA");
		DataElement deS = deP.getElementAt("beanB");
		System.out.println("*******************************************************************");
		System.out.println(deP.getClass());
		System.out.println(deP);
		System.out.println("===================================================================");
		System.out.println(deS.getClass());
		System.out.println(deS);
		System.out.println("*******************************************************************");
	}

}
