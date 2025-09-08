package com.myFirstWeb.SpringBoot.myFirstWeb.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

    private Todo_Repository todoRepository;

    public TodoControllerJPA(Todo_Repository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //Method is created here
    private static String getUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getUsername(model);
        System.out.println("Fetching todos for username: " + username);

        List<Todo> todos = todoRepository.findByUsername(username);
        System.out.println("Found " + todos.size() + " todos for user: " + username);

        // Debug: print all todos
        for(Todo todo : todos) {
            System.out.println("Todo: " + todo);
        }

        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodopg(ModelMap model){
        String username = getUsername(model);
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodopg(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "addTodo";
        }

        String username = getUsername(model);
        todo.setUsername(username);
        todo.setDone(false);

        // Ensure target date is set if null
        if(todo.getTargetDate() == null) {
            todo.setTargetDate(todo.getTargetDate());
        }

        // Debug logging
        System.out.println("Saving todo: " + todo);
        System.out.println("Username: " + username);

        // Use JPA repository to save to database
        Todo savedTodo = todoRepository.save(todo);
        System.out.println("Saved todo with ID: " + savedTodo.getId());

        return "redirect:list-todos";
    }

    @RequestMapping("delete")
    public String deleteTodo(@RequestParam int id){

        // Use JPA repository to delete from database
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model){

        // Use JPA repository to find by ID
        Todo todo = todoRepository.findById(id).get();

        model.addAttribute("todo", todo);
        return "addTodo"; // Reuse the same form as add todo
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "addTodo";
        }

        String username = getUsername(model);
        todo.setUsername(username);

        // Use JPA repository to save (update) to database
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
}