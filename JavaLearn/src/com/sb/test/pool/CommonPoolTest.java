package com.sb.test.pool;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class CommonPoolTest {

	public static void main(String[] args) {
		CommonPoolTest t = new CommonPoolTest();
		try {
			t.test();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void test() throws IOException {
		ReaderUtil readerUtil = new ReaderUtil(new GenericObjectPool<StringBuffer>(new StringBufferFactory()));
		readerUtil.readToString(new InputStreamReader(System.in));
	}
}
