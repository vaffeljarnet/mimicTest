package org.iths.test.sprint2;

import org.iths.main.HttpServiceCaller;
import org.junit.Assert;
import org.junit.Test;

public class TestMimicJar {

	private final static String host="http://localhost:8080/"; 
	private HttpServiceCaller service;
	
	@Test
	public void test() {
		service = new HttpServiceCaller();
		service.executeGetRequest(host + "LearnNextResponse?text=2");
		String response = service.executeGetRequest(host + "1+1");
		Assert.assertEquals(response, "2");
	}

}
