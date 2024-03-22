package com.riya.Repository;



import com.riya.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {


    List<Question> findByCategory(String category);
//   @Query(value = "select *from Question q where q.category=:category order by RAND() LIMIT :num",nativeQuery = true)
//    List<Question> findRandomQuestionsByCategory(String category, Integer num);
    @Query(value = "select q.id from Question q where q.category=:category order by RAND() LIMIT :num",nativeQuery = true)
    List<Integer> findRandomQuestionsidByCategory(String category, Integer num);

    @Query(value = "select * from Question q where q.category=:category order by RAND() ",nativeQuery = true)
    List<Question>findRandomQuestionsByCategory(String category);

}
