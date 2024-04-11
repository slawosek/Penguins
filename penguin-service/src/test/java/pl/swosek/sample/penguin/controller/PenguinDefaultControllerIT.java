package pl.swosek.sample.penguin.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinsResponse;
import pl.swosek.sample.penguin.data.controller.function.PenguinsToResponseFunction;
import pl.swosek.sample.penguin.data.controller.impl.PenguinDefaultController;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PenguinDefaultControllerIT {

    @Autowired
    private PenguinRepository repository;

    @Autowired
    private PenguinDefaultController controller;

    @Autowired
    private PenguinsToResponseFunction function;

    @BeforeEach
    void initializeData() {
        repository.deleteAll();
        repository.saveAll(List.of(
                        Penguin.builder()
                                .taxonKey("2481660")
                                .acceptedScientificName("Aptenodytes patagonicus J.F.Miller 1778")
                                .species("Aptenodytes patagonicus")
                                .scientificName("Aptenodytes patagonicus J.F.Miller 1778")
                                .numberOfOccurrences(13)
                                .build(),
                        Penguin.builder()
                                .taxonKey("2481663")
                                .acceptedScientificName("Pygoscelis adeliae (Hombron & Jacquinot  1841)")
                                .species("Pygoscelis adeliae")
                                .scientificName("Pygoscelis adeliae (Hombron & Jacquinot  1841)")
                                .numberOfOccurrences(13)
                                .build()
                )
        );
    }

    @Test
    void getPenguins() {
        GetPenguinsResponse expected = function.apply(List.of(
                Penguin.builder()
                        .taxonKey("2481660")
                        .acceptedScientificName("Aptenodytes patagonicus J.F.Miller 1778")
                        .species("Aptenodytes patagonicus")
                        .scientificName("Aptenodytes patagonicus J.F.Miller 1778")
                        .numberOfOccurrences(13)
                        .build(),
                Penguin.builder()
                        .taxonKey("2481663")
                        .acceptedScientificName("Pygoscelis adeliae (Hombron & Jacquinot  1841)")
                        .species("Pygoscelis adeliae")
                        .scientificName("Pygoscelis adeliae (Hombron & Jacquinot  1841)")
                        .numberOfOccurrences(13)
                        .build()
        ));

        GetPenguinsResponse actual = controller.getPenguins();

        assertThat(expected).isEqualTo(actual);
    }
}
