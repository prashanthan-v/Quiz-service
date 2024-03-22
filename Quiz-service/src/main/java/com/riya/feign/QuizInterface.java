package com.riya.feign;


import com.riya.model.QuestionWrapper;
import com.riya.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public  interface QuizInterface {

    @GetMapping("question/getidforquiz")
    ResponseEntity<List<Integer>> getQuestionid
            (@RequestParam String category, @RequestParam Integer nums  );
    @PostMapping("question/getquestion")
    ResponseEntity<List<QuestionWrapper>>GetQuestion
            (@RequestBody List<Integer>questionid);
    @PostMapping("question/getscore")
     ResponseEntity<Integer>getscore(@RequestBody List<Response> response);

}
