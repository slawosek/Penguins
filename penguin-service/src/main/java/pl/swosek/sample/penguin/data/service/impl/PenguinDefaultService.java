package pl.swosek.sample.penguin.data.service.impl;

import org.springframework.stereotype.Service;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;
import pl.swosek.sample.penguin.data.service.api.PenguinService;

import java.util.List;
import java.util.Optional;

/**
 * Penguin service default implementation.
 */
@Service
public class PenguinDefaultService implements PenguinService {

    /**
     * Penguin repository.
     */
    private final PenguinRepository repository;

    public PenguinDefaultService(PenguinRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Penguin> findAllPenguins() {
        return repository.findAll();
    }

    @Override
    public Optional<Penguin> findPenguin(String taxonKey) {
        return repository.findById(taxonKey);
    }

}
