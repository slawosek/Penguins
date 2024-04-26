package pl.swosek.sample.penguin.data.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;

/**
 * Penguin entity repository.
 */
public interface PenguinRepository extends JpaRepository<Penguin, String> {

}
