package org.iths.test;

import static org.junit.Assert.*;

import org.iths.main.MockTest;
import org.junit.Test;

public class TestMockTest {

	@Test
	public void test() {
		MockTest mock = new MockTest();
		mock.storeQuestionAndAnswer("1+1", "2");
		String answer = mock.checkQuestion("1+1");
		assertEquals("2",answer);
	}

}
