package ch.zhaw.blueberry.repositories;

import ch.zhaw.blueberry.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
