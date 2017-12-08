package com.sb.test;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

import sun.misc.Unsafe;

public class TestUnsafe {

	int j = 2;

	static Object shallowCopy(Object obj) {
		long size = sizeOf(obj);
		long start = toAddress(obj);
		long address = getUnsafe().allocateMemory(size);
		getUnsafe().copyMemory(start, address, size);
		return fromAddress(address);
	}

	private static Unsafe getUnsafe() {
		Field f;
		try {
			f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			Unsafe unsafe = (Unsafe) f.get(null);
			return unsafe;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static long sizeOf(Object object) {
		return getUnsafe().getAddress(normalize(getUnsafe().getInt(object, 4L)) + 12L);
	}

	private static long normalize(int value) {
		if (value >= 0)
			return value;
		return (~0L >>> 32) & value;
	}

	static long toAddress(Object obj) {
		Object[] array = new Object[] { obj };
		long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
		return normalize(getUnsafe().getInt(array, baseOffset));
	}

	static Object fromAddress(long address) {
		Object[] array = new Object[] { null };
		long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
		getUnsafe().putLong(array, baseOffset, address);
		return array[0];
	}

	public static void main(String[] args) {
		A o1 = new A(); // constructor
		System.out.println(o1.a()); // prints 1
		
		A o3 = null;
		try {
			o3 = (A) getUnsafe().allocateInstance(A.class);
			System.out.println(o3.a()); // prints 0
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // unsafe
		
		testURL();
	}

	private static void testURL(){
		try {
			HashSet<URL> set = new HashSet<>();
			set.add(new URL("http://google.com"));
			System.out.println(set.contains(new URL("http://google.com")));
			Thread.sleep(60000);
			System.out.println(set.contains(new URL("http://google.com")));
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// -------
class A {
	private long a; // not initialized value

	public A() {
		this.a = 1; // initialization
	}

	public long a() {
		return this.a;
	}
}
