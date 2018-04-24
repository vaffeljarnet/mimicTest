package org.iths.test.sprint2;

import org.junit.Assert;
import org.junit.Test;

public class TestMimcGUI {
	
	String host = "http://localhost:8080/";
	String request;
	
//	@Test
	public void learnReqResp() {
		
//		this test passed, need to "unlearn" first if this is to be run more than one time
//		maybe put unlearn in the last steps in the testcase?
		
		TestSelenium driver = new TestSelenium();
		request = "2+2";
		driver.openURL(host+request); 
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
		driver.openURL("http://localhost:8080/1+1"); 
		driver.sendText("3");
		driver.clickLearn();
		driver.openURL("http://localhost:8080/LearnNextResponse?text=2");
		driver.openURL("http://localhost:8080/1+1");
		Assert.assertEquals("2", driver.getValue());
		driver.quitSelenium();
	}	
	
	@Test
	public void unlearn() {
		
//		shows "nothing to unlearn" if you don't add line 46?!
		
		TestSelenium driver = new TestSelenium();
		driver.openURL("http://localhost:8080/5+5"); 
		driver.sendText("10");
		driver.clickLearn();
		//driver.openURL("http://localhost:8080/5+5");
		driver.openURL("http://localhost:8080/unlearn");
		Assert.assertEquals("OK", driver.getValue());
		driver.quitSelenium();
	}
	
//	@Test
	public void closeMimic() {
		
//		This test passed
		
		TestSelenium driver = new TestSelenium();
		driver.openURL("http://localhost:8080/KillMimic"); 
		Assert.assertEquals("OK", driver.getValue());
		driver.quitSelenium();
	}	
}
