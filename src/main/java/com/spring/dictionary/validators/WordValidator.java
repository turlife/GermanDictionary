package com.spring.dictionary.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.dictionary.models.Word;
import com.spring.dictionary.services.WordService;

@Component
public class WordValidator implements Validator{

	@Autowired
	private WordService wordService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		Word word = (Word) target;
		
		if (wordService.isEngAndGerWordExist(word)){
			errors.rejectValue("word_de", "uploadForm.selectFile", "The word exists in dictionary");
		}
		
	}
	
	
	
}
