package ch.zhaw.blueberry.controller;

import ch.zhaw.blueberry.entities.Todo;
import ch.zhaw.blueberry.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoRepository repository;

    @GetMapping(value = "blueberry/todos")
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> result = this.repository.findAll();

        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "blueberry/todos/{id}")
    public ResponseEntity<Todo> getConditionById(@PathVariable("id") long id) {
        Optional<Todo> result = this.repository.findById(id);
        return result.map(todo -> new ResponseEntity<>(todo, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "blueberry/todos/create", consumes = {"application/json"})
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return new ResponseEntity<>(repository.save(todo), HttpStatus.OK);
    }

    @PostMapping(value = "blueberry/todos/update", consumes = {"application/json"})
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        Optional<Todo> optionalExistingTodo = repository.findById(todo.getId());
        if (optionalExistingTodo.isPresent()) {
            Todo existingTodo = optionalExistingTodo.get();
            existingTodo.setName(todo.getName());
            existingTodo.setDescription(todo.getDescription());
            repository.save(existingTodo);
            return new ResponseEntity<>(existingTodo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "blueberry/todos/delete", consumes = {"application/json"})
    public ResponseEntity<Void> deleteTodo(@RequestBody Todo todo) {
        Optional<Todo> optionalExistingTodo = repository.findById(todo.getId());
        if (optionalExistingTodo.isPresent()) {
            repository.delete(optionalExistingTodo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
