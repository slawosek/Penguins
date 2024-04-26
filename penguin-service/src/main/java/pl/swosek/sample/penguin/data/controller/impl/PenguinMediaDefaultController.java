package pl.swosek.sample.penguin.data.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.swosek.sample.penguin.data.controller.api.PenguinMediaController;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;
import pl.swosek.sample.penguin.data.service.api.PenguinMediaService;

import java.util.List;
import java.util.Optional;

/**
 * Default penguin image controller implementation.
 */
@RestController
public class PenguinMediaDefaultController implements PenguinMediaController {

    private final PenguinMediaService service;

    @Autowired
    public PenguinMediaDefaultController(PenguinMediaService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<byte[]> getPenguinImage(String taxonKey) {
        Optional<PenguinMedia> penguinImage = service.findByPenguinTaxonKey(taxonKey);
        return ResponseEntity.ok()
                .contentType(penguinImage.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getMimeType())
                .body(penguinImage
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                        .getBytes());
    }

    public List<String> getPenguinImages() {
        return service.findAll().stream().map(PenguinMedia::getFilename).toList();
    }

}
