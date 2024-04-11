package pl.swosek.sample.penguin.data.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.swosek.sample.penguin.data.controller.api.PenguinController;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinsResponse;
import pl.swosek.sample.penguin.data.controller.function.PenguinsToResponseFunction;
import pl.swosek.sample.penguin.data.service.api.PenguinService;

/**
 * Default penguin controller implementation.
 */
@RestController
public class PenguinDefaultController implements PenguinController {


    private final PenguinsToResponseFunction function;

    private final PenguinService service;

    @Autowired
    public PenguinDefaultController(
            PenguinsToResponseFunction function,
            PenguinService service
    ) {
        this.function = function;
        this.service = service;
    }

    @Override
    public GetPenguinsResponse getPenguins() {
        try {
            return function.apply(service.findAllPenguins());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}