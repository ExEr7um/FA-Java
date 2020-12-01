package com.exer7um.repository;

import com.exer7um.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> FindByQuestion(Long questionId);
}
