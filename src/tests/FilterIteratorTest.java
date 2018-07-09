package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.InitialContext;
import javax.security.auth.x500.X500Principal;

import org.junit.BeforeClass;
import org.junit.Test;

import datastructure.list.FilterIterator;

public class FilterIteratorTest {
	static List<Integer> list;
	
	@BeforeClass
	public static void init() {
		list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(15);
		list.add(3);
	}
	
	@Test
	public void hasNextAndNextTest() {
		Iterator<Integer> iterator = new FilterIterator<>(list, x -> x > 5);
		assertEquals(true, iterator.hasNext());
		assertEquals(10, iterator.next().intValue());
		assertEquals(true, iterator.hasNext());
		assertEquals(15, iterator.next().intValue());
		assertEquals(false, iterator.hasNext());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void noSuchElementExceptionTest() {
		Iterator<Integer> iterator = new FilterIterator<>(list, x -> x > 15);
		iterator.next();
	}
	
	@Test
	public void removeTest() {
		List<Integer>list1 = new ArrayList<>();
		list1.add(1);
		list1.add(10);
		list1.add(15);
		list1.add(3);
		Iterator<Integer> iterator = new FilterIterator<>(list1, x -> x > 5);
		iterator.next();
		iterator.remove();
		assertEquals(1, list1.get(0).intValue());
		assertEquals(15, list1.get(1).intValue());
	}
}
