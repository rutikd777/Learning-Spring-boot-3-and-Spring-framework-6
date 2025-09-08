package com.myFirstWeb.SpringBoot.myFirstWeb.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount,"java", "ranga", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount,"Cpp", "Love", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount,"react", "Harsh", LocalDate.now().plusYears(1), false));
    }

    //to access this list for user
    public List<Todo> findByUserName(String username){
        Predicate <? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String desc, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todoCount, username, desc, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
//
//    public Todo findById(int id) {
//        return todos.stream()
//                .filter(todo -> todo.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }

    public void updateTodoById(int id, String username, String desc, LocalDate targetDate, boolean done) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todo.setUsername(username);
                todo.setDesc(desc);
                todo.setTargetDate(targetDate);
                todo.setDone(done);
                break;
            }
        }
    }
}