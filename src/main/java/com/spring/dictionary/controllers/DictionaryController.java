package com.spring.dictionary.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.dictionary.engine.WordEngine;
import com.spring.dictionary.models.Word;
import com.spring.dictionary.services.WordService;
import com.spring.dictionary.validators.WordValidator;

@Controller
public class DictionaryController {
	
	private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);
	
	@Autowired
	private WordService wordService;
	
	@Autowired
	private WordValidator wordValidator;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(Locale locale, Model model) {
		logger.debug("in main");
		
		ModelAndView modelAndView = new ModelAndView("main");
		
		List<Word> wordList = wordService.getWords(); 
		
		Collections.sort(wordList);
		 
		modelAndView.addObject("wordList", wordList);
		
		return modelAndView;		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addWord(){
		logger.debug("in add method");
		ModelAndView modelAndView = new ModelAndView("add-word");
		modelAndView.addObject("word", new Word());
		
		return modelAndView;	
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addingWord(@Valid @ModelAttribute("word") Word word, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		wordValidator.validate(word, bindingResult);
			
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("add-word");
			logger.info("not valid word");
			return modelAndView;
		}
		
		logger.debug("Word was successfully added.");
		
		RedirectView redirectView = new RedirectView("main");
		redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
		modelAndView.setView(redirectView);
		
		wordService.persistWord(word);
		redirectAttributes.addFlashAttribute("message", "Word was successfully added.");
		return modelAndView;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editWord(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-word");
		Word word = wordService.findWordById(id);
		modelAndView.addObject("word", word);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editWord( @Valid @ModelAttribute("word") Word word, BindingResult bindingResult, RedirectAttributes redirectAttributes, 
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("edit-word");
			logger.info("not valid word");
			return modelAndView;
		}
		
		RedirectView redirectView = new RedirectView("../main");
		redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
		modelAndView.setView(redirectView);
		wordService.updateWord(word);
		redirectAttributes.addFlashAttribute("message", "Word was successfully edited.");
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteWord(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		RedirectView redirectView = new RedirectView("../main");
		redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
		modelAndView.setView(redirectView);
		wordService.deleteWordById(id);
		redirectAttributes.addFlashAttribute("message", "Word was successfully deleted.");
		logger.debug("in deleteWord");
		return modelAndView;
	}
	
	@RequestMapping(value = "/fillFields", method = RequestMethod.GET, produces = { "text/html; charset=UTF-8" })
	public @ResponseBody
	String checkStrength(@RequestParam String word_de) {
		logger.debug("word_de: " + word_de);
		String[] engWord = WordEngine.getEnglishWord(word_de);
		
		if(engWord != null && engWord[1] != null){
			logger.debug("return array");
			return engWord[0] + "&" + engWord[1];
		}
		
		return null;
	}
	
}
