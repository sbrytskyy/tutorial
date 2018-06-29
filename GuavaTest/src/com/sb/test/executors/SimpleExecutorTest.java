package com.sb.test.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleExecutorTest {

	private final ExecutorService service = Executors.newFixedThreadPool(4);

	public void test() {
		Runnable command = () -> {
			String threadName = Thread.currentThread().getName();
			for (int i = 0; i < 4; i++) {
				System.out.println("service.execute(command): " + i + ", " + threadName);
			}
		};
		Runnable taskRunnable = () -> {
			String threadName = Thread.currentThread().getName();
			for (int i = 0; i < 4; i++) {
				System.out.println("service.submit(task): " + i + ", " + threadName);
			}
		};

		Callable<Boolean> taskCallable = new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				String threadName = Thread.currentThread().getName();
				for (int i = 0; i < 4; i++) {
					System.out.println("service.submit(Callable<Boolean>): " + i + ", " + threadName);
				}
				return true;
			}
		};

		service.execute(command);

		Future<?> futureRunnable = service.submit(taskRunnable);
		try {
			if (futureRunnable.get() == null) {
				System.out.println("Future<?> future = service.submit(Runnable); has been executed correctly");
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		Future<Boolean> futureCallable = service.submit(taskCallable);
		try {
			if (futureCallable.get()) {
				System.out.println(
						"Future<Boolean> futureCallable = service.submit(taskCallable); has been executed correctly");
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		service.shutdown();
	}

	public static void main(String[] args) {
		SimpleExecutorTest t = new SimpleExecutorTest();
		t.test();
	}
}
