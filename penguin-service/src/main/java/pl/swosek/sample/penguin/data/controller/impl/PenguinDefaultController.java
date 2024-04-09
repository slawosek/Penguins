package pl.swosek.sample.penguin.data.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import pl.swosek.sample.penguin.data.controller.api.PenguinController;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinResponse;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinsResponse;

import java.util.List;

/**
 * Default penguin controller implementation.
 */
@RestController
public class PenguinDefaultController implements PenguinController {

    @Override
    public GetPenguinsResponse getPenguins() {
        return GetPenguinsResponse.builder()
                .penguins(List.of(
                                GetPenguinResponse.builder()
                                        .name("Kokosanka")
                                        .build(),
                                GetPenguinResponse.builder()
                                        .name("Britney")
                                        .build()
                        )
                )
                .build();
    }

}
