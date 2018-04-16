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

}
