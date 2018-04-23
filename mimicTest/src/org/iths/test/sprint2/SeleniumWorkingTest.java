package org.iths.test.sprint2;

import org.junit.Assert;
import org.junit.Test;

public class SeleniumWorkingTest {

//	@Test
	public void learnReqResp() {
		
//		this test passed, need to "unlearn" first if this is to be run more than one time
		
		TestSelenium driver = new TestSelenium();
		driver.openURL("http://localhost:8080/2+2"); 
		driver.sendText("4");
		driver.clickLearn();
		driver.openURL("http://localhost:8080/2+2");
		Assert.assertEquals("4", driver.getValue());
		driver.quitSelenium();
	}	

//	@Test
	public void changeResp() {
		
//		This I need help with
		
		TestSelenium driver = new TestSelenium();
		driver.openURL(""); 
		driver.sendText("");
		driver.clickLearn();
		driver.openURL("");
		Assert.assertEquals("", driver.getValue());
		driver.quitSelenium();
	}	
	
//	@Test
	public void unlearn() {
		
//		shows "nothing to unlearn"?!
		
		TestSelenium driver = new TestSelenium();
		driver.openURL("http://localhost:8080/5+5"); 
		driver.sendText("10");
		driver.clickLearn();
		driver.delay(2000);
		driver.openURL("http://localhost:8080/unlearn");
		Assert.assertEquals("OK", driver.getValue());
		driver.quitSelenium();
	}
	
	@Test
	public void closeMimic() {
		
//		This test passed
		
		TestSelenium driver = new TestSelenium();
		driver.openURL("http://localhost:8080/KillMimic"); 
		Assert.assertEquals("OK", driver.getValue());
		driver.quitSelenium();
	}	
}
