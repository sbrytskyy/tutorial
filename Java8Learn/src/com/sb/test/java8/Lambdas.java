package com.sb.test.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lambdas {
	
	public static void main(String[] args) {
		Lambdas l = new Lambdas();
		//l.test1();
		
		//l.test2();
		
		l.test3();
		
		l.test4();
	}

	private void test4() {
		Map<String, Integer> nameMap = new HashMap<>();
		String key = "John";
		nameMap.put(key, 6);
		Integer value = nameMap.computeIfAbsent(key, s -> s.length());
		System.out.println(value);
		}

	private void test3() {
		List<String> l = Arrays.asList("1", "2", "3");
		for(String s: l) {
			method(s, (str) -> System.out.println(str));
		}
	}
	
	private void method(String s, ICustomFunct func) {
		func.doSmth(s);
	}

	interface ISomething {
		void doSmth(String s);
		
		static void doSmthStatic(String s) {
			System.out.println("static: " + s);
		}
		
		default void doSmthDef(String s) {
			System.out.println("default: " + s);
		}
	}
	
	private void test2() {
		ISomething smth = new ISomething() {

			@Override
			public void doSmth(String s) {
				System.out.println("Override: " + s);
			}
		};
		
		String s = "Hello!";
		smth.doSmth(s);
		smth.doSmthDef(s);
		ISomething.doSmthStatic(s);
	}

	private void test1() {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
			}
		});
		t.start();

		System.out.println("Start");
	}

}
