package pl.swosek.sample.penguin.data.controller.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.bean.PenguinCsvBean;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinsResponse;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts list of {@link PenguinCsvBean} to {@link GetPenguinsResponse}.
 */
@Component
public class PenguinsToResponseFunction implements Function<List<PenguinCsvBean>, GetPenguinsResponse> {

    private final PenguinToResponseFunction penguinToResponseFunction;

    @Autowired
    public PenguinsToResponseFunction(PenguinToResponseFunction penguinToResponseFunction) {
        this.penguinToResponseFunction = penguinToResponseFunction;
    }

    @Override
    public GetPenguinsResponse apply(List<PenguinCsvBean> penguinCsvBeanList) {
        return GetPenguinsResponse.builder()
                .penguins(penguinCsvBeanList.stream()
                        .map(penguinToResponseFunction)
                        .collect(Collectors.toList())
                )
                .build();
    }

}
