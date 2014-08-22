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
	
	public static String[] getEnglishWord(String germanWord){
		logger.debug("getEnglishWord from word: " + germanWord);
		
		String[] engWord = getGermanDict(germanWord);
		
		return engWord;
	}
	
	private static String[] getGermanDict(String germanWord) {
		String sCurrentLine = null;
		BufferedReader br = null;
		
		//Pattern p = Pattern.compile("^(" + germanWord.toLowerCase() + ")");
		Pattern p = Pattern.compile("^(" + germanWord.toLowerCase() + ")(\\[\\w+\\])?[\\s\\t]?(([(]{1}([a-zA-Z])[)]{1})?)\\t(.*)");
		
		String[] answer = new String[2]; 
		
		try {

			br = new BufferedReader(new InputStreamReader(
					WordEngineConverter.class.getResourceAsStream("/dict_ger_eng.txt"), "ISO-8859-1"));

			while ((sCurrentLine = br.readLine()) != null) {
				Matcher m = p.matcher(sCurrentLine.toLowerCase());
				while(m.find()){
					logger.debug("line: " + sCurrentLine + " and german: " + germanWord);
					logger.debug("inside");
					logger.debug("0: " + m.group(0));
					logger.debug("1: " + m.group(1));
					logger.debug("2: " + m.group(2));
					logger.debug("3: " + m.group(3));
					logger.debug("4: " + m.group(4));
					logger.debug("5: " + m.group(5));
					logger.debug("end");

					//article's value
					if(m.group(5) != null){
						switch (m.group(5)) {
						case "m":
							answer[0] = "der";
							break;
						case "n":
							answer[0] = "das";
							break;		
						case "f":
							answer[0] = "die";
							break;
						default:
							break;
						}
					}
					
					//english word
					answer[1] = m.group(6);
					
					return answer;
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
		return null;
	}
}
