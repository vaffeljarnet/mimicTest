package org.iths.test.sprint1;

import static org.junit.Assert.*;
import org.iths.main.RequestResponse;

import org.iths.main.Store;
import org.junit.Test;

public class TestStore {
	//TODO Add test case ID
	
	@Test
	public void ID111ValidValues() {
		Store mock = new Store();
		mock.learnResponse("1+1", "2");
		String answer = mock.getResponse("1+1");
		assertEquals("2",answer);
	}
	
	@Test
	public void ID112ValidNullRequest() {
		Store mock = new Store();
		mock.learnResponse("1+1", null);
		String answer = mock.getResponse("1+1");
		assertEquals(null,answer);
	}
	
	@Test
	public void ID113InvalidNullRequest() {
		Store mock = new Store();
		mock.learnResponse(null, "2");
		String answer = mock.getResponse(null);
		assertEquals("2",answer);
	}
	
	

}
