package com.spring.dictionary.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordEngine {
	private static final Logger logger = LoggerFactory.getLogger(WordEngine.class);
	
	public static String getEnglishWord(String germanWord){
		logger.debug("getEnglishWord from word: " + germanWord);
		
		String engWord = getGermanDict(germanWord);
		
		return engWord;
	}
	
	private static String getGermanDict(String germanWord) {
		String sCurrentLine = null;
		BufferedReader br = null;
		
		Pattern p = Pattern.compile("^(" + germanWord.toLowerCase() + ")");
		
		try {

			br = new BufferedReader(new InputStreamReader(
					WordEngineConverter.class.getResourceAsStream("/dict_ger_eng.txt"), "ISO-8859-1"));

			while ((sCurrentLine = br.readLine()) != null) {
				Matcher m = p.matcher(sCurrentLine.toLowerCase());
				while(m.find()){
					logger.debug("line: " + sCurrentLine + " and german: " + germanWord);
					String[] tabs = sCurrentLine.split("\t");
					return tabs[1];
				}
			}
			
		} catch (IOException e) {
			logger.error("Error", e);
		} finally{
			try {
				br.close();
			} catch (IOException e) {
				logger.error("Error", e);
			}
		}
		return sCurrentLine;
	}
}
