package com.sb.test;
import java.util.ArrayList;
import java.util.Arrays;

public class EdxTest {

	private static void method1(Integer[] array) {        
	    ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
	    for (int i=0; i< array.length; i++){
	        listOfIntegers.add(array[i]);
	    }
	}
	
	
	private static void method2(String[] array){
	    for(int i = 0; i < array.length / 2; i++){
	       String temp = array[i];
	       array[i] = array[array.length - i - 1];
	       array[array.length - i - 1] = temp;
	    }
	}
	
	public static void main(String[] args) {
//		Integer[] array = {1, 2, 3, 4, 5};
//		method1(array);
		
		String[] array = {"a", "b", "c", "d", "e"};
		method2(array);
		
		System.out.println(Arrays.toString(array));
	}
}