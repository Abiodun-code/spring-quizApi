package com.abioduncode.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abioduncode.quizapp.dao.QuestionDao;
import com.abioduncode.quizapp.model.Question;

@Service
public class QuestionService {

  @Autowired
  private QuestionDao questionDao;

  public QuestionService(QuestionDao questionDao){
    this.questionDao = questionDao;
  }
  
  public List<Question> getAllQuestion(){
    return questionDao.findAll();
  }

  public List<Question> getQuestionByCategory(String category){
    return questionDao.findByCategory(category);
  }

  public Optional<Question> getQuestionById(Integer id){
    return questionDao.findById(id);
  }

  public String addQuestion(Question question){
    questionDao.save(question);
    return "Successfull";
  }
}
