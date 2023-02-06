package ch.zhaw.blueberry.controller;

import ch.zhaw.blueberry.entities.Todo;
import ch.zhaw.blueberry.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
		return result.map(diagnosis -> new ResponseEntity<>(diagnosis, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
