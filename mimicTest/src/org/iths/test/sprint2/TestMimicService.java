package org.iths.test.sprint2;

import org.iths.main.HttpServiceCaller;
import org.junit.Assert;
import org.junit.Test;

public class TestMimicService {

	private final static String host="http://localhost:8080/"; 
	private HttpServiceCaller service;
	
	@Test
	public void learnResponse() {
		service = new HttpServiceCaller();
		service.executeGetRequest(host + "LearnNextResponse?text=2");
		String response = service.executeGetRequest(host + "1+1");
		Assert.assertEquals(response, "2");
	}

//	@Test
	public void unlearnResponse() {
//		help!
	}
	
//	@Test
	public void changeResponse() {
//		help!
	}
	
//	@Test
	public void closeMimic() {
		
//		this test passed
		
		service = new HttpServiceCaller();
		service.executeGetRequest(host + "KillMimic");
//		should we have an assert, what type of assert in that case?
	}
}
