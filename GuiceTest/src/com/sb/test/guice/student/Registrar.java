package com.sb.test.guice.student;

public interface Registrar {
	public boolean checkStudentStatus(Integer studentId);

	public Student registerStudent(String name, Integer credits);
}
