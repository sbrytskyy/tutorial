package com.sb.test.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new SimpleModule());
		StudentRunner runner = injector.getInstance(StudentRunner.class);
		runner.run();
	}
}
