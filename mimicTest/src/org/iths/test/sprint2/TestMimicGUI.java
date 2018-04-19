package org.iths.test.sprint2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMimicGUI {

	@Test
	public void test() {
		TestSelenium driver = new TestSelenium;
		driver.openURL("localhost:8080/1+1?learn");
		driver.click("ResponseField");
		driver.sendKeys("2");
		driver.click("LearnButton");
	}

}
