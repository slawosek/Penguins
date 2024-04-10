package pl.swosek.sample.penguin.data.controller.function;

import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.bean.PenguinCsvBean;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinResponse;

import java.util.function.Function;

/**
 * Converts {@link PenguinCsvBean} to {@link GetPenguinResponse}.
 */
@Component
public class PenguinToResponseFunction implements Function<PenguinCsvBean, GetPenguinResponse> {

    @Override
    public GetPenguinResponse apply(PenguinCsvBean penguinCsvBean) {
        return GetPenguinResponse.builder()
                .scientificName(penguinCsvBean.getScientificName())
                .numberOfOccurrences(penguinCsvBean.getNumberOfOccurrences())
                .acceptedScientificName(penguinCsvBean.getAcceptedScientificName())
                .species(penguinCsvBean.getSpecies())
                .build();
    }

}
