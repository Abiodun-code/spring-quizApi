package com.abioduncode.quizapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abioduncode.quizapp.model.Question;
import com.abioduncode.quizapp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  public QuestionController(QuestionService questionService){
    this.questionService = questionService;
  }
  
  // Request to get all question from the database
  @GetMapping("/allQuestion")
  public ResponseEntity<List<Question>> getAllQuestions(){
    return questionService.getAllQuestion();
  }

  // Request to get question by category from the database
  @GetMapping("category/{category}")
  public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
    return questionService.getQuestionByCategory(category);
  }

  // Requesting for a particular question by id
  @GetMapping("allQuestion/{id}")
  public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable Integer id){
    return questionService.getQuestionById(id);
  }

  // Creating new question
  @PostMapping("create/add")
  public Question addQuestion(@RequestBody Question question){
    return questionService.addQuestion(question);
  }
}
