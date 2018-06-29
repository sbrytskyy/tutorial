package com.sb.test.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class GuavaExecutorTestClean {

	private final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(4));

	private Callable<String> taskCallable = new Callable<String>() {
		@Override
		public String call() throws Exception {
			String threadName = Thread.currentThread().getName();
			for (int i = 0; i < 4; i++) {
				System.out.println("taskCallable: " + i + ", " + threadName);
			}
			return threadName;
		}
	};

	private FutureCallback<String> futureCallback = new FutureCallback<String>() {
		@Override
		public void onSuccess(@Nullable String result) {
			if (result != null && !result.isEmpty()) {
				System.out.println("FutureCallback: taskCallable has been executed correctly. Result: " + result);
			} else {
				System.out.println("FutureCallback: taskCallable has been executed incorrectly");
			}
		}

		@Override
		public void onFailure(Throwable t) {
			System.out.println("FutureCallback: taskCallable has failed");
			t.printStackTrace();
		}
	};

	public void test() {
		ListenableFuture<String> listenableFutureCallable = service.submit(taskCallable);
		Futures.addCallback(listenableFutureCallable, futureCallback, service);
	}

	public static void main(String[] args) {
		GuavaExecutorTestClean t = new GuavaExecutorTestClean();
		t.test();
	}
}
