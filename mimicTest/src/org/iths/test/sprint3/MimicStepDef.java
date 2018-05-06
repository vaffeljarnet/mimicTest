package org.iths.test.sprint3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.iths.main.HttpServiceCaller;
import org.iths.main.MimicGuiSelenium;
import org.iths.main.MimicJarHelper;
import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MimicStepDef {
	private final static String host="http://localhost:8080/"; 
	private HttpServiceCaller service = new HttpServiceCaller();
	private MimicGuiSelenium driver;
	private String responseForm = "Paste or type json, xml, html or text response to learn and press Learn<br><br><form action=\"learn\" method=\"post\"><textarea name='text' rows='30' cols='150'></textarea><br><br><input type=\"submit\" id='learn' value=\"Learn\"></form>";	
	private MimicJarHelper helper = new MimicJarHelper();
	
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
	
	@When("^I call unlearn")
	public void i_call_unlearn() throws Throwable {
	    service.executeGetRequest(host+"unlearn");
	}
	
	@When("^I make the request \"([^\"]*)\"$")
	public void i_make_the_request(String arg1) throws Throwable {
		service.executeGetRequest(host+arg1);
	}
	
	@Then("^the request \"([^\"]*)\" has the mime type \"([^\"]*)\"$")
	public void the_request_has_the_mime_type(String arg1, String arg2) throws Throwable {
	    Assert.assertTrue(service.getMimeType(host+arg1).contains(arg2));
	}
	
	@When("^I terminate the mimicService$")
	public void i_terminate_mimicService() throws Throwable {
	    helper.killMimic();
	}

	@When("^I start mimicService$")
	public void i_start_mimicService() throws Throwable {
	    helper.startMimic();
	}
	
	@When("^I teach the mock the bellow questions and responses$")
	public void i_teach_the_mock_multiple_questions_with_responses(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
				service.executeGetRequest(host + "LearnNextResponse?text="+examples.get("Response"));
				service.executeGetRequest(host + examples.get("Question")); 
			}
	}

	@Then("^every question bellow respondes with corresponding response$")
	public void every_question_respondes_with_correct_response(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
			Assert.assertEquals(examples.get("response"), service.executeGetRequest(host + examples.get("question"))); 
		}
	}

	@When("^I call resetState$")
	public void i_call_resetState() throws Throwable {
	    service.executeGetRequest(host+"resetState");
	    helper.wait(500);
	}
	
	@When("^I teach the mock the bellow sequense$")
	public void i_teach_the_mock_the_bellow_sequense(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
			service.executeGetRequest(host + "LearnNextResponse?text="+examples.get("response"));
			service.executeGetRequest(host + examples.get("question")); 
		}
	}

	@Then("^every step in the stored sequense respondes with the stored response as bellow$")
	public void every_step_in_the_stored_sequense_respondes_with_the_correct_response_as_bellow(DataTable arg1) throws Throwable {
		for (Map<String, String> examples : arg1.asMaps(String.class, String.class)) {
			Assert.assertEquals(examples.get("response"), service.executeGetRequest(host + examples.get("question"))); 
		}
	}

}
