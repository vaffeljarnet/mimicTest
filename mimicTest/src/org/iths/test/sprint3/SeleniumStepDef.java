package org.iths.test.sprint3;

import org.iths.main.MimicGuiSelenium;

import cucumber.api.java.en.When;

public class SeleniumStepDef {
	
	private MimicGuiSelenium driver = new MimicGuiSelenium();
	
	@When("^I open the url \"([^\"]*)\"$")
	public void i_open_the_url(String arg1) throws Throwable {
	    driver.openURL("localhost:8080/"+arg1);
	}
	
	@When("^I input \"([^\"]*)\" in the response form$")
	public void i_input_in_the_response_form(String arg1) throws Throwable {
	    driver.sendText(arg1);
	}

	@When("^I press the learn button$")
	public void i_press_the_learn_button() throws Throwable {
	    driver.clickLearn();
	}
	
	@When("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	    driver.quitSelenium();
	}
	
	@When("^I open the relearn URL$")
	public void i_use_the_relearn_function() throws Throwable {
	    driver.openURL("localhost:8080/relearn");
	}
	
}


