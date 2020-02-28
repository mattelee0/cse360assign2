/**
 * Author 			: Matthew Lee
 * Class ID 		: 387
 * Assignment # 	: 2
 * Description 		: This file contains the class SimpleList.<!-- --> Further details of the SimpleList class 
 * 				  	can be found below.<!-- --> The main idea of this class is to add, remove, and manipulate
 *   			  	an array of size 10.	
 * Github Link  	: https://github.com/mattelee0/cse360assign2
 */

package cse360assign2;


/** 
* This is the SimpleList class, where users can add, remove, search, count the contents, and get the string
* of an arrays contents. 
*/
public class SimpleList {
	
	private int count; 
	private int[] list; 
	
	/** 
	    * Class constructor.<!-- --> Initialize count to 0 and list to a size 10 array. 
	    */
	public SimpleList() {
		count = 0; 
		list = new int[10]; 
	}
	
	
	/** 
	    * Get method to return the current array (list).<!-- --> 
	    * Used for testing purposes, returns the current array. 
	    */
	public int[] getList() {
		return list; 
	}
	
	
	/** 
	    * This method will add the parameter integer to the front of the list.<!-- -->
	    * By adding to the front it will push all other numbers back in the list.<!-- -->
	    * Parameter for this method is the integer that will be added to the front.<!-- -->
	    * Note: if the list is initially full, the size will be increased by 50% 
	    */
	public void add(int addToFront) {
		
		int size = list.length; 
		if(list[size-1] != 0) {
			int newSize = (int) Math.floor(1.5 * size); 
			int[] newList = new int[newSize]; 
			for(int index = 0; index < size-1; index++) {
				newList[index] = list[index]; 
			}
			list = newList; 
		}
		
		int newSize = list.length-1;
		for(int index = newSize; index > 0; index--) {
			if(list[index-1] != 0) {
				list[index] = list[index-1]; 	
			}
		}
		
		list[0] = addToFront; 
		count++; 
	}
	
	
	/** 
	    * This method will remove the parameter integer in any index of the list.<!-- -->
	    * By removing the integer, all other contents will be pulled forward.<!-- -->
	    * Parameter for this method is the integer that is to be removed at any location in array.<!-- -->
	    * Note: if the list is 25% empty then the size of the list will decrease by 25%. 
	    */
	public void remove(int removeIfFound) {
		for(int index = 0; index < 10; index++) {			//first loop will check entire array for input int
			if(list[index] == removeIfFound) {				//second loop will adjust position of following ints
				for(int secondIndex = index; secondIndex < 9; secondIndex++) {	
					list[secondIndex] = list[secondIndex+1]; 
				}
				list[9] = 0; 								//if there is a removal, the final position will always be 0
				count--; 
			}
		}
		
		int size = list.length; 
		int quarter = (int) Math.floor(list.length / 4); 
		
		if(list[size-quarter-1] == 0 && size != 1) {
			int[] tempList = new int[size-quarter]; 
			for(int index = 0; index < size-quarter; index++) {
				tempList[index] = list[index]; 
			}
			list = tempList; 
		}
		
		
	}
	
	
	/** 
	    * This method will return the count, or number of elements in the list.
	    */
	public int count() {
		return count; 
	}
	
	
	/** 
	    * This method will convert the current array (list) into a string that is space delimited.<!-- -->
	    * The string that is constructed out of the array will be returned. 
	    */
	public String toString() {
		String finalString = ""; 
		String tempString; 
		int index = 0; 
		
		while(index != 10 && list[index] != 0) {
			tempString = Integer.toString(list[index]); 
			tempString = tempString + " "; 
			finalString = finalString + tempString; 		//form of concatenating running list and current int
			
			index++; 
		}
		
		return finalString.trim(); 
	}
	
	
	/** 
	    * This method will search for the given integer and return the location of this integer.<!-- -->
	    * If the integer cannot be found, -1 will be returned.<!-- -->
	    * The index of the found variable will be returned, unless unfound. 
	    */
	public int search(int location) {
		int searchVar = -1; 
		
		for(int index = 0; index < 10; index++) {
			if(list[index] == location) {
				searchVar = index; 
			}
		}
		return searchVar; 
	}
	
	/** 
	    * Rather then add to the front of the list, this method will append to the back.<!-- --> 
	    * Note: if the list is initially full, the list will increase in size by 50%. 
	    */
	public void append(int value) {
		int size = list.length; 
		int position = 0; 
		
		if(list[size-1] != 0) {
			int newSize = (int) Math.floor(1.5 * size); 
			int[] newList = new int[newSize]; 
			for(int index = 0; index < newSize; index++) {
				newList[index] = list[index]; 
			}
			list = newList; 
		}
		
		for(int index = 0; index < size; index++) {
			if(list[index] != 0) {
				position++; 
			}
		}
		
		list[position] = value; 
		
	}
	
	/** 
	    * This method will return the value of the first element in the list.<!-- --> 
	    * Note: if there are no elements in the list, then -1 will be returned 
	    */
	public int first() {
		if(list[0] == 0) {
			return -1; 
		}
		
		return list[0]; 
	}
	
	/** 
	    * This method will return the value of the last element in the list.<!-- --> 
	    * Note: if there are no elements in the list, then -1 will be returned 
	    */
	public int last() {
		if(list[0] == 0) {
			return -1; 
		}
		
		int size = list.length; 
		int position = 0; 
		for(int index = 0; index < size; index++) {
			if(list[index] != 0) {
				position++; 
			}
		}
		
		return list[position-1]; 
	}
	
	/** 
	    * Method to attain the current size of the array (list).<!-- --> 
	    * This will return the complete size, not just the filled elements. 
	    */
	public int size() {
		int size = list.length; 
		return size; 
	}
}
