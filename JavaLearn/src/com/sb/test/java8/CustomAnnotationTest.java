package com.sb.test.java8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class CustomAnnotationTest {

	public static void main(String[] args) {
		CustomAnnotationTest t = new CustomAnnotationTest();
		t.test1();
		try {
			t.test2();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		try {
			t.test3("Hello");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		t.test4();
	}

	@CustomMethodAnnotation(level = 5)
	private void test4() {
		System.out.println("test4");
	}

	private void test3(String s) throws NoSuchMethodException, SecurityException {
		Method method = CustomAnnotationTest.class.getMethod("main", String[].class);
		for (final Parameter parameter : method.getParameters()) {
			System.out.println("Parameter: " + parameter.getName());
		}
	}

	private void test1() {
		AnnotationRunner r = new AnnotationRunner();
		r.method1();
		r.method2();
		r.method3();
		r.method4();
	}

	private void test2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		AnnotationRunner r = new AnnotationRunner();

		Method[] methods = r.getClass().getMethods();
		for (Method m : methods) {

			CustomAnnotation ca = m.getAnnotation(CustomAnnotation.class);
			if (ca != null) {
				if (ca.canRun()) {
					System.out.println(ca.author());
					m.invoke(r);
				}
			}
		}
	}
	
	
}
