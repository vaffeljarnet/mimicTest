package org.iths.test.sprint2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMockTestSprint2 {
	
	/**
	 * Test for storing a request with response and answer directly
	 */
	@Test
	public void test() {
		MockTestSprint2 mock = new MockTestSprint2();
		String response = mock.sendGetRequest("localhost:8080/1+1?storeRequest=2");
		System.out.println(response);
	}
	
	/**
	 * Test for storing a request with the wrong answer and then relearn it.
	 */
	@Test
	public void test2() {
		MockTestSprint2 mock = new MockTestSprint2();
		String test = mock.sendGetRequest("localhost:8080/1+1?storeRequest=3");
		String response = mock.sendGetRequest("localhost:8080/hej?learn");
		System.out.println(response);
	}
	
	/**
	 * Test for storing a request and then checking that we can ask that question.
	 */
	@Test
	public void test3() {
		MockTestSprint2 mock = new MockTestSprint2();
		String test = mock.sendGetRequest("localhost:8080/1+1?storeRequest=2");
		String response = mock.sendGetRequest("localhost:8080/1+1");
		System.out.println(response);
	}

}
