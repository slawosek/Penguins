package pl.swosek.sample.penguin.data.repository.function;

import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.bean.PenguinCsvBean;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.function.Function;

/**
 * Converts {@link PenguinCsvBean} to {@link Penguin}
 */
@Component
public class PenguinCsvBeanToEntityFunction implements Function<PenguinCsvBean, Penguin> {

    @Override
    public Penguin apply(PenguinCsvBean penguinCsvBean) {
        return Penguin.builder()
                .taxonKey(penguinCsvBean.getTaxonKey())
                .scientificName(penguinCsvBean.getScientificName())
                .species(penguinCsvBean.getSpecies())
                .acceptedScientificName(penguinCsvBean.getAcceptedScientificName())
                .numberOfOccurrences(penguinCsvBean.getNumberOfOccurrences())
                .build();
    }

}
