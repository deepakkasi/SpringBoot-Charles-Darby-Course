package com.Spring.Rest.CrudDemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="review")
public class Review {
    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    private int id;
    @Column(name="comment")
    private String comment;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



}
