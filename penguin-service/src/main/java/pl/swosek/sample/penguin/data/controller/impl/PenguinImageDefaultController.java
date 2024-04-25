package pl.swosek.sample.penguin.data.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.swosek.sample.penguin.data.controller.api.PenguinImageController;
import pl.swosek.sample.penguin.data.repository.entity.PenguinImage;
import pl.swosek.sample.penguin.data.service.api.PenguinImageService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

/**
 * Default penguin image controller implementation.
 */
@RestController
@Log
public class PenguinImageDefaultController implements PenguinImageController {

    private final PenguinImageService penguinImageService;

    @Autowired
    public PenguinImageDefaultController(PenguinImageService penguinImageService) {
        this.penguinImageService = penguinImageService;
    }

    @Override
    public ResponseEntity<byte[]> getPenguinImage(String taxonKey) {
        Optional<PenguinImage> penguinImage = penguinImageService.findByPenguinTaxonKey(taxonKey);
        log.log(Level.WARNING, penguinImage.get().getFilename());
        return ResponseEntity.ok()
                .contentType(penguinImage.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getMimeType())
                .body(penguinImage
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                        .getBytes());
    }

    public List<String> getPenguinImages() {
        return penguinImageService.findAll().stream().map(PenguinImage::getFilename).toList();
    }

}
