package com.sb.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Host {

	private final List<Integer> doors = new ArrayList<>();

	private final Random r = new Random();

	private final Integer car;

	public Host() {
		doors.add(1);
		doors.add(2);
		doors.add(3);

		car = r.nextInt(3) + 1;
		doors.remove(car);
	}

	public void guess1(Integer guess1) {
		doors.remove(guess1);
	}

	public Integer reveal() {
		int index = r.nextInt(doors.size());
		Integer reveal = doors.remove(index);
		return reveal;
	}

	public boolean guess2(Integer guess2) {
		return guess2 == car;
	}

	/*------------------- DEBUG ----------------------------*/
	int getCar() {
		return car;
	}

	void print() {
		System.out.println(car + " : " + doors);
	}
}
