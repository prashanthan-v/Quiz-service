package com.riya.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.riya.Service.QuestionService;
import com.riya.model.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionController.class)
class QuestionControllerTest {
     @Autowired
    private MockMvc mockMvc;
    @MockBean
    private QuestionService questionService;

    Question question1;
    Question question2;
    List<Question>questions = new ArrayList<>();



    @BeforeEach
    void setUp() {
        question1 = new Question(1,"how many aliens does the watch contains"
                ,"20","12","10","10","Alien");

        question2 = new Question(2,"how many aliens does the watch contains is black"
                ,"210","120","100","100","Alien");

        questions.add(question1);
        questions.add(question2);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getallquestion() throws Exception {
        when(questionService.getquestion()).thenReturn(questions);
       this.mockMvc.perform(get("/question/allquestions"))
               .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getquestionbycategory()throws Exception {
        when( questionService.getspecificquestion(question1.getCategory())).thenReturn(questions);
        this.mockMvc.perform(get("/question/category/Alien"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void addQuestion() throws Exception {

            ObjectMapper objectMapper =new ObjectMapper();
            objectMapper.configure (SerializationFeature.WRAP_ROOT_VALUE,  false) ;
            ObjectWriter  ow = objectMapper.writer().withDefaultPrettyPrinter();
           String requestjason =  ow. writeValueAsString(question2) ;

        when(questionService.add(question2)).thenReturn("succeded");
        this.mockMvc.perform(post("/question/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestjason))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void getQuestionid() {
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