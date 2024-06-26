package pl.swosek.sample.penguin.data.service.impl;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;
import pl.swosek.sample.penguin.data.service.api.PenguinService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

/**
 * Penguin service default implementation.
 */
@Service
@Log
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

    @Override
    public boolean updatePenguin(Penguin penguin) {
        log.log(Level.WARNING, penguin.getTaxonKey());
        boolean updated = this.repository.existsById(penguin.getTaxonKey());
        log.log(Level.WARNING, penguin.toString());
        log.log(Level.WARNING, updated ? "true" : "false");
        if (updated) {
            repository.save(penguin);
        }
        return updated;
    }

}
