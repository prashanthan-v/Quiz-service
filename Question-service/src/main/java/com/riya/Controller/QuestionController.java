package com.riya.Controller;



import com.riya.Service.QuestionService;
import com.riya.model.Question;
import com.riya.model.QuestionWrapper;
import com.riya.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
@Autowired
private QuestionService questionService;


    @GetMapping("allquestions")
    public List<Question> getallquestion(){

        return questionService.getquestion() ;
    }
     @GetMapping("category/{category}")
    public List<Question> getquestionbycategory(@PathVariable String category){

        return questionService.getspecificquestion(category) ;
    }
@PostMapping("add")
    public String AddQuestion(@RequestBody Question question){
        return questionService.add(question);

    }
    @GetMapping("getidforquiz")
    public ResponseEntity<List<Integer>>getQuestionid
            (@RequestParam String category,@RequestParam Integer nums  ){
        return questionService.getquestionid(category,nums);
    }
@PostMapping("getquestion")
    public ResponseEntity<List<QuestionWrapper>>GetQuestion
            (@RequestBody List<Integer>questionid){
        return  questionService.GetQuestion(questionid);
    }
@PostMapping("getscore")
  public  ResponseEntity<Integer>getscore(@RequestBody List<Response> response){
        return questionService.getscore(response);

  }
   @GetMapping("bycategory/{category}")
    public ResponseEntity<List<Question>>getquestionbycat(@PathVariable String category){
        return questionService.getquestionbycat(category);
   }

}
