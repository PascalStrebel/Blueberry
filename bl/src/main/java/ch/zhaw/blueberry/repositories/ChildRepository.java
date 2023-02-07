package ch.zhaw.blueberry.repositories;

import ch.zhaw.blueberry.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
