package org.iths.test.sprint2;

import org.junit.Assert;
import org.junit.Test;

public class TestMimcGUI {
	
	String host = "http://localhost:8080/";
	
    @Test
	public void TestMimicGUI111learnReqResp() {
		
		MimicGuiSelenium driver = new MimicGuiSelenium();
		driver.openURL(host+"2+2");
		driver.sendText("4");
		driver.clickLearn();
		driver.openURL(host+"2+2");
		Assert.assertEquals("4", driver.getValue());
		driver.openURL(host+"unlearn");
		driver.quitSelenium();
	}	

	@Test
	public void TestMimicGUI112changeResp() {
		
		MimicGuiSelenium driver = new MimicGuiSelenium();
		driver.openURL(host+"1+1"); 
		driver.sendText("3");
		driver.clickLearn();
		driver.openURL(host+"1+1");
		Assert.assertEquals("3", driver.getValue());
		driver.openURL(host+"LearnNextResponse?text=2");
		driver.openURL(host+"1+1");
		Assert.assertEquals("2", driver.getValue());
		driver.openURL(host+"unlearn");
		driver.quitSelenium();
	}	
	
	@Test
	public void TestMimicGUI113unlearnWithoutRequest() {

		MimicGuiSelenium driver = new MimicGuiSelenium();
		driver.openURL(host+"5+5"); 
		driver.sendText("10");
		driver.clickLearn();
		driver.openURL(host+"unlearn");
		Assert.assertEquals("OK", driver.getValue());
		driver.openURL(host+"5+5"); 
		driver.openURL(host+"unlearn");
		driver.quitSelenium();
	}
	
	@Test
	public void TestMimicGUI114unlearnWithRequest() {
		
		MimicGuiSelenium driver = new MimicGuiSelenium();
		driver.openURL(host+"5+5"); 
		driver.sendText("10");
		driver.clickLearn();
		driver.openURL(host+"5+5"); 
		driver.openURL(host+"unlearn");
		Assert.assertEquals("OK", driver.getValue());
		driver.quitSelenium();
	}
	
	
//	@Test
	public void closeMimic() {
		
//		This test passed
		
		MimicGuiSelenium driver = new MimicGuiSelenium();
		driver.openURL(host+"KillMimic"); 
		Assert.assertEquals("OK", driver.getValue());
		driver.quitSelenium();
	}	
}
