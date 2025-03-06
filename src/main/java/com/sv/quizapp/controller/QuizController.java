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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.quizapp.model.QuestionWrapper;
import com.sv.quizapp.model.Quiz;
import com.sv.quizapp.model.Response;
import com.sv.quizapp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	
	QuizService quizService;
@PostMapping("/create")
	public ResponseEntity<Quiz> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title ){
	
	Quiz quiz=quizService.createQuiz(category,numQ,title);
		
	return new ResponseEntity<Quiz>(quiz,HttpStatus.OK);
	   
}
@GetMapping("/get/{id}")
public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
	List<QuestionWrapper> questions=quizService.getQuizQuestion(id);
	return new ResponseEntity<List<QuestionWrapper>>(questions,HttpStatus.OK);
	
};
@PostMapping("submit/{id}")
public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response>responses){
	Integer rightanswer=  quizService.calculateResult(id,responses);
	return new ResponseEntity<Integer>(rightanswer,HttpStatus.OK);
	
}

}
