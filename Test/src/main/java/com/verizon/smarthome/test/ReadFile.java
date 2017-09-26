package com.verizon.smarthome.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFile {

	private static void readFile() throws IOException {
		try (final FileInputStream fis = new FileInputStream("/Users/brytsse/temp/test.txt");
				FileChannel fc = fis.getChannel();) {

			ByteBuffer buffer = ByteBuffer.allocate((int) fc.size());
			int bytesRead = fc.read(buffer);

			System.out.println("Bytes read: " + bytesRead);
			System.out.println(new String(buffer.array()));
		}
	}

	public static void main(String[] args) throws IOException {
		readFile();
	}
}
