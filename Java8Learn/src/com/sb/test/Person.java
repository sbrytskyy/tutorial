package com.sb.test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	public Person(String name, Date birthday, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	private String name;
	private Date birthday;
	private Sex gender;
	private String emailAddress;

	public String getName() {
		return name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public int getAge() {
		int current = Calendar.getInstance().get(Calendar.YEAR);
		int bd = birthday.getYear();
		return current - bd;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public void printPerson() {
		System.out.println(this.toString());
	}

	public static void printPersons(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper,
			Consumer<String> action) {
		roster.stream().filter(tester).map(mapper).forEach(action);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", emailAddress="
				+ emailAddress + ", age= " + getAge() + "]";
	}
}
