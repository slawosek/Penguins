package pl.swosek.sample.penguin.data.repository.function;

import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.bean.PenguinCsvBean;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;

import java.util.List;
import java.util.function.BiFunction;

/**
 * Converts {@link PenguinCsvBean} to {@link Penguin}
 */
@Component
public class PenguinCsvBeanAndMediaToEntityFunction implements BiFunction<PenguinCsvBean, List<PenguinMedia>, Penguin> {

    @Override
    public Penguin apply(PenguinCsvBean penguinCsvBean, List<PenguinMedia> media) {
        return Penguin.builder()
                .taxonKey(penguinCsvBean.getTaxonKey())
                .scientificName(penguinCsvBean.getScientificName())
                .species(penguinCsvBean.getSpecies())
                .acceptedScientificName(penguinCsvBean.getAcceptedScientificName())
                .numberOfOccurrences(penguinCsvBean.getNumberOfOccurrences())
                .medias(media == null ? List.of() : media.stream()
                        .filter(file -> file.getFilename().contains(penguinCsvBean.getTaxonKey()))
                        .toList()
                )
                .build();
    }

}
