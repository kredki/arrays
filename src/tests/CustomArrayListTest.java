package tests;

import static org.junit.Assert.*;
import java.util.List;

import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import datastructure.list.CustomArrayList;

public class CustomArrayListTest {

	private static List<Integer> initList;

	@BeforeClass
	public static void InitialContext() {
		initList = new CustomArrayList<>();
		for (int i = 0; i < 10; i++) {
			initList.add(i);
		}
	}

	@Test
	public void zeroSizeTest() {
		List<Integer> list = new CustomArrayList<>();
		assertEquals(0, list.size());
	}

	@Test
	public void oneSizeTest() {
		List<Integer> list = new CustomArrayList<>();
		list.add(10);
		assertEquals(1, list.size());
	}

	@Test
	public void addedElementTest() {
		List<Integer> list = new CustomArrayList<>();
		list.add(10);
		assertEquals(10, list.get(0).intValue());
	}

	@Test
	public void oversizeTest() {
		CustomArrayList<Integer> list = new CustomArrayList<>();
		for (int i = 0; i < 91; i++) {
			list.add(1);
		}
		assertEquals(100, list.getAllocatedSize());
	}

	@Test
	public void addElementInTheMiddleTest() {
		CustomArrayList<Integer> list = new CustomArrayList<>();
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
		List<Integer> list = new CustomArrayList<>();
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
		List<Integer> list = new CustomArrayList<>();
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
		List<Integer> list = new CustomArrayList<>();
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
		List<Integer> list = new CustomArrayList<>();
		list.add(1, 5);
	}
	
	@Test
	public void addTest() {
		List<Integer> list = new CustomArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.add(1, 11);
		assertEquals(11, list.size());
		assertEquals(11, list.get(1).intValue());
		assertEquals(1, list.get(2).intValue());
	}
}
