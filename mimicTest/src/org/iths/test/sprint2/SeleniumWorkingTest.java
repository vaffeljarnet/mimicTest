package org.iths.test.sprint2;

import org.junit.Assert;
import org.junit.Test;

public class SeleniumWorkingTest {

	@Test
	public void test() {
		TestSelenium driver = new TestSelenium();
		driver.openURL("http://localhost:8080/2+2"); 
		driver.sendText("4");
		driver.delay(2000);
		driver.clickLearn();
		driver.delay(2000);
		driver.openURL("http://localhost:8080/2+2");
		Assert.assertEquals("4", driver.getValue());
		driver.quitSelenium();
	}	  
}
