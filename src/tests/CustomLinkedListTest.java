package tests;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.BeforeClass;
import org.junit.Test;

import datastructure.list.CustomArrayList;
import datastructure.list.CustomLinkedList;

public class CustomLinkedListTest {
	private static List<Integer> initList;

	@BeforeClass
	public static void InitialContext() {
		initList = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			initList.add(i);
		}
	}
	
	@Test
	public void zeroSizeTest() {
		List<Integer> list = new CustomLinkedList<>();
		assertEquals(0, list.size());
	}
	
	@Test
	public void oneSizeTest() {
		List<Integer> list = new CustomLinkedList<>();
		list.add(10);
		assertEquals(1, list.size());
	}
	
	@Test
	public void addedElementTest() {
		List<Integer> list = new CustomLinkedList<>();
		list.add(10);
		assertEquals(10, list.get(0).intValue());
	}
	
	@Test
	public void addElementInTheMiddleTest() {
		CustomLinkedList<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.add(4, 15);
		assertEquals(15, list.get(4).intValue());
		assertEquals(4, list.get(5).intValue());
		assertEquals(5, list.get(6).intValue());
		assertEquals(6, list.get(7).intValue());
		assertEquals(7, list.get(8).intValue());
		assertEquals(8, list.get(9).intValue());
		assertEquals(9, list.get(10).intValue());
	}
	
	@Test
	public void clearAndIsEmptyTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());
		list.add(2);
		assertEquals(false, list.isEmpty());
	}
	
	@Test
	public void containsTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		assertEquals(true, list.contains(5));
		assertEquals(false, list.contains(11));
		assertEquals(false, list.contains(null));
		list.add(null);
		assertEquals(true, list.contains(null));
	}
	
	@Test
	public void removeTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.remove(new Integer(5));
		assertEquals(9, list.size());
		assertEquals(6, list.get(5).intValue());
		list.remove(1);
		assertEquals(8, list.size());
		assertEquals(2, list.get(1).intValue());
		
		assertEquals(false, list.remove(new Integer(5)));
		assertEquals(8, list.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addExcptionTest() {
		List<Integer> list = new CustomLinkedList<>();
		list.add(1, 5);
	}
	
	@Test
	public void addTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.add(1, 11);
		assertEquals(11, list.size());
		assertEquals(11, list.get(1).intValue());
		assertEquals(1, list.get(2).intValue());
	}
	
	@Test
	public void containsEmptyListTest() {
		List<Integer> list = new CustomLinkedList<>();
		assertEquals(false, list.contains(10));
	}
	
	@Test
	public void containsNullTest() {
		List<Integer> list = new CustomLinkedList<>();
		list.add(null);
		assertEquals(true, list.contains(null));
	}
	
	@Test
	public void containsSizeOneListTest() {
		List<Integer> list = new CustomLinkedList<>();
		list.add(10);
		assertEquals(true, list.contains(10));
	}
	
	@Test
	public void removeLastTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.remove(new Integer(9));
		assertEquals(9, list.size());
		assertEquals(8, list.get(8).intValue());
	}
	
	@Test
	public void setTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.set(0, 20);
		assertEquals(20, list.get(0).intValue());
	}
	
	@Test
	public void set2Test() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.set(2, 20);
		assertEquals(20, list.get(2).intValue());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void setIndexOutOfBoundriesTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.set(12, 20);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void getIndexOutOfBoundriesTest() {
		List<Integer> list = new CustomLinkedList<>();
		list.get(20);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void removeIndexOutOfBoundriesTest() {
		List<Integer> list = new CustomLinkedList<>();
		list.remove(20);
	}
	
	@Test
	public void indexOfTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		assertEquals(0, list.indexOf(0));
		assertEquals(5, list.indexOf(5));
		assertEquals(9, list.indexOf(9));
	}
	
	@Test
	public void iteratorTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		Iterator<Integer> iterator = list.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(0, iterator.next().intValue());
		assertEquals(true, iterator.hasNext());
		assertEquals(1, iterator.next().intValue());
		assertEquals(true, iterator.hasNext());
		assertEquals(2, iterator.next().intValue());
		assertEquals(false, iterator.hasNext());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void emptyListIteratorTest() {
		List<Integer> list = new CustomLinkedList<>();	
		Iterator<Integer> iterator = list.iterator();
		iterator.next();
	}
	
	@Test
	public void removeIteratorTest() {
		List<Integer> list = new CustomLinkedList<>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		Iterator<Integer> iterator = list.iterator();
		iterator.next();
		iterator.remove();
		assertEquals(2, list.size());
		assertEquals(1, list.get(0).intValue());
	}
}
