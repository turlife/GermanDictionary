package com.spring.dictionary.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dictionary.models.Word;

@Repository("wordDAO")
public class WordDAOImpl implements WordDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(WordDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistWord(Word word) {
		logger.debug("save word " + word.getWord_eng());
		sessionFactory.getCurrentSession().persist(word);
	}

	@Override
	public Word findWordById(int id) {
		logger.debug("find word with id: " + id);
		return (Word) sessionFactory.getCurrentSession().get(Word.class, id);
	}

	@Override
	public void updateWord(Word word) {
		logger.debug("update word " + word.getWord_eng());
		sessionFactory.getCurrentSession().update(word);
	}

	@Override
	public void deleteWord(Word word) {
		logger.debug("delete word " + word.getWord_eng());
		sessionFactory.getCurrentSession().delete(word);
	}
	
	@SuppressWarnings("unchecked")
	public List<Word> getWords() {
		return sessionFactory.getCurrentSession().createQuery("from Word").list();
	}
	
}
