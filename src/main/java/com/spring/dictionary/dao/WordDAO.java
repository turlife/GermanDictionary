package com.spring.dictionary.dao;

import java.util.List;

import com.spring.dictionary.models.Word;

public interface WordDAO {
	
	void persistWord(Word word);
	
	Word findWordById(int id);
	
	void updateWord(Word word);
	
	void deleteWord(Word word);
	
	public List<Word> getWords();
}
