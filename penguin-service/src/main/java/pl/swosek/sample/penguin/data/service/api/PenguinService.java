package pl.swosek.sample.penguin.data.service.api;

import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.List;
import java.util.Optional;

/**
 * Service for penguins related operations.
 */
public interface PenguinService {

    /**
     * Fetches all penguins.
     */
    List<Penguin> findAllPenguins();

    /**
     * Fetches potential penguin with given taxon key.
     */
    Optional<Penguin> findPenguin(String taxonKey);

}
