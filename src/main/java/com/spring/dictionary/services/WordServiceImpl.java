package com.spring.dictionary.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dictionary.dao.WordDAO;
import com.spring.dictionary.models.Word;

@Service("wordService")
public class WordServiceImpl implements WordService{

	private static final Logger logger = LoggerFactory.getLogger(WordServiceImpl.class);
	
	@Autowired
	private WordDAO wordDAO;
	
	@Override
	@Transactional
	public void persistWord(Word word) {
		logger.debug("save word " + word.getWord_eng());
		wordDAO.persistWord(word);
	}

	@Override
	@Transactional
	public Word findWordById(int id) {
		logger.debug("find word with id: " + id);
		return wordDAO.findWordById(id);
	}

	@Override
	@Transactional
	public void updateWord(Word word) {
		logger.debug("update word " + word.getWord_eng());
		wordDAO.updateWord(word);
	}

	@Override
	@Transactional
	public void deleteWord(Word word) {
		logger.debug("delete word " + word.getWord_eng());
		wordDAO.deleteWord(word);
	}

	@Override
	@Transactional
	public List<Word> getWords() {
		return wordDAO.getWords();
	}
}
