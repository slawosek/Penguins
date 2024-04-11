package pl.swosek.sample.penguin.data.repository.initializer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.parser.ReaderImplementation;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.function.PenguinsCsvBeanToEntityFunction;

/**
 * Penguin data initializer.
 */
@Component
public class DataInitializer implements InitializingBean {

    /**
     * Penguin repository.
     */
    private final PenguinRepository repository;

    /**
     * Csv reader implementation.
     */
    private final ReaderImplementation readerImplementation;

    /**
     * Converter function.
     */
    private final PenguinsCsvBeanToEntityFunction function;

    @Autowired
    public DataInitializer(
            PenguinRepository repository,
            ReaderImplementation readerImplementation,
            PenguinsCsvBeanToEntityFunction function
    ) {
        this.repository = repository;
        this.readerImplementation = readerImplementation;
        this.function = function;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (repository.count() == 0) {
            repository.saveAll(function.apply(readerImplementation.readDataFromCsv()));
        }
    }

}

