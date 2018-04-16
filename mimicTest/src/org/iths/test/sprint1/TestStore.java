package org.iths.test.sprint1;

import static org.junit.Assert.*;
import org.iths.main.RequestResponse;

import org.iths.main.Store;
import org.junit.Test;

public class TestStore {
	
	@Test
	public void TestStore111ValidValues() {
		Store mock = new Store();
		mock.learnResponse("1+1", "2");
		String answer = mock.getResponse("1+1");
		assertEquals("2",answer);
	}
	
	@Test
	public void TestStore112ValidNullRequest() {
		Store mock = new Store();
		mock.learnResponse("1+1", null);
		String answer = mock.getResponse("1+1");
		assertEquals(null,answer);
	}
	
	@Test
	public void TestStore113LearnResponseWithNullRequest() {
		boolean thrown = false;
		Store mock = new Store();
		try {
		mock.learnResponse(null, "2");
		}catch(NullPointerException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	public void TestStore114NullObjectGetResponse() {
		Store mock = new Store();
		mock.learnResponse("1+1", null);
		String response = mock.getResponse("1+1");
		assertNull(response);
	}	

}
