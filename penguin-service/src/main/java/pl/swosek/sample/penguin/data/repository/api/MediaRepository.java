package pl.swosek.sample.penguin.data.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;

import java.util.Optional;
import java.util.UUID;

public interface MediaRepository extends JpaRepository<PenguinMedia, UUID> {

    Optional<PenguinMedia> findFirstByPenguinTaxonKey(String taxonKey);

}
