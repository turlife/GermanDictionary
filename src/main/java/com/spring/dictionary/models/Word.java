package com.spring.dictionary.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Word {
	
	@Id
    @GeneratedValue
	private Integer id;
	
	private String word_de;
	
	private String word_eng;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWord_de() {
		return word_de;
	}
	public void setWord_de(String word_de) {
		this.word_de = word_de;
	}
	public String getWord_eng() {
		return word_eng;
	}
	public void setWord_eng(String word_eng) {
		this.word_eng = word_eng;
	}
	
	
	
	
}
