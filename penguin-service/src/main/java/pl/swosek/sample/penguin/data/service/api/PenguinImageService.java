package pl.swosek.sample.penguin.data.service.api;

import pl.swosek.sample.penguin.data.repository.entity.PenguinImage;

import java.util.List;
import java.util.Optional;

/**
 * Service for penguin images related operations.
 */
public interface PenguinImageService {

    Optional<PenguinImage> findByPenguinTaxonKey(String penguinTaxonKey);

    List<PenguinImage> findAll();

}
