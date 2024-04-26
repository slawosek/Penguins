package pl.swosek.sample.penguin.data.service.api;

import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;

import java.util.List;
import java.util.Optional;

/**
 * Service for penguin images related operations.
 */
public interface PenguinMediaService {

    Optional<PenguinMedia> findByPenguinTaxonKey(String penguinTaxonKey);

    List<PenguinMedia> findAllDistinctImages();

    Optional<PenguinMedia> findImageByPenguinTaxonKey(String penguinTaxonKey);

    Optional<PenguinMedia> findVideoByPenguinTaxonKey(String penguinTaxonKey);

}
