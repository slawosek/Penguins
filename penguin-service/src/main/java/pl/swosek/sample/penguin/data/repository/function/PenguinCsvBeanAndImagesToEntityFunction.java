package pl.swosek.sample.penguin.data.repository.function;

import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.bean.PenguinCsvBean;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;
import pl.swosek.sample.penguin.data.repository.entity.PenguinImage;

import java.util.List;
import java.util.function.BiFunction;

/**
 * Converts {@link PenguinCsvBean} to {@link Penguin}
 */
@Component
public class PenguinCsvBeanAndImagesToEntityFunction implements BiFunction<PenguinCsvBean, List<PenguinImage>, Penguin> {

    @Override
    public Penguin apply(PenguinCsvBean penguinCsvBean, List<PenguinImage> images) {
        return Penguin.builder()
                .taxonKey(penguinCsvBean.getTaxonKey())
                .scientificName(penguinCsvBean.getScientificName())
                .species(penguinCsvBean.getSpecies())
                .acceptedScientificName(penguinCsvBean.getAcceptedScientificName())
                .numberOfOccurrences(penguinCsvBean.getNumberOfOccurrences())
                .images(images == null ? List.of() : images.stream()
                        .filter(image -> image.getFilename().contains(penguinCsvBean.getTaxonKey()))
                        .toList()
                )
                .build();
    }

}
