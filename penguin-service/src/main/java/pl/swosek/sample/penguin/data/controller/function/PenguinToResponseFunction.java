package pl.swosek.sample.penguin.data.controller.function;

import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinResponse;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.function.Function;

/**
 * Converts {@link Penguin} to {@link GetPenguinResponse}.
 */
@Component
public class PenguinToResponseFunction implements Function<Penguin, GetPenguinResponse> {

    @Override
    public GetPenguinResponse apply(Penguin penguin) {
        return GetPenguinResponse.builder()
                .scientificName(penguin.getScientificName())
                .numberOfOccurrences(penguin.getNumberOfOccurrences())
                .acceptedScientificName(penguin.getAcceptedScientificName())
                .species(penguin.getSpecies())
                .build();
    }

}
