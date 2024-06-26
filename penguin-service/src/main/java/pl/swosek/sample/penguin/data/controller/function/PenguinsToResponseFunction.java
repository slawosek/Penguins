package pl.swosek.sample.penguin.data.controller.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinsResponse;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts list of {@link Penguin} to {@link GetPenguinsResponse}.
 */
@Component
public class PenguinsToResponseFunction implements Function<List<Penguin>, GetPenguinsResponse> {

    private final PenguinToResponseFunction penguinToResponseFunction;

    @Autowired
    public PenguinsToResponseFunction(PenguinToResponseFunction penguinToResponseFunction) {
        this.penguinToResponseFunction = penguinToResponseFunction;
    }

    @Override
    public GetPenguinsResponse apply(List<Penguin> penguins) {
        return GetPenguinsResponse.builder()
                .penguins(penguins.stream()
                        .map(penguinToResponseFunction)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
