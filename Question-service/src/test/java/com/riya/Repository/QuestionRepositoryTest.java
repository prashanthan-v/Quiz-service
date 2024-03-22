package com.riya.Repository;


import com.riya.model.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DataJpaTest
public class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository repository;
   Question question;
//
//                                                  "id": 1,
//                                               "questiontitle": "is c is best for dsa",
//                                                           "option1": "yes",
//                                                       "option2": "no",
//                                                       "option3": "cant answer",
//                                                            "rightanswer": "yes",
//                                                                      "category": "c"



    @BeforeEach
    void setUp() {
        question  = new Question(1,"what is full mark","100",
                "200","250","200","java");
        repository.save(question);
    }

    @AfterEach
    void tearDown() {
        question = null;
        repository.deleteAll();
    }
    @Test
    void  testFindbyname_found(){
//        List<Integer> findRandomQuestionsByCategory(String category, Integer num);
        List<Question> questions= repository.findRandomQuestionsByCategory("java");
        Assertions.assertEquals(questions.get(0).getCategory(),"java");

    }
}
