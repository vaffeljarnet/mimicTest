package org.iths.test.sprint2;

import static org.junit.Assert.fail;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.iths.main.HttpServiceCaller;
import org.junit.Assert;
import org.junit.Test;

public class TestMimicService {

	private final static String host="http://localhost:8080/"; 
	private HttpServiceCaller service;
	private MimicJarHelper helper = new MimicJarHelper(); 
	private String responseForm = "Paste or type json, xml, html or text response to learn and press Learn<br><br><form action=\"learn\" method=\"post\"><textarea name='text' rows='30' cols='150'></textarea><br><br><input type=\"submit\" id='learn' value=\"Learn\"></form>";
	private String error = "Please start mimic.jar manually before running tests again. Location: \\commonFiles\\runnableJars\\releaseSprint2\\mimic.jar";
	/**
	 * Learns Mimic a response and checks that it stores it when asking
	 * the question again.
	 */
	@Test
	public void TestMimicService111learnResponse() {
		if(helper.jarRunning()) {
		service = new HttpServiceCaller();
		service.executeGetRequest(host + "LearnNextResponse?text=2");
		service.executeGetRequest(host + "1+1"); 
		Assert.assertEquals("2", service.executeGetRequest(host + "1+1"));		
		helper.resetMimic();
		}else {
			fail(error);
		}
	}
	/**
	 * Learns Mimic a response, unlearns it and than checks that the
	 * same question provides the response form.
	 */
	@Test
	public void TestMimicService112unlearnResponse() {
		if(helper.jarRunning()) {
		service = new HttpServiceCaller();
		service.executeGetRequest(host + "LearnNextResponse?text=4");
		service.executeGetRequest(host + "2+2");
		service.executeGetRequest(host +"unlearn");
		Assert.assertEquals(responseForm, service.executeGetRequest(host+"2+2"));
		helper.resetMimic();
		}else {
			fail(error);
		}
	}
	
	/**
	 * Stores three requests in Mimic, unlearns the second one
	 * and checks that the same request provides the response form,
	 * and the remaining request still give the correct response.
	 */
	@Test
	public void TestMimicService113unlearnSpecificResponse() {
		if(helper.jarRunning()) {
		service = new HttpServiceCaller();
		
		//Store request #1
		service.executeGetRequest(host + "LearnNextResponse?text=2");
		String response = service.executeGetRequest(host + "1+1");
		Assert.assertEquals("2", response);
		
		//Store request #2
		service.executeGetRequest(host + "LearnNextResponse?text=4");
		response = service.executeGetRequest(host + "2+2");
		Assert.assertEquals("4", response);
		
		//Store request #3
		service.executeGetRequest(host + "LearnNextResponse?text=6");
		response = service.executeGetRequest(host + "3+3");
		Assert.assertEquals("6", response);
		
		//Unlearn request #2
		service.executeGetRequest(host + "2+2");
		service.executeGetRequest(host +"unlearn");
		
		//Check that request #2 is unlearned, and request #1 and #3 still give the correct response
		Assert.assertEquals(responseForm, service.executeGetRequest(host+"2+2"));
		Assert.assertEquals("2", service.executeGetRequest(host+"1+1"));
		Assert.assertEquals("6", service.executeGetRequest(host+"3+3"));
		
		helper.resetMimic();
		}else {
			fail(error);
		}
	}
	
	
	/**
	 * Stores a request with the wrong request, corrects it and
	 * check that the new response has been stored for the same
	 * question.
	 */
	@Test
	public void TestMimicService114changeResponse() {
		if(helper.jarRunning()) {
		service = new HttpServiceCaller();
		
		//Store a request with wrong answer
		service.executeGetRequest(host + "LearnNextResponse?text=5");
		service.executeGetRequest(host + "2+2");
		
		//Correct the response for the same request
		service.executeGetRequest(host + "LearnNextResponse?text=4");
		service.executeGetRequest(host + "2+2");
		
		//Check that the request is giving the correct response
		Assert.assertEquals("4", service.executeGetRequest(host + "2+2"));
		
		helper.resetMimic();
		}else {
			fail(error);
		}
		
	}
	
	/**
	 * Terminates the Mimic service and checks that it isn't
	 * active.
	 */
	@Test
	public void TestMimicService115closeMimic() {
		if(helper.jarRunning()) {
		service = new HttpServiceCaller();
		service.executeGetRequest(host+"KillMimic");
		Assert.assertEquals("Error",service.executeGetRequest(host));
		helper.resetMimic();
		}else {
			fail(error);
		}
		
		
	}
	
}
