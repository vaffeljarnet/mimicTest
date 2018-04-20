package org.iths.test.sprint2;

import org.junit.Test;

public class SeleniumWorkingTest {

	@Test
	public void test() {
		TestSelenium driver = new TestSelenium();
		driver.openURL("http://www.ikea.se"); 
		driver.clickLink();
		driver.delay(2000);
		driver.quitSelenium();
	}	  

}
