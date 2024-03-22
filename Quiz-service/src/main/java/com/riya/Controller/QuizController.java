package com.riya.Controller;



import com.riya.Service.QuizService;
import com.riya.model.QuestionWrapper;
import com.riya.model.Quizdata;
import com.riya.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
private QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Quizdata quizdata){
        return quizService.create(quizdata);

    }
    @PostMapping("getQuizQuestion/{id}")
    public ResponseEntity<List<QuestionWrapper>>CollectQuiz(@PathVariable Integer id){
        return quizService.CollectQuiz(id);
    }
     @PostMapping("evaluate")
    public ResponseEntity<Integer>ObtainScore(@RequestBody List<Response> responses){
        return quizService.ObtainScore(responses);
    }

}
