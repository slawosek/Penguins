package pl.swosek.sample.penguin.data.controller.function;

import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.controller.dto.PutPenguinRequest;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.function.BiFunction;

@Component
public class RequestToPenguinFunction implements BiFunction<String, PutPenguinRequest, Penguin> {

    @Override
    public Penguin apply(String taxonKey, PutPenguinRequest penguinRequest) {
        return Penguin.builder()
                .taxonKey(taxonKey)
                .scientificName(penguinRequest.getScientificName())
                .numberOfOccurrences(penguinRequest.getNumberOfOccurrences())
                .acceptedScientificName(penguinRequest.getAcceptedScientificName())
                .species(penguinRequest.getSpecies())
                .build();
    }

}
