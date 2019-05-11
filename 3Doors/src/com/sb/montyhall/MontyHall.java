package com.sb.montyhall;

import java.util.Arrays;

public class MontyHall {

	public void testHostInit() {
		System.out.println("testHostInit");
		int trials = 1000000;

		int[] cars = new int[3];
		int[] reveals = new int[3];

		for (int i = 0; i < trials; i++) {
			Host h = new Host();
			int car = h.getCar();

			assert car >= 1 && car <= 3;
			cars[car - 1]++;

			int reveal = h.reveal();
			assert reveal >= 1 && reveal <= 3;
			assert reveal != car;
			reveals[reveal - 1]++;
		}

		System.out.println(Arrays.toString(cars));
		for (int i = 0; i < 3; i++) {
			double avgCars = (double) cars[i] / trials;
			System.out.println("Cars:    " + (i + 1) + " : " + String.format("%2f", avgCars));

			double avgReveals = (double) reveals[i] / trials;
			System.out.println("Reveals: " + (i + 1) + " : " + String.format("%2f", avgReveals));
		}
	}

	public void testUserInit() {
		System.out.println("testUserInit");
		int trials = 1000000;

		int[] guesses1 = new int[3];
		int[] guesses2 = new int[3];

		for (int i = 0; i < trials; i++) {
			Host h = new Host();

			User u = new User();

			int guess1 = u.guess1();
			assert guess1 >= 1 && guess1 <= 3;
			guesses1[guess1 - 1]++;

			h.guess1(guess1);

			int reveal = h.reveal();
			assert reveal >= 1 && reveal <= 3;
			assert reveal != guess1;

			u.seeRevealedDoor(reveal);

			int guess2 = u.guess2();
			assert guess2 >= 1 && guess2 <= 3;
			guesses2[guess2 - 1]++;

			assert guess1 != guess2;
		}

		System.out.println(Arrays.toString(guesses1));
		for (int i = 0; i < 3; i++) {
			double avg1 = (double) guesses1[i] / trials;
			System.out.println("Guess 1 " + (i + 1) + " : " + String.format("%2f", avg1));

			double avg2 = (double) guesses2[i] / trials;
			System.out.println("Guess 2 " + (i + 1) + " : " + String.format("%2f", avg2));
		}
	}

	public void scenarioDoNotChangeChoice() {
		System.out.println("scenarioDoNotChangeChoice");
		int trials = 10000000;

		int success = 0;
		int failure = 0;

		for (int i = 0; i < trials; i++) {

			Host h = new Host();
			User u = new User();
			int guess1 = u.guess1();
			h.guess1(guess1);
			int reveal = h.reveal();
			u.seeRevealedDoor(reveal);
			boolean guess = h.guess2(guess1);

			if (guess) {
				success++;
			} else {
				failure++;
			}
		}

		double successAvg = (double) success / trials;
		double failureAvg = (double) failure / trials;

		System.out.println("success: " + String.format("%2f", successAvg));
		System.out.println("failure: " + String.format("%2f", failureAvg));
	}

	public void scenarioSwitchChoice() {
		System.out.println("scenarioSwitchChoice");
		int trials = 10000000;

		int success = 0;
		int failure = 0;

		for (int i = 0; i < trials; i++) {

			Host h = new Host();
			User u = new User();
			int guess1 = u.guess1();
			h.guess1(guess1);
			int reveal = h.reveal();
			u.seeRevealedDoor(reveal);
			int guess2 = u.guess2();
			boolean guess = h.guess2(guess2);

			if (guess) {
				success++;
			} else {
				failure++;
			}
		}

		double successAvg = (double) success / trials;
		double failureAvg = (double) failure / trials;

		System.out.println("success: " + String.format("%2f", successAvg));
		System.out.println("failure: " + String.format("%2f", failureAvg));
	}

	public static void main(String[] args) {
		MontyHall mh = new MontyHall();
		mh.testHostInit();
		mh.testUserInit();

		System.out.println("=========================");
		mh.scenarioDoNotChangeChoice();
		System.out.println("=========================");
		mh.scenarioSwitchChoice();
	}

}
