package pl.swosek.sample.penguin.data.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.swosek.sample.penguin.csv.parser.ReaderImplementation;
import pl.swosek.sample.penguin.data.controller.api.PenguinController;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinsResponse;
import pl.swosek.sample.penguin.data.controller.function.PenguinsToResponseFunction;

/**
 * Default penguin controller implementation.
 */
@RestController
public class PenguinDefaultController implements PenguinController {

    private final ReaderImplementation readerImplementation;

    private final PenguinsToResponseFunction function;

    @Autowired
    public PenguinDefaultController(
            ReaderImplementation readerImplementation,
            PenguinsToResponseFunction function
    ) {
        this.readerImplementation = readerImplementation;
        this.function = function;
    }

    @Override
    public GetPenguinsResponse getPenguins() {
        try {
            return function.apply(readerImplementation.readDataFromCsv());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
