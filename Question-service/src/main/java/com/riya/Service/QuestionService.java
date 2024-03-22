package com.riya.Service;



import com.riya.Repository.QuestionRepository;
import com.riya.model.Question;
import com.riya.model.QuestionWrapper;
import com.riya.model.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class QuestionService {
@Autowired
    private QuestionRepository repository;

  public List<Question> getquestion(){
      return repository.findAll();
    }


    public List<Question> getspecificquestion(String category) {
      return repository.findByCategory(category);
    }

    public String add(Question question) {
      repository.save(question);
      return "succeded";
    }

  public ResponseEntity<List<Integer>> getquestionid(String category, Integer nums) {
 List<Integer>questionsid = repository.findRandomQuestionsidByCategory(category,nums);
     return  new ResponseEntity<>(questionsid, HttpStatus.OK);
  }

    public ResponseEntity<List<QuestionWrapper>> GetQuestion(List<Integer> questionid) {
      List<Question>questions = new ArrayList<>();
      for(Integer id: questionid){
        Question question =   repository.findById(id).get();
        questions.add(question);
      }
      List<QuestionWrapper>questionWrappers = new ArrayList<>();
      for(Question Q:questions){
          QuestionWrapper questionWrapper = new QuestionWrapper();
          questionWrapper.setId(Q.getId());
          questionWrapper.setQuestiontitle(Q.getQuestiontitle());
          questionWrapper.setOption1(Q.getOption1());
          questionWrapper.setOption2(Q.getOption2());
          questionWrapper.setOption3(Q.getOption3());
          questionWrappers.add(questionWrapper);
      }

     return  new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getscore(List<Response> responses) {
      int right = 0;
      for (Response r : responses){
          Question question = repository.findById(r.getId()).get();
          if(question.getRightanswer().equals(r.getResponse())){
              right++;
          }

      }
      return new ResponseEntity<>(right,HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getquestionbycat(String category) {
          List<Question>questions  = repository.findRandomQuestionsByCategory(category);
          return new ResponseEntity<>(questions,HttpStatus.OK);

    }
}
