package org.iths.test;

import static org.junit.Assert.*;

import org.iths.main.RequestResponse;
import org.junit.Test;

public class TestRequestResponse {

	@Test
	public void ID114CreateObjectSetGet() {
		RequestResponse reqRes = new RequestResponse("1+1","2");
		assertEquals("1+1",reqRes.getRequest());
		assertEquals("2",reqRes.getResponse());
		
		reqRes.setRequest("1+2");
		reqRes.setResponse("3");
		assertEquals("1+2", reqRes.getRequest());
		assertEquals("3", reqRes.getResponse());		
	}

}
