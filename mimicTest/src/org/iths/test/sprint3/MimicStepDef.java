package org.iths.test.sprint3;

import org.iths.main.HttpServiceCaller;
import org.iths.main.MimicGuiSelenium;
import org.iths.main.MimicJarHelper;
import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MimicStepDef {
	private final static String host="http://localhost:8080/"; 
	private HttpServiceCaller service = new HttpServiceCaller();
	private MimicGuiSelenium driver;
	private String responseForm = "Paste or type json, xml, html or text response to learn and press Learn<br><br><form action=\"learn\" method=\"post\"><textarea name='text' rows='30' cols='150'></textarea><br><br><input type=\"submit\" id='learn' value=\"Learn\"></form>";
	
	MimicJarHelper helper = new MimicJarHelper();
	
	@Given("^that the mimicService is running$")
	public void that_the_mimicService_is_running() throws Throwable {
		if(service.executeGetRequest(host).equals("Error")) {
		  helper.startMimic();
	   }
		service.executeGetRequest(host + "unlearnAll");	
	}
	
	@Given("^that the mock has learned \"([^\"]*)\" with \"([^\"]*)\"$")
	public void that_the_mock_has_learned_questionOne_with_responseOne(String arg1, String arg2) throws Throwable {
		service.executeGetRequest(host + "LearnNextResponse?text="+arg2);
		service.executeGetRequest(host + arg1); 
		Assert.assertEquals(arg2, service.executeGetRequest(host + arg1));
	}

	@Then("^the mock unlearns \"([^\"]*)\"$")
	public void the_mock_unlearns_questionTwo(String arg1) throws Throwable {
		Assert.assertEquals(responseForm, service.executeGetRequest(host + arg1));
	}
	
	@When("^I write unlearnAll in url$")
	public void i_write_unlearnAll_in_url() throws Throwable {
	  service.executeGetRequest(host + "unlearnAll");
	
	}
	
	@Given("^that no requests are stored$")
	public void that_no_requests_are_stored() throws Throwable {
	   service.executeGetRequest(host+ "unlearnAll");
	    
	}

	@Then("^the mock shows error message$")
	public void the_mock_shows_error_message() throws Throwable {
		Assert.assertEquals("Nothing to unlearn", service.executeGetRequest(host + "unlearnAll"));
	}
	
	@When("^I teach the mock that \"([^\"]*)\" has response \"([^\"]*)\"$")
	public void i_teach_the_mock_that_has_response(String arg1, String arg2) throws Throwable {
		service.executeGetRequest(host + "LearnNextResponse?text="+arg2);
		service.executeGetRequest(host + arg1); 
		Assert.assertEquals(arg2, service.executeGetRequest(host + arg1));
	}
	
	@Then("^\"([^\"]*)\" respondes with \"([^\"]*)\"$")
	public void respondes_with(String arg1, String arg2) throws Throwable {
		Assert.assertEquals(arg2, service.executeGetRequest(host + arg1));
	}
	
	@When("^I call unlearn for \"([^\"]*)\"$")
	public void i_call_unlearn_for(String arg1) throws Throwable {
	    service.executeGetRequest(host+"unlearn");
	}
	
	@When("^I call stepBack for \"([^\"]*)\"$")
	public void i_call_stepBack_for(String arg1) throws Throwable {
	    service.executeGetRequest(host+"stepBack");
	}

}
