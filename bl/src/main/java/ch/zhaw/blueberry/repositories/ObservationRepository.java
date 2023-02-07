package ch.zhaw.blueberry.repositories;

import ch.zhaw.blueberry.entities.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
