package pl.swosek.sample.penguin.data.repository.function;

import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.bean.PenguinCsvBean;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts List of {@link PenguinCsvBean} to {@link Penguin}
 */
@Component
public class PenguinsCsvBeanToEntityFunction implements Function<List<PenguinCsvBean>, List<Penguin>> {

    private final PenguinCsvBeanToEntityFunction function;

    public PenguinsCsvBeanToEntityFunction(PenguinCsvBeanToEntityFunction function) {
        this.function = function;
    }

    @Override
    public List<Penguin> apply(List<PenguinCsvBean> penguinCsvBeans) {
        return penguinCsvBeans.stream()
                .map(function)
                .collect(Collectors.toList());
    }

}
