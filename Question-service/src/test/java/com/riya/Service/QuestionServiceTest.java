package com.riya.Service;


import com.riya.Repository.QuestionRepository;
import com.riya.model.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;
    private QuestionService questionService;
    AutoCloseable autoCloseable;
    Question question;

    @BeforeEach  // this method will execute before each test case
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        questionService = new QuestionService(questionRepository);
        question = new Question(1,"colour of Alienx",
                "blue","black","white","black","Alien");

    }

    @AfterEach        // this method will execute after each test case
    void tearDown() throws Exception {
        autoCloseable.close();
    }
    @Test      // this annotation reprezsent the test case
    void add() {
    mock(Question.class);
    mock(QuestionRepository.class);
    when(questionRepository.save(question)).thenReturn(question);//here save method in jpa
                                        //repository will return the object it saved
                                        //that is why i mentioned question in return
        Assertions.assertEquals(questionService.add(question),"succeded");
    }

    @Test
    void getquestion() {
        mock(Question.class);
        mock(QuestionRepository.class);
        when(questionRepository.findAll()).thenReturn(new ArrayList<Question>(Collections.singleton(question)));
        Assertions.assertEquals(questionService.getquestion().get(0).getCategory(),question.getCategory());
    }

    @Test
    void getspecificquestion() {
    }



    @Test
    void getQuestion() {
    }

    @Test
    void getscore() {
    }

    @Test
    void getquestionbycat() {
    }
}