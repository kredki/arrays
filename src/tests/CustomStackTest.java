package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import datatype.CustomStack;

public class CustomStackTest {
	CustomStack<Integer> stack;
	@Before
	public void initQueue() {
		List<Integer> storage = new ArrayList<>();
		storage.add(0);
		storage.add(1);
		storage.add(2);
		storage.add(3);
		stack = new CustomStack(storage);
	}
	@Test
	public void pollTest() {
		assertEquals(3, stack.pop().intValue());
		assertEquals(2, stack.pop().intValue());
		assertEquals(1, stack.pop().intValue());
		assertEquals(0, stack.pop().intValue());
		
	}
	
	@Test
	public void isEmptyTest() {
		assertEquals(false, stack.isEmpty());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(true, stack.isEmpty());
	}
	
	@Test
	public void pushTest() {
		stack.push(10);
		assertEquals(5, stack.size());
	}
}
