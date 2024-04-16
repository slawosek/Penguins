package pl.swosek.sample.penguin.data.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.swosek.sample.penguin.data.controller.api.PenguinController;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinResponse;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinsResponse;
import pl.swosek.sample.penguin.data.controller.dto.PutPenguinRequest;
import pl.swosek.sample.penguin.data.controller.function.PenguinToResponseFunction;
import pl.swosek.sample.penguin.data.controller.function.PenguinsToResponseFunction;
import pl.swosek.sample.penguin.data.controller.function.RequestToPenguinFunction;
import pl.swosek.sample.penguin.data.service.api.PenguinService;

/**
 * Default penguin controller implementation.
 */
@RestController
public class PenguinDefaultController implements PenguinController {


    private final PenguinsToResponseFunction penguinsToResponseFunction;

    private final PenguinToResponseFunction penguinToResponseFunction;

    private final RequestToPenguinFunction requestToPenguinFunction;

    private final PenguinService service;

    @Autowired
    public PenguinDefaultController(
            PenguinsToResponseFunction penguinsToResponseFunction,
            PenguinToResponseFunction penguinToResponseFunction,
            RequestToPenguinFunction requestToPenguinFunction,
            PenguinService service
    ) {
        this.penguinsToResponseFunction = penguinsToResponseFunction;
        this.penguinToResponseFunction = penguinToResponseFunction;
        this.requestToPenguinFunction = requestToPenguinFunction;
        this.service = service;
    }

    @Override
    public GetPenguinsResponse getPenguins() {
        try {
            return penguinsToResponseFunction.apply(service.findAllPenguins());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GetPenguinResponse getPenguin(String taxonKey) {
        return service.findPenguin(taxonKey)
                .map(penguinToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putPenguin(String taxonKey, PutPenguinRequest request) {
        boolean updated = service.updatePenguin(requestToPenguinFunction.apply(taxonKey, request));
        if (!updated) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
