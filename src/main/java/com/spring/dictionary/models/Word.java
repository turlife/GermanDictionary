package com.spring.dictionary.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Word implements Comparable<Word>{
	
	@Id
    @GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "Required field")
	private String word_de;
	
	@Size(min = 1, message = "Required field")
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
	
	@Override
	public int compareTo(Word o) {
		if ((this.getWord_de()).equals(o.getWord_de()))
            return 0;
        else if (this.getWord_de().compareTo(o.word_de) > 0)
            return 1;
        else
            return -1;
	}
	
	
	
	
}
