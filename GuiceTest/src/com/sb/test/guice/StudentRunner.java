package com.sb.test.guice;

import java.util.Scanner;

import com.google.inject.Inject;
import com.sb.test.guice.student.Registrar;
import com.sb.test.guice.student.Student;
import com.sb.test.guice.student.StudentStore;

public class StudentRunner implements Runnable {

	private final StudentStore studentStore;
	private final Registrar registrar;

	@Inject
	StudentRunner(StudentStore studentStore, Registrar registrar) {
		this.studentStore = studentStore;
		this.registrar = registrar;
	}
	
	@Override
	public void run() {
		System.out.println("Welcome to the Registration Database App...");
		System.out.println("Person ID? ");
		Scanner scanner = new Scanner(System.in);
		Integer personId = new Integer(scanner.nextLine());
		scanner.close();

		System.out.printf("You supplied Person ID %d searching...\n", personId);

		Student s = new Student(personId, 12);
		studentStore.save(s);

		boolean status = registrar.checkStudentStatus(personId);

		if (status) {
			System.out.println("This student is currently enrolled and meets " + "the registrar's criteria");
		} else {
			System.out.println("This student does not meet the registrar's criteria");
		}
	}
}
