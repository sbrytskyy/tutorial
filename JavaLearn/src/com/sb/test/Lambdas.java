package com.sb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lambdas {

	public static void main(String[] args) {
		Lambdas l = new Lambdas();
		l.test1();
		
		l.test2();
	}

	private void test1() {
		List<Integer> pointList = new ArrayList<>();
		pointList.add(1);
		pointList.add(2);

		Consumer<Integer> printAsBinary = i -> System.out
				.println(String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));

		pointList.forEach(printAsBinary);

		pointList.forEach(printAsBinary());
	}

	private Consumer<Integer> printAsBinary() {
		return new Consumer<Integer>() {

			@Override
			public void accept(Integer i) {
				System.out.println(String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));
			}
		};

	}

	private void test2() {
		Employee[] employees = { new Employee("David"), new Employee("Naveen"), new Employee("Alex"),
				new Employee("Richard") };

		System.out.println("Before Sorting Names: " + Arrays.toString(employees));
		Arrays.sort(employees, Employee::nameCompare);
		System.out.println("After Sorting Names " + Arrays.toString(employees));
	}

}

class Employee {
	String name;

	Employee(String name) {
		this.name = name;
	}

	public static int nameCompare(Employee a1, Employee a2) {
		return a1.name.compareTo(a2.name);
	}

	public String toString() {
		return name;
	}
}
