package com.spring.dictionary.engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordEngineConverter {

	public static void main(String[] args) {
		delete("dict2.txt");
		useIO();
	}

	public static void useIO() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				WordEngineConverter.class.getResourceAsStream("/dict_eng_ger.txt"), "ISO-8859-1"))) {

			String sCurrentLine;

			StringBuffer sb = new StringBuffer();
			
			List<String> lineList = new ArrayList<>();
			
			while ((sCurrentLine = br.readLine()) != null) {
				String line = new String();
				String[] tabs = sCurrentLine.split("\t");
				// System.out.println(tabs[1].trim() + " \t" + tabs[0].trim()); 
				line = tabs[1].trim() + "\t" + tabs[0].trim();
				lineList.add(line);
				Collections.sort(lineList);
			}
			
			for(String line : lineList){
				sb.append(line).append(System.lineSeparator());
			}
			write(sb);
			System.out.println("Ready");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(String path){
		File file = new File(path);
		if(file.exists()) {
			System.out.println("delete file");
			file.delete();
		}
	}

	public static void write(StringBuffer line) {
		try {
			File file = new File("dict2.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(
					new java.io.OutputStreamWriter(
							new java.io.FileOutputStream(file.getAbsoluteFile()),
							"ISO-8859-1"));
			bw.write(line.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void useNIO() {
		URL url = null;
		File file = null;
		FileInputStream input = null;
		FileChannel fChan = null;
		ByteBuffer bBuf = null;
		try {
			url = WordEngineConverter.class.getClassLoader().getResource("dict.txt");

			file = new File(url.toURI());

			input = new FileInputStream(file);

			fChan = input.getChannel();

			int size = (int) fChan.size();

			bBuf = ByteBuffer.allocate(size);

			fChan.read(bBuf);

			bBuf.rewind();

			for (int i = 0; i < size; i++) {
				System.out.println(bBuf.getChar());
				System.out.println();
			}

			fChan.close();
			input.close();

		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
	}
}
