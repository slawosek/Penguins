package pl.swosek.sample.penguin.data.repository.function;

import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.bean.PenguinCsvBean;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;
import pl.swosek.sample.penguin.data.repository.entity.PenguinImage;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Converts List of {@link PenguinCsvBean} to {@link Penguin}
 */
@Component
public class PenguinsCsvBeanAndImagesToEntityFunction implements BiFunction<List<PenguinCsvBean>, List<PenguinImage>, List<Penguin>> {

    private final PenguinCsvBeanAndImagesToEntityFunction function;

    public PenguinsCsvBeanAndImagesToEntityFunction(PenguinCsvBeanAndImagesToEntityFunction function) {
        this.function = function;
    }

    @Override
    public List<Penguin> apply(List<PenguinCsvBean> penguinCsvBeans, List<PenguinImage> images) {
        return penguinCsvBeans.stream()
                .map(csvBean -> function.apply(csvBean, images))
                .collect(Collectors.toList());
    }

}
