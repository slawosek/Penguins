package pl.swosek.sample.penguin.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import pl.swosek.sample.penguin.data.repository.api.MediaRepository;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;
import pl.swosek.sample.penguin.data.service.api.PenguinMediaService;

import java.util.List;
import java.util.Optional;

import static pl.swosek.sample.penguin.utility.Utility.distinctBy;

@Service
public class PenguinMediaDefaultService implements PenguinMediaService {

    private final MediaRepository mediaRepository;

    @Autowired
    public PenguinMediaDefaultService(MediaRepository imageRepository) {
        this.mediaRepository = imageRepository;
    }

    @Override
    public Optional<PenguinMedia> findByPenguinTaxonKey(String penguinTaxonKey) {
        return mediaRepository.findFirstByPenguinTaxonKey(penguinTaxonKey);
    }

    @Override
    public List<PenguinMedia> findAllDistinctImages() {
        return mediaRepository.findAllByMimeType(MediaType.IMAGE_JPEG).stream()
                .filter(distinctBy(PenguinMedia::getPenguin))
                .toList();
    }

    @Override
    public Optional<PenguinMedia> findImageByPenguinTaxonKey(String penguinTaxonKey) {
        Optional<PenguinMedia> image = mediaRepository.findFirstByPenguinTaxonKeyAndMimeType(penguinTaxonKey, MediaType.IMAGE_JPEG);
        if (image.isEmpty()) {
            return mediaRepository.findFirstByPenguinTaxonKeyAndMimeType(penguinTaxonKey, MediaType.IMAGE_PNG);
        }
        return image;
    }

    @Override
    public Optional<PenguinMedia> findVideoByPenguinTaxonKey(String penguinTaxonKey) {
        return mediaRepository.findAllByPenguinTaxonKey(penguinTaxonKey).stream()
                .filter(media -> media.getMimeType().equals(MediaType.APPLICATION_PROBLEM_JSON))
                .findFirst();
    }

}
