package org.iths.test.sprint3;

import org.iths.main.HttpServiceCaller;
import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MimicStepDef {
	private final static String host="http://localhost:8080/"; 
	private HttpServiceCaller service = new HttpServiceCaller();
	
	public MimicStepDef() {
		
	}
	@Given("^that the mock has learned requests and responses$")
	public void that_the_mock_has_learned_requests_and_responses() throws Throwable {
	
		service.executeGetRequest(host + "LearnNextResponse?text=2");
		service.executeGetRequest(host + "1+1"); 
		Assert.assertEquals("2", service.executeGetRequest(host + "1+1"));
		
		service.executeGetRequest(host + "LearnNextResponse?text=3");
		service.executeGetRequest(host + "2+1"); 
		Assert.assertEquals("3", service.executeGetRequest(host + "2+1"));
	    
	}

	@When("^I write unlearnAll in url$")
	public void i_write_unlearnAll_in_url() throws Throwable {
	  service.executeGetRequest(host + "unlearnAll");
	
	}

	@Then("^the mock unlearns all responses$")
	public void the_mock_unlearns_all_responses() throws Throwable {
		Assert.assertNotEquals("2", service.executeGetRequest(host+"1+1"));
		Assert.assertNotEquals("3", service.executeGetRequest(host+"2+1"));
	   
	}
	
	@Given("^that no requests are stored$")
	public void that_no_requests_are_stored() throws Throwable {
	   //Mimic is empty when started
	    
	}

	@Then("^the mock shows error message$")
	public void the_mock_shows_error_message() throws Throwable {
		Assert.assertEquals("Nothing to unlearn", service.executeGetRequest(host + "unlearnAll"));
	}

}
