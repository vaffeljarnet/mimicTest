package org.iths.test.sprint2;

import org.junit.Assert;
import org.junit.Test;

public class TestMimcGUI {
	
	String host = "http://localhost:8080/";
	
//	@Test
	public void learnReqResp() {
		
//		this test passed, need to "unlearn" first if this is to be run more than one time
//		maybe put unlearn in the last steps in the testcase?
		
		TestSelenium driver = new TestSelenium();
		driver.openURL(host+"2+2"); 
		driver.sendText("4");
		driver.clickLearn();
		driver.openURL("http://localhost:8080/2+2");
		Assert.assertEquals("4", driver.getValue());
		driver.quitSelenium();
	}	

	@Test
	public void changeResp() {
		
//		This I need help with
		
		TestSelenium driver = new TestSelenium();
		driver.openURL(host+"1+1"); 
		driver.sendText("3");
		driver.clickLearn();
		driver.openURL(host+"LearnNextResponse?text=2");
		driver.openURL(host+"1+1");
		Assert.assertEquals("2", driver.getValue());
		driver.quitSelenium();
	}	
	
	@Test
	public void unlearn() {
		
//		shows "nothing to unlearn" if you don't add line 46?!
		
		TestSelenium driver = new TestSelenium();
		driver.openURL(host+"5+5"); 
		driver.sendText("10");
		driver.clickLearn();
		//driver.openURL("http://localhost:8080/5+5");
		driver.openURL(host+"unlearn");
		Assert.assertEquals("OK", driver.getValue());
		driver.quitSelenium();
	}
	
//	@Test
	public void closeMimic() {
		
//		This test passed
		
		TestSelenium driver = new TestSelenium();
		driver.openURL(host+"KillMimic"); 
		Assert.assertEquals("OK", driver.getValue());
		driver.quitSelenium();
	}	
}
