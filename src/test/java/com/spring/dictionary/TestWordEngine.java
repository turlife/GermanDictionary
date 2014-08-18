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
		
		String word = "Abends";
		String line = "Abends	evening"; 
		
		p = Pattern.compile("^(" + word.toLowerCase() + ")");
		m = p.matcher(line.toLowerCase());
		logger.debug("begin");
		while(m.find()){
			logger.debug("true");
		}
	}
}
