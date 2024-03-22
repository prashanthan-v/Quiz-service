package com.riya.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionWrapper {

    private Integer id;
    private   String  questiontitle ;                                 //id int primary key,
    private    String option1;                                   //questiontitle varchar(300),
    private   String option2;                                    //option1 varchar(200),
    private   String option3;

}
