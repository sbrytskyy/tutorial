package com.sb.test.guice.student.register;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.sb.test.guice.student.Registrar;
import com.sb.test.guice.student.Student;
import com.sb.test.guice.student.StudentStore;

@Singleton
public class LenientRegistrar implements Registrar {

	private final StudentStore studentStore;

	@Inject
	public LenientRegistrar(StudentStore studentStore) {
		this.studentStore = studentStore;
	}

	public boolean checkStudentStatus(Integer studentId) {
		boolean status = false;

		Student student = studentStore.load(studentId);

		if (student != null && student.getCredits() != null) {
			status = student.getCredits() >= 10.0;
		}
		return status;

	}

	public Student registerStudent(String name, Integer credits) {
		Student s = new Student();
		s.setName(name);
		s.setCredits(credits);
		return studentStore.save(s);
	}
}
