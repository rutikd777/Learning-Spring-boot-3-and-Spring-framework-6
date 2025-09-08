package com.myFirstWeb.SpringBoot.myFirstWeb.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;


@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String username;

    @NotBlank(message = "Description is required")
    @Size(min = 10, message = "Enter at least 10 characters")
    private String desc;

    private LocalDate targetDate;
    private boolean done;

    // Default constructor (required for form binding)
    public Todo() {
    }

    // Constructor with parameters
    public Todo(int id, String username, String desc, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.desc = desc;
        this.targetDate = targetDate;
        this.done = done;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", desc='" + desc + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}