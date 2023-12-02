package com.abioduncode.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  
  public ResponseEntity<List<Question>> getAllQuestion(){
    try{
      return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    }catch(Exception e){
      e.printStackTrace();
    }
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<List<Question>> getQuestionByCategory(String category){
    try{
      return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
    }catch(Exception e){
      e.printStackTrace();
    }
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<Optional<Question>> getQuestionById(Integer id){
    try{
      return new ResponseEntity<>(questionDao.findById(id), HttpStatus.OK);
    }catch(Exception e){
      e.printStackTrace();
    }
    return new ResponseEntity<>(questionDao.findById(id), HttpStatus.BAD_REQUEST);
  }

  public Question addQuestion(Question question){
    return questionDao.save(question);
  }
}
