package pl.swosek.sample.penguin.data.repository.api;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.Optional;

/**
 * Penguin entity repository.
 */
public interface PenguinRepository extends JpaRepository<Penguin, String> {

    @EntityGraph(value = Penguin.EntityGraphs.WITH_IMAGES, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Penguin> findByTaxonKey(String taxonKey);

}
