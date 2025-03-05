package com.sv.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sv.quizapp.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	  List<Question> findByCategory(String category);
}
