package com.Spring_Boot_Start.Spring_Boot_Start;

public class Course {
    private long id;
    private String subj;
    private String author;

    public Course(long id, String subj, String author) {
        this.id = id;
        this.subj = subj;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getSubj() {
        return subj;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", subj='" + subj + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
