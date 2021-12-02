package com.spring.macoveirazvanionut.entities;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="review")
    private Integer reviewGrade;

    @Column(name="reviewDescription")
    private String reviewDescription;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(Integer reviewGrade) {
        this.reviewGrade = reviewGrade;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }
}
