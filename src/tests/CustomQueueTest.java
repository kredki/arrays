package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import datastructure.list.CustomLinkedList;
import datatype.CustomQueue;

public class CustomQueueTest {
	CustomQueue<Integer> queue;
	
	@Before
	public void initQueue() {
		//List<Integer> storage = new ArrayList<>();
		List<Integer> storage = new CustomLinkedList<>();
		storage.add(0);
		storage.add(1);
		storage.add(2);
		storage.add(3);
		queue = new CustomQueue<>(storage);
	}
	
	@Test
	public void pollandpeekTest() {
		assertEquals(0, queue.peek().intValue());
		assertEquals(0, queue.poll().intValue());
		assertEquals(1, queue.peek().intValue());
		assertEquals(1, queue.poll().intValue());
		assertEquals(2, queue.peek().intValue());
		assertEquals(2, queue.poll().intValue());
		assertEquals(3, queue.peek().intValue());
		assertEquals(3 ,queue.poll().intValue());
		assertEquals(null, queue.peek());
		assertEquals(null ,queue.poll());
		
	}
	
	@Test
	public void pollTest() {
		assertEquals(0, queue.poll().intValue());
		assertEquals(1, queue.poll().intValue());
		assertEquals(2, queue.poll().intValue());
		assertEquals(3, queue.poll().intValue());
		
	}
	
	@Test
	public void isEmptyTest() {
		assertEquals(false, queue.isEmpty());
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		assertEquals(true, queue.isEmpty());
	}
	
	@Test
	public void peekTest() {
		assertEquals(0, queue.peek().intValue());
		assertEquals(4, queue.size());
	}
	@Test
	public void addTest() {
		queue.add(10);
		assertEquals(5, queue.size());
	}
}
