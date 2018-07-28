package com.sb.test.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CollectionTest {

	public void test1() {
		List<String> l1 = new ArrayList<>();
		l1.add("a");
		l1.add("b");
		l1.add("c");
		l1.add("d");
		l1.add("e");
		
		List<String> l2 = new ArrayList<>();
		l2.add("a");
		l2.add("b");
		l2.add("c");
		
		System.out.println(l1.containsAll(l2));
		System.out.println(l2.containsAll(l1));
		
		System.out.println(l1.retainAll(l2));
		System.out.println(l1);
		
		
		ListIterator<String> li = l1.listIterator();
		System.out.println(li.next());
		System.out.println(li.previous());
	}
	
	public void test2() {
		List<Object> lo = new ArrayList<>();
		lo.add(new Object());
		lo.add(12345);
		lo.add(new Long(98765));
		lo.add("Some string");
		
		for (Object o : lo) {
			System.out.println(o + ":" + o.getClass());
		}
	}
	
	public static void main(String[] args) {
		CollectionTest t = new CollectionTest();
		t.test2();
	}
}
