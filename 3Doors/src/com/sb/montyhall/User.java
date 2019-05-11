package com.sb.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {

	private final List<Integer> doors = new ArrayList<>();

	private final Random r = new Random();

	private Integer guess1;

	public User() {
		doors.add(1);
		doors.add(2);
		doors.add(3);

		guess1 = r.nextInt(3) + 1;
		doors.remove(guess1);
	}

	public Integer guess1() {
		return guess1;
	}

	public void seeRevealedDoor(Integer reveal) {
		if (reveal < 1 || reveal > 3) {
			throw new IllegalArgumentException();
		}

		doors.remove(reveal);
	}

	public Integer guess2() {
		int index = r.nextInt(doors.size());
		Integer guess2 = doors.remove(index);
		return guess2;
	}

}
