package com.sb.test.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class AsyncFunctionTest {

	private final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(4));

	private final class SomeInfoFetcher implements Callable<String> {

		private Integer command;

		SomeInfoFetcher(Integer command) {
			this.command = command;
		}

		@Override
		public String call() throws Exception {
			System.out.println("SomeInfoFetcher: input " + command);
			String threadName = Thread.currentThread().getName();
			for (int i = 0; i < 20; i++) {
				Thread.sleep(100);
			}
			return threadName;
		}
	}

	private AsyncFunction<Integer, String> retrieveInfo = new AsyncFunction<Integer, String>() {
		@Override
		public ListenableFuture<String> apply(@Nullable Integer input) throws Exception {
			return service.submit(new SomeInfoFetcher(input));
		}
	};

	private FutureCallback<String> resultHandler = new FutureCallback<String>() {
		@Override
		public void onSuccess(@Nullable String result) {
			if (result != null && !result.isEmpty()) {
				System.out.println("ResultHandler: task has been executed correctly. Result: " + result);
			} else {
				System.out.println("ResultHandler: task has been executed incorrectly");
			}
		}

		@Override
		public void onFailure(Throwable t) {
			System.out.println("FutureCallback: task has failed");
			t.printStackTrace();
		}
	};

	public void test() {
		System.out.println("Start test");
		try {
			Futures.addCallback(retrieveInfo.apply(1), resultHandler, service);
			System.out.println("Waiting for result");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			service.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		service.shutdown();
	}

	public static void main(String[] args) {
		AsyncFunctionTest t = new AsyncFunctionTest();
		t.test();
	}
}
