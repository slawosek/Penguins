package pl.swosek.sample.penguin.data.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.swosek.sample.penguin.data.repository.entity.PenguinImage;

import java.util.Optional;
import java.util.UUID;

public interface ImageRepository extends JpaRepository<PenguinImage, UUID> {

    Optional<PenguinImage> findFirstByPenguinTaxonKey(String taxonKey);

}
