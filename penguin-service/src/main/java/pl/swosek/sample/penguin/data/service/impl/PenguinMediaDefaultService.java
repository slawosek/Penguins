package pl.swosek.sample.penguin.data.service.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.swosek.sample.penguin.data.repository.api.MediaRepository;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;
import pl.swosek.sample.penguin.data.service.api.PenguinMediaService;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class PenguinMediaDefaultService implements PenguinMediaService {

    private final MediaRepository mediaRepository;

    private final PenguinRepository penguinRepository;

    @Autowired
    public PenguinMediaDefaultService(
            MediaRepository imageRepository,
            PenguinRepository penguinRepository
    ) {
        this.mediaRepository = imageRepository;
        this.penguinRepository = penguinRepository;
    }

    @Override
    public Optional<PenguinMedia> findByPenguinTaxonKey(String penguinTaxonKey) {
        return mediaRepository.findFirstByPenguinTaxonKey(penguinTaxonKey);
    }

    @Override
    public List<PenguinMedia> findAll() {
        return mediaRepository.findAll();
    }

}
