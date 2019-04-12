package com.sb.test.refs;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import com.sb.test.refs.RefsTest.Counter;

public class RefsTest implements Runnable {

	class Counter {
		private int count;

		int getCount() {
			return count;
		}

		Counter(int count) {
			this.count = count;
		}
	}

	@Override
	public void run() {
		try {
			testWeak();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			testSoft();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			testWeakHashMap();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			testPhantom();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testWeak() {
		System.out.println("Test WeakReference");

		Counter counter = new Counter(10);

		WeakReference<Counter> weakCounter = new WeakReference<Counter>(counter);
		System.out.println("weakCounter: " + weakCounter.get().getCount() + ", " + weakCounter.isEnqueued());

		counter = null;

		System.out.println("weakCounter: " + weakCounter.get().getCount() + ", " + weakCounter.isEnqueued());

		System.gc();

		System.out.println("weakCounter: " + weakCounter.get().getCount() + ", " + weakCounter.isEnqueued());

	}

	private void testSoft() {
		System.out.println("Test SoftReference");

		Counter counter = new Counter(10);

		SoftReference<Counter> softCounter = new SoftReference<Counter>(counter);
		System.out.println("softCounter: " + softCounter.get().getCount());

		counter = null;

		System.out.println("softCounter: " + softCounter.get().getCount() + ", " + softCounter.isEnqueued());

		System.gc();

		System.out.println("softCounter: " + softCounter.get().getCount() + ", " + softCounter.isEnqueued());

		System.gc();

		System.out.println("softCounter: " + softCounter.get().getCount() + ", " + softCounter.isEnqueued());

		System.gc();

		System.out.println("softCounter: " + softCounter.get().getCount() + ", " + softCounter.isEnqueued());
	}

	private void testWeakHashMap() {
		System.out.println("Test WeakReference");

		Counter counter = new Counter(10);

		WeakHashMap<Counter, Integer> whm = new WeakHashMap<>();
		whm.put(counter, counter.getCount());

		System.out.println("weakCounter: " + whm.get(counter));

		counter = null;

		System.out.println("weakCounter: " + whm.get(counter));

		System.gc();

		System.out.println("weakCounter: " + whm.get(counter));

	}

	private void testPhantom() {
		System.out.println("Test PhantomReference");

		ReferenceQueue<Counter> refQueue = new ReferenceQueue<>(); // reference will be stored in this queue for cleanup

		Counter counter = new Counter(10);

		PhantomReference<Counter> phantomCounter = new PhantomReference<Counter>(counter, refQueue);
		System.out.println("phantomCounter: " + phantomCounter.get());

		Reference<? extends Counter> reference;
		while((reference = refQueue.poll()) != null) {
			System.out.println("1. reference: " + reference);
		}
		
		counter = null;

		System.gc();

		while((reference = refQueue.poll()) != null) {
			System.out.println("2. reference: " + reference);
		}

		System.gc();

		while((reference = refQueue.poll()) != null) {
			System.out.println("3. reference: " + reference);
		}
		System.gc();

		while((reference = refQueue.poll()) != null) {
			System.out.println("4. reference: " + reference);
		}
		System.gc();

		while((reference = refQueue.poll()) != null) {
			System.out.println("5. reference: " + reference);
		}
	}

	public static void main(String[] args) {
		RefsTest t = new RefsTest();
		t.run();
	}
}
