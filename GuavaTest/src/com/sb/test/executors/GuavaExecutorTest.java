package com.sb.test.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class GuavaExecutorTest {

	private final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(4));

	public void test() {
		Runnable command = () -> {
			String threadName = Thread.currentThread().getName();
			for (int i = 0; i < 4; i++) {
				System.out.println("command: " + i + ", " + threadName);
			}
		};
		Runnable taskRunnable = () -> {
			String threadName = Thread.currentThread().getName();
			for (int i = 0; i < 4; i++) {
				System.out.println("taskRunnable: " + i + ", " + threadName);
			}
		};

		Callable<String> taskCallable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				String threadName = Thread.currentThread().getName();
				for (int i = 0; i < 4; i++) {
					System.out.println("taskCallable: " + i + ", " + threadName);
				}
				return threadName;
			}
		};

		service.execute(command);
		System.out.println("service.execute(command);");

		Future<?> futureRunnable = service.submit(taskRunnable);
		System.out.println("Future<?> futureRunnable = service.submit(taskRunnable);");
		try {
			if (futureRunnable.get() == null) {
				System.out.println("Future<?> future = service.submit(Runnable); has been executed correctly");
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		Future<String> futureCallable = service.submit(taskCallable);
		System.out.println("Future<String> futureCallable = service.submit(taskCallable);");
		try {
			String result = futureCallable.get();
			if (result != null && !result.isEmpty()) {
				System.out.println("Future<Boolean> futureCallable = service.submit(taskCallable);"
						+ " has been executed correctly");
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		ListenableFuture<String> listenableFutureCallable = service.submit(taskCallable);
		System.out.println("ListenableFuture<String> listenableFutureCallable = service.submit(taskCallable);");
		try {
			String result = listenableFutureCallable.get();
			if (result != null && !result.isEmpty()) {
				System.out.println("ListenableFuture<Boolean> listenableFutureCallable = service.submit(taskCallable);"
						+ " has been executed correctly");
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		listenableFutureCallable = service.submit(taskCallable);
		Runnable listener = new Runnable() {
			@Override
			public void run() {
				System.out.println(
						"Listener: ListenableFuture<Boolean> listenableFutureCallable = service.submit(taskCallable);"
								+ " has been executed correctly");
			}
		};
		listenableFutureCallable.addListener(listener, service);
		System.out.println("listenableFutureCallable.addListener(listener, service);");

		listenableFutureCallable = service.submit(taskCallable);
		FutureCallback<String> futureCallback = new FutureCallback<String>() {
			@Override
			public void onSuccess(@Nullable String result) {
				if (result != null && !result.isEmpty()) {
					System.out.println("FutureCallback: "
							+ "ListenableFuture<Boolean> listenableFutureCallable = service.submit(taskCallable);"
							+ " has been executed correctly");
					System.out.println("Result: " + result);
				} else {
					System.out.println("FutureCallback: "
							+ "ListenableFuture<Boolean> listenableFutureCallable = service.submit(taskCallable);"
							+ " has been executed incorrectly");
				}
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println("FutureCallback: "
						+ "ListenableFuture<Boolean> listenableFutureCallable = service.submit(taskCallable);"
						+ " has failed");
				t.printStackTrace();
			}
		};
		Futures.addCallback(listenableFutureCallable, futureCallback, service);
	}

	public static void main(String[] args) {
		GuavaExecutorTest t = new GuavaExecutorTest();
		t.test();
	}
}
