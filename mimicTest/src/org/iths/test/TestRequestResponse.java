package org.iths.test;

import static org.junit.Assert.*;
import org.iths.main.RequestResponse;

import org.iths.main.Store;
import org.junit.Test;

public class TestRequestResponse {

	@Test
	public void test() {
		Store mock = new Store();
		mock.learnResponse("1+1", "2");
		String answer = mock.getResponse("1+1");
		assertEquals("2",answer);
	}
	
	@Test
	public void validNullRequest1() {
		Store mock = new Store();
		mock.learnResponse("1+1", null);
		String answer = mock.getResponse("1+1");
		assertEquals(null,answer);
	}
	
	@Test
	public void validNullRequest2() {
		Store mock = new Store();
		RequestResponse reqRes = null;
		mock.learnResponseWithNull("1+1", reqRes);
		String answer = mock.getResponse("1+1");
		assertEquals(null,answer);
	}
	
	@Test
	public void invalidNullRequest() {
		Store mock = new Store();
		mock.learnResponse(null, "2");
		String answer = mock.getResponse(null);
		assertEquals("2",answer);
	}

}
