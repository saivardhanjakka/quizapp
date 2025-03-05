package com.sv.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.quizapp.model.Question;
import com.sv.quizapp.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;

	public Question addQuestion(Question question) {
		Question questionSaved = questionRepository.save(question);
		return questionSaved;
	}
	
	public List<Question> getAllQuestions() {
		List<Question> questions = questionRepository.findAll();
		System.out.println("questions in service" + questions);
		return questions;

	}
	public List<Question> getCategoryQuestions(String category) {
	    List<Question> questionsCategory = questionRepository.findByCategory(category);
	    
	    if (questionsCategory.isEmpty()) {
	        throw new RuntimeException("Questions not found for category: " + category);
	    }

	    return questionsCategory;
	}

	

}
