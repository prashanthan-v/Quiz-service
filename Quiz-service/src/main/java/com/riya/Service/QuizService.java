package com.riya.Service;



import com.riya.Repository.QuizRepository;
import com.riya.feign.QuizInterface;
import com.riya.model.QuestionWrapper;
import com.riya.model.Quiz;
import com.riya.model.Quizdata;
import com.riya.model.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizService {


    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizInterface quizInterface;
    public ResponseEntity<String> create (Quizdata q){
       //List<Integer>questionList = repository.findRandomQuestionsByCategory(q.category,q.num);
//           Quiz quiz = new Quiz();
//           quiz.setTitle(q.getTitle());
//           quiz.setQuestions(questionList);
//           quizRepository.save(quiz);

        List<Integer>questionid = quizInterface.getQuestionid(q.getCategory(),q.getNum()).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(q.getTitle());
        quiz.setQuestions(questionid);
        quizRepository.save(quiz);
           return new ResponseEntity<>("worked", HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWrapper>> CollectQuiz(Integer id) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Integer>questionno = new ArrayList<>();
        for(Integer element:quiz.getQuestions()){
           questionno.add(element);
        }
      List<QuestionWrapper>questiontouser = quizInterface.GetQuestion(questionno).getBody();
        //here i m using getbody()because getquestion will return Response entity so to
        // avoid that i used getbody();
        return new ResponseEntity<>(questiontouser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> ObtainScore(List<Response> responses) {
        Integer Score = quizInterface.getscore(responses).getBody();
        return new ResponseEntity<>(Score,HttpStatus.OK);
    }
}
