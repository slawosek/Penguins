package pl.swosek.sample.penguin.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinResponse;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinsResponse;
import pl.swosek.sample.penguin.data.controller.dto.PutPenguinRequest;
import pl.swosek.sample.penguin.data.controller.function.PenguinToResponseFunction;
import pl.swosek.sample.penguin.data.controller.function.PenguinsToResponseFunction;
import pl.swosek.sample.penguin.data.controller.impl.PenguinDefaultController;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PenguinDefaultControllerIT {

    @Autowired
    private PenguinRepository repository;

    @Autowired
    private PenguinDefaultController controller;

    @Autowired
    private PenguinsToResponseFunction penguinsToResponseFunction;

    @Autowired
    private PenguinToResponseFunction penguinToResponseFunction;

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
        GetPenguinsResponse expected = penguinsToResponseFunction.apply(List.of(
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

    @Test
    void getPenguin() {
        GetPenguinResponse expected = penguinToResponseFunction.apply(
                Penguin.builder()
                        .taxonKey("2481660")
                        .acceptedScientificName("Aptenodytes patagonicus J.F.Miller 1778")
                        .species("Aptenodytes patagonicus")
                        .scientificName("Aptenodytes patagonicus J.F.Miller 1778")
                        .numberOfOccurrences(13)
                        .build()
        );

        GetPenguinResponse actual = controller.getPenguin("2481660");

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void getNonExistingPenguin() {
        String expected = "404 NOT_FOUND";

        String actual  = assertThrows(ResponseStatusException.class,
                () -> controller.getPenguin("999999"))
                .getMessage();

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void putChangedPenguin() {
        Penguin expected = Penguin.builder()
                .taxonKey("2481660")
                .acceptedScientificName("Better name")
                .species("Penguinis cuties")
                .scientificName("Aptenodytes patagonicus J.F.Miller 1778")
                .numberOfOccurrences(150)
                .build();
        controller.putPenguin("2481660",
                PutPenguinRequest.builder()
                        .acceptedScientificName("Better name")
                        .species("Penguinis cuties")
                        .scientificName("Aptenodytes patagonicus J.F.Miller 1778")
                        .numberOfOccurrences(150)
                        .build());

        Penguin actual = repository.findById("2481660").get();

        assertThat(expected).isEqualTo(actual);
    }


}
