package com.spring.dictionary.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dictionary.models.Word;
import com.spring.dictionary.services.WordService;

public class App {
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		logger.debug("load context");
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp//WEB-INF/spring/appServlet/servlet-context.xml");
		
		Word word = new Word();
		
		word.setWord_de("Vater");
		word.setWord_eng("Father");
		WordService wordService = (WordService) context.getBean("wordService");
		wordService.persistWord(word);
		//logger.debug("Find word :" + wordService.findEmployeeById("123").getAge());		
		//word.setAge(32);
		//emService.updateEmployee(word);
		//System.out.println("Updated age :" + emService.findEmployeeById("123").getAge());
		//emService.deleteEmployee(word);*/
		context.close();
	}
}
