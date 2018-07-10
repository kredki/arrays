package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
}
