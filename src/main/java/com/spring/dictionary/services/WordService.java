package com.spring.dictionary.services;

import java.util.List;

import com.spring.dictionary.models.Word;

public interface WordService {
	
	void persistWord(Word word);
	
	Word findWordById(int id);
	
	void updateWord(Word word);
	
	void deleteWord(Word word);
	
	List<Word> getWords();
}
