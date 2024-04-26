package pl.swosek.sample.penguin.data.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MediaRepository extends JpaRepository<PenguinMedia, UUID> {

    Optional<PenguinMedia> findFirstByPenguinTaxonKey(String taxonKey);

    Optional<PenguinMedia> findFirstByPenguinTaxonKeyAndMimeType(String taxonKey, MediaType mimeType);

    List<PenguinMedia> findAllByMimeType(MediaType mimeType);

}
