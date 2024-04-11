package pl.swosek.sample.penguin.data.service.api;

import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.List;

/**
 * Service for penguins related operations.
 */
public interface PenguinService {

    /**
     * Fetches all penguins.
     */
    List<Penguin> findAllPenguins();

}
