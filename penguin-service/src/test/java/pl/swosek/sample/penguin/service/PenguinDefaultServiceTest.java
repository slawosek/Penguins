package pl.swosek.sample.penguin.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;
import pl.swosek.sample.penguin.data.service.impl.PenguinDefaultService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class PenguinDefaultServiceTest {


    @Mock
    private PenguinRepository repository;

    @InjectMocks
    PenguinDefaultService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getPenguins() {
        List<Penguin> expected = List.of(
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
        );
        when(repository.findAll())
                .thenReturn(expected);

        List<Penguin> actual = service.findAllPenguins();

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void getPenguin() {
        Optional<Penguin> expected =
                Optional.of(
                        Penguin.builder()
                                .taxonKey("2481663")
                                .acceptedScientificName("Pygoscelis adeliae (Hombron & Jacquinot  1841)")
                                .species("Pygoscelis adeliae")
                                .scientificName("Pygoscelis adeliae (Hombron & Jacquinot  1841)")
                                .numberOfOccurrences(13)
                                .build()
                );
        when(repository.findById("2481663"))
                .thenReturn(expected);

        Optional<Penguin> actual = service.findPenguin("2481663");

        assertThat(expected).isEqualTo(actual);
    }

}
