package com.sv.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.quizapp.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>
{
	
}
