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
import com.google.common.util.concurrent.Uninterruptibles;

public class AsyncChainTest {

	private final ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(4));

	private class RemoteUserFetcher implements Callable<User> {
		private final String userId;

		public RemoteUserFetcher(String userId) {
			this.userId = userId;
		}

		@Override
		public User call() throws Exception {
			return lookupUserRemotely(userId);
		}

		private User lookupUserRemotely(String userId) {
			System.out.println("[RemoteUserFetcher] start: " + userId);
			for (int i = 0; i < 20; i++) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
			}
			System.out.println("[RemoteUserFetcher] user found: " + userId);
			return new User(userId);
		}
	}

	private class StatsCalculator implements Callable<Stats> {
		private final User user;

		public StatsCalculator(@Nullable User user) {
			this.user = user;
		}

		@Override
		public Stats call() throws Exception {
			return computeStats(user);
		}

		private Stats computeStats(User user) {
			System.out.println("[StatsCalculator] start: " + user);
			for (int i = 0; i < 30; i++) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
			}
			System.out.println("[StatsCalculator] calculated stats for: " + user);
			return new Stats();
		}
	}

	AsyncFunction<User, Stats> userToStats = new AsyncFunction<User, Stats>() {
		@Override
		public ListenableFuture<Stats> apply(@Nullable User user) throws Exception {
			return executor.submit(new StatsCalculator(user));
		}
	};

	private class StatsProcessor implements FutureCallback<Stats> {
		@Override
		public void onSuccess(@Nullable Stats result) {
			System.out.println("[StatsProcessor] SUCCESS: " + result);
		}

		@Override
		public void onFailure(Throwable t) {
			System.out.println("[StatsProcessor] FAILURE");
		}
	};

	public void test() {
		System.out.println("Start test");

		ListenableFuture<User> userFuture = executor.submit(new RemoteUserFetcher("user0001"));

		ListenableFuture<Stats> statsFuture = Futures.transformAsync(userFuture, userToStats, executor);

		Futures.addCallback(statsFuture, new StatsProcessor(), executor);

		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}

	public static void main(String[] args) {
		AsyncChainTest t = new AsyncChainTest();
		t.test();
	}
}
