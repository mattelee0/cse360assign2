/**
 * Author 		: Matthew Lee
 * Class ID 		: 387
 * Assignment # 	: 1
 * Description 	: This file contains the class SimpleList.<!-- --> Further details of the SimpleList class 
 * 				  can be found below.<!-- --> The main idea of this class is to add, remove, and manipulate
 *   			  an array of size 10.	
 */

package cse360assign2;


/** 
* This is the SimpleList class, where users can add, remove, search, count the contents, and get the string
* of an arrays contents. 
*/
public class SimpleList {
	
	private int count; 
	private int[] list; 
	
	public int temp = 0; 	// TEMPORARY VARIABLE TO TEST GITHUB
	
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
	    * Parameter for this method is the integer that will be added to the front. 
	    */
	public void add(int addToFront) {
		for(int index = 9; index > 0; index--) {
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
	    * Parameter for this method is the integer that is to be removed at any location in array. 
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
}
