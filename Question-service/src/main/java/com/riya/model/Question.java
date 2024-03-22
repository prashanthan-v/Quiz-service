package com.riya.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Question {
    @Id
   private Integer id;
   private   String  questiontitle ;                                 //id int primary key,
   private    String option1;                                   //questiontitle varchar(300),
  private   String option2;                                    //option1 varchar(200),
  private   String option3;                   //option2 varchar(200),
                                        //option3 varchar(200),
   private String rightanswer;                                         //rightanswer varchar(200),
    private String category ;                                        //category varchar(100)

}
