package com.example.nsc.firebase.model;

/**
 * Created by NSC on 9/1/2017.
 */

public class Comment {
    String name;
    String date;
    String Comment;

    public Comment(String name, String date, String comment) {
        this.name = name;
        this.date = date;
        Comment = comment;
    }

    public Comment() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
