package com.spring.dictionary.controllers;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dictionary.models.Word;
import com.spring.dictionary.services.WordService;

@Controller
public class DictionaryController {
	
	private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);
	
	@Autowired
	private WordService wordService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(Locale locale, Model model) {
		logger.debug("in main");
		
		ModelAndView modelAndView = new ModelAndView("main");
		
		List<Word> wordList = wordService.getWords();
		 
		modelAndView.addObject("wordList", wordList);
		
		return modelAndView;		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addWord(){
		logger.debug("in add method");
		ModelAndView modelAndView = new ModelAndView("add");
		return modelAndView;	
	}
	
}
