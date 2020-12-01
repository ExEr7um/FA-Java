package com.exer7um.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Table(name="answers")
public class Answer extends AuditModel{
    @Id
    @GeneratedValue(generator = "answer_generator")
    @SequenceGenerator(
            name="answer_generator",
            sequenceName = "Answer_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String text; //название


    private Long getId(){
        return id;
    }



    private  String getText(){
        return text;
    }

    private void setText(String text){
        this.text=text;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Question question;

    public Question getQuestion(){
        return question;
    }

    public void setQuestion(Question question){
        this.question=question;
    }

}
