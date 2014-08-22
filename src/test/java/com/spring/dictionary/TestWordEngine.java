package com.spring.dictionary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.dictionary.engine.WordEngine;

public class TestWordEngine {
	
	private static final Logger logger = LoggerFactory.getLogger(TestWordEngine.class);
	
	@Test
	public void testGetEnglishWord(){
		String germanWord = "abends";
		logger.debug("Word: " + WordEngine.getEnglishWord(germanWord));
	}
	
	@Test
	public void testRegex(){
		Pattern p;
		Matcher m;
		
		//String word = "Abendessen";
		//String line = "Abendessen (n)	supper";
		
		//String word = "Abends";
		//String line = "Abends	at night";
		
		String word = "Auflagen";
		String line = "Auflagen[Noun] (s)	editions";
		
		//String word = "Auflagen";
		//String line = "Auflagen[Noun]	editions";
		
		p = Pattern.compile("^(" + word.toLowerCase() + ")(\\[\\w+\\])?[\\s\\t]?(([(]{1}([a-zA-Z])[)]{1})?)\\t(.*)");
		m = p.matcher(line.toLowerCase());
		logger.debug("begin");
		while(m.find()){
			logger.debug("inside");
			logger.debug("0: " + m.group(0));
			logger.debug("1: " + m.group(1));
			logger.debug("2: " + m.group(2));
			logger.debug("3: " + m.group(3));
			logger.debug("4: " + m.group(4));
			logger.debug("5: " + m.group(5));
			logger.debug("6: " + m.group(6));
			logger.debug("end");
		}
	}
}
