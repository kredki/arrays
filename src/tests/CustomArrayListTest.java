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
		for(int i = 0; i < 10; i++) {
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
		for(int i = 0; i < 91; i++) {
			list.add(1);
		}
		assertEquals(100, list.getAllocatedSize());
	}
	
	@Test
	public void addElementInTheMiddleTest() {
		CustomArrayList<Integer> list = new CustomArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.add(4, 15);
		assertEquals(15, list.get(4).intValue());
		assertEquals(5, list.get(5).intValue());
		assertEquals(6, list.get(6).intValue());
		assertEquals(7, list.get(7).intValue());
		assertEquals(8, list.get(8).intValue());
		assertEquals(9, list.get(9).intValue());
	}
}
