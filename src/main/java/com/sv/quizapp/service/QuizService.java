package com.sv.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sv.quizapp.model.Question;
import com.sv.quizapp.model.QuestionWrapper;
import com.sv.quizapp.model.Quiz;
import com.sv.quizapp.model.Response;
import com.sv.quizapp.repository.QuestionRepository;
import com.sv.quizapp.repository.QuizDao;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired

	QuestionRepository questionRepo;

	public Quiz createQuiz(String category, int numQ, String title) {
		List<Question> questions = questionRepo.findRandomQuestionByCategory(category, numQ);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return quiz;

	}

	public List<QuestionWrapper> getQuizQuestion(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);

		List<Question> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList();
		for (Question q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionsForUser.add(qw);
		}
		return questionsForUser;

	}

	public Integer calculateResult(Integer id, List<Response> responses) {
		Quiz quiz=quizDao.findById(id).get();
		List<Question>questions=quiz.getQuestions();
		int right=0;
		int i=0;
		for(Response response:responses) {
			
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
				
			}
			i++;
			
		}
		return right;
	}

}
