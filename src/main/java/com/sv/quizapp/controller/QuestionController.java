package com.sv.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.quizapp.model.Question;
import com.sv.quizapp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired

	QuestionService questionService;

	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		List<Question> questions = questionService.getAllQuestions();
		System.out.println("questions"+questions);
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);

	}
	@GetMapping("/categoryQuestions/{category}")
	public ResponseEntity<List<Question>> getCategoryQuestions(@PathVariable("category") String category) {
		List<Question> CategoryQuestions = questionService.getCategoryQuestions(category);
		System.out.println("questions"+CategoryQuestions);
		return new ResponseEntity<List<Question>>(CategoryQuestions, HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		Question questionSaved = questionService.addQuestion(question);
		return new ResponseEntity<Question>(questionSaved, HttpStatus.CREATED);

	}

}
