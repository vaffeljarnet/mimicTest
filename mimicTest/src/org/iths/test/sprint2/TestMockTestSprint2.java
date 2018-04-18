package org.iths.test.sprint2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMockTestSprint2 {

	@Test
	public void test() {
		MockTestSprint2 mock = new MockTestSprint2();
		String response = mock.sendGetRequest("localhost:8080/hej?storeRequest=då");
		System.out.println(response);
	}
	
	@Test
	public void test2() {
		MockTestSprint2 mock = new MockTestSprint2();
		String test = mock.sendGetRequest("localhost:8080/hej?storeRequest=då");
		String response = mock.sendGetRequest("localhost:8080/hej?learn");
		System.out.println(response);
	}
	
	@Test
	public void test3() {
		MockTestSprint2 mock = new MockTestSprint2();
		String test = mock.sendGetRequest("localhost:8080/1+1?storeRequest=2");
		String response = mock.sendGetRequest("localhost:8080/1+1");
		System.out.println(response);
	}

}
