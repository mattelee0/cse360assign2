/**
    * Author 		: Matthew Lee
    * Class ID 		: 387
    * Assignment # 	: 1
    * Description 	: This file contains the class SimpleListTest.<!-- --> Further details of the SimpleListTest class 
    * 				  can be found below.<!-- --> The main idea of this class is to test the SimpleList class.
    */

package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse360assign2.SimpleList;

/** 
 * This is the SimpleListTest class, where the SimpleList class will be tested.<!-- -->
 * Each method will be tested multiple times for different variations. 
 */

class SimpleListTest {

	@Test
	public void testConstructorInitialize() {
		SimpleList test = new SimpleList(); 
		assertNotNull(test); 
	}
	
	
	@Test
	public void testIncrease50() {
		SimpleList test = new SimpleList(); 
		test.add(2);
		test.add(1);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		int size = test.size(); 
		assertEquals(10, size); 
		test.add(11);
		size = test.size(); 
		assertEquals(15, size); 
		int[] arrayTest = test.getList(); 
		assertEquals(2, arrayTest[10]);
		
	}
	
	/*
	@Test
	public void testDecrease25() {
		SimpleList test = new SimpleList(); 
		test.add(1);
		test.add(2);
		int[] arrayTest = test.getList(); 
		assertNull(arrayTest[9]); 
	}*/
	
	@Test
	public void testAppend() {
		SimpleList test = new SimpleList(); 
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(1);
		test.append(5);
		int[] arrayTest = test.getList(); 
		assertEquals(5, arrayTest[4]); 
	}
	
	@Test
	public void testFirst() {
		SimpleList test = new SimpleList(); 
		test.add(3);
		test.add(2);
		test.add(1);
		int first = test.first(); 
		assertEquals(1, first); 
	}
	
	@Test
	public void testLast() {
		SimpleList test = new SimpleList(); 
		test.add(3);
		test.add(2);
		test.add(1);
		int last = test.last(); 
		assertEquals(3, last); 
	}
	
	
	@Test
	public void testSize() {
		SimpleList test = new SimpleList(); 
		int size = test.size(); 
		assertEquals(10, size); 
	}

}
