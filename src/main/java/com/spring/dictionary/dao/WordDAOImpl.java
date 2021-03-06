package com.spring.dictionary.dao;

import java.util.List;

import org.hibernate.Query;

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
		logger.debug("select all words");
		return sessionFactory.getCurrentSession().createQuery("from Word").list();
	}
	
	
	public void deleteWordById(int id){
		logger.debug("delete word with id " + id);
		sessionFactory.getCurrentSession().delete(findWordById(id));
	}
	
	public boolean isEngAndGerWordExist(Word word){
		logger.debug("isEngAndGerWordExist");
		Query query = sessionFactory.getCurrentSession().getNamedQuery("findWordByEngAndGer");
		query.setString("word_eng", word.getWord_eng());
		query.setString("word_de", word.getWord_de());
		List<?> list = query.list();
		if(list != null && list.isEmpty()){
			logger.debug("no entry with this params");
			return false;
		}
		return true;
	}
	
}
