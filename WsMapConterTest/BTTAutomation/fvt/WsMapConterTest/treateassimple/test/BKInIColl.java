package treateassimple.test;

import com.ibm.btt.base.DataElement;
import com.ibm.btt.base.IndexedCollection;
import com.ibm.btt.config.InitManager;

public class BKInIColl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InitManager.reset("jar:///definitions/bttNeg.xml");
			tryKeyedCollection(false);
			tryBeanCollection(false);
			 tryKeyedCollection(true);
			 tryBeanCollection(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void tryBeanCollection(boolean shareDescriptor) throws Exception {
		IndexedCollection iBeanC = (IndexedCollection) DataElement
				.readObject("iBeanC");
		iBeanC.removeAll();
		for (int i = 0; i < 3; i++) {
			iBeanC.addElement(iBeanC.createElement(shareDescriptor));
		}
		System.out.println("\n" + iBeanC);
	}

	static void tryKeyedCollection(boolean shareDescriptor) throws Exception {
		IndexedCollection iKeyC = (IndexedCollection) DataElement
				.readObject("iKeyC");
		iKeyC.removeAll();
		for (int i = 0; i < 3; i++) {
			iKeyC.addElement(iKeyC.createElement(shareDescriptor));
		}
		System.out.println("\n" + iKeyC);
	}
}
