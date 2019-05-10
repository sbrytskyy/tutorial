package com.sb.test.func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FuncTest {

	public static void main(String[] args) {
		FuncTest t = new FuncTest();

		Thread th = new Thread(() -> t.doTest());
		th.start();
	}

	private void doTest() {
		List<String> messages = new ArrayList<>();
		messages.add("bla-bla");

		TestBooleanFunction<String> tbf = s -> !s.isEmpty();
		test0(messages, new TestFunctionImpl(), tbf);

		test1(messages, s -> System.out.println("Hello from TestFunction: " + s), s -> !s.isEmpty());

		String str = "12345";
		Integer i = test2(str, s -> !s.isEmpty(), s -> Integer.parseInt(s));
		System.out.println("String: '" + str + "', Integer: " + i);

		test3(messages, s -> System.out.println("3: " + s), s -> !s.isEmpty());

		test4(messages, s -> System.out.println("4: " + s), s -> !s.isEmpty());

		List<String> strings = new ArrayList<>();
		strings.add(str);
		Consumer<Integer> action = s -> System.out.println("5: " + s);
		Function<String, Integer> mapper = s -> Integer.parseInt(s);
		Predicate<String> predicate = s -> !s.isEmpty();
		test5(strings.stream(), action, mapper, predicate);
		
		strings.add("98765");
		Collector<Integer, ?, Integer> collector = Collectors.summingInt(Integer::intValue);
		Integer test6 = test6(strings.stream(), mapper, predicate, collector);
		System.out.println("Test6: " + test6);
	}

	private void test0(List<String> messages, TestFunction t, TestBooleanFunction<String> verifier) {
		for (String message : messages) {
			if (verifier.verify(message)) {
				t.doSomething(message);
				t.doSomethingDefault(message);
			}
		}
	}

	private void test1(List<String> messages, TestFunction t, Predicate<String> predicate) {
		for (String message : messages) {
			TestBooleanFunction<String> verifier = s -> !s.isEmpty();
			if (verifier.verify(message) && predicate.test(message)) {
				t.doSomething(message);
				t.doSomethingDefault(message);
			}
		}
	}

	private Integer test2(String s, Predicate<String> predicate, Function<String, Integer> f) {
		if (!predicate.test(s)) {
			return null;
		}
		Integer i = f.apply(s);
		return i;
	}

	private void test3(List<String> messages, Consumer<String> consumer, Predicate<String> predicate) {
		for (String message : messages) {
			TestBooleanFunction<String> verifier = s -> !s.isEmpty();
			if (verifier.verify(message) && predicate.test(message)) {
				consumer.accept(message);
			}
		}
	}

	private <T> void test4(Iterable<T> messages, Consumer<T> consumer, Predicate<T> predicate) {
		for (T message : messages) {
			if (predicate.test(message)) {
				consumer.accept(message);
			}
		}
	}

	private <T, R> void test5(Stream<T> messages, Consumer<R> action, Function<T, R> mapper, Predicate<T> predicate) {
		messages.sorted().filter(predicate).map(mapper).forEach(action);
	}

	private <T, R> R test6(Stream<T> messages, Function<T, R> mapper, Predicate<T> predicate, Collector<R, ?, R> collector) {
		R collect = messages.sorted().filter(predicate).map(mapper).collect(collector);
		return collect;
	}
}
