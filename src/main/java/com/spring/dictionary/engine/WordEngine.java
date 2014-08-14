package com.spring.dictionary.engine;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WordEngine {
	public static void main(String[] args) {
		RandomAccessFile file;
		try {
			file = new RandomAccessFile("dict.txt", "rw");
			ByteBuffer buff = ByteBuffer.allocate(500);

			FileChannel inChannel = file.getChannel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
