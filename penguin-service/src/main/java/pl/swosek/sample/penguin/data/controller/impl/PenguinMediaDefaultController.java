package pl.swosek.sample.penguin.data.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.swosek.sample.penguin.data.controller.api.PenguinMediaController;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinImagesInfo;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinVideoInfo;
import pl.swosek.sample.penguin.data.controller.function.PenguinImagesToInfoResponseFunction;
import pl.swosek.sample.penguin.data.controller.function.PenguinVideoInfoToResponseFunction;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;
import pl.swosek.sample.penguin.data.service.api.PenguinMediaService;

import java.util.Optional;

/**
 * Default penguin image controller implementation.
 */
@RestController
@Log
public class PenguinMediaDefaultController implements PenguinMediaController {

    private final PenguinMediaService service;

    private final PenguinImagesToInfoResponseFunction penguinImagesToInfoResponseFunction;

    private final PenguinVideoInfoToResponseFunction penguinVideoInfoToResponseFunction;

    @Autowired
    public PenguinMediaDefaultController(
            PenguinMediaService service,
            PenguinImagesToInfoResponseFunction penguinImagesToInfoResponseFunction,
            PenguinVideoInfoToResponseFunction penguinVideoInfoToResponseFunction
    ) {
        this.service = service;
        this.penguinImagesToInfoResponseFunction = penguinImagesToInfoResponseFunction;
        this.penguinVideoInfoToResponseFunction = penguinVideoInfoToResponseFunction;
    }

    @Override
    public ResponseEntity<byte[]> getPenguinImage(String taxonKey) {
        Optional<PenguinMedia> penguinImage = service.findImageByPenguinTaxonKey(taxonKey);
        return ResponseEntity.ok()
                .contentType(penguinImage.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getMimeType())
                .body(penguinImage
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                        .getBytes());
    }

    @Override
    public GetPenguinImagesInfo getPenguinImages() {
        return penguinImagesToInfoResponseFunction.apply(service.findAllDistinctImages());
    }

    @Override
    public ResponseEntity<byte[]> getPenguinVideo(String taxonKey) {
        Optional<PenguinMedia> penguinVideo = service.findVideoByPenguinTaxonKey(taxonKey);
        return ResponseEntity.ok()
                .contentType(penguinVideo.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getMimeType())
                .body(penguinVideo
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                        .getBytes());
    }

    @Override
    public GetPenguinVideoInfo getPenguinVideoInfo(String taxonKey) {
        return penguinVideoInfoToResponseFunction.apply(service.findVideoByPenguinTaxonKey(taxonKey)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
        );
    }

}
