package pl.swosek.sample.penguin.data.service.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.swosek.sample.penguin.data.repository.api.ImageRepository;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;
import pl.swosek.sample.penguin.data.repository.entity.PenguinImage;
import pl.swosek.sample.penguin.data.service.api.PenguinImageService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Service
@Log
public class PenguinImageDefaultService implements PenguinImageService {

    private final ImageRepository imageRepository;

    private final PenguinRepository penguinRepository;

    @Autowired
    public PenguinImageDefaultService(
            ImageRepository imageRepository,
            PenguinRepository penguinRepository
    ) {
        this.imageRepository = imageRepository;
        this.penguinRepository = penguinRepository;
    }

    @Override
    public Optional<PenguinImage> findByPenguinTaxonKey(String penguinTaxonKey) {
        Penguin penguin = penguinRepository.findByTaxonKey(penguinTaxonKey).get();
        log.log(Level.WARNING, penguin.getImages().toString());
        return imageRepository.findFirstByPenguinTaxonKey(penguinTaxonKey);
    }

    @Override
    public List<PenguinImage> findAll() {
        List<PenguinImage> images = imageRepository.findAll();
        log.log(Level.WARNING, images.get(0).getPenguin().getTaxonKey());
        return images;
    }

}
