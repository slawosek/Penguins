package pl.swosek.sample.penguin.data.repository.initializer;

import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.parser.ReaderImplementation;
import pl.swosek.sample.penguin.data.repository.api.ImageRepository;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;
import pl.swosek.sample.penguin.data.repository.entity.PenguinImage;
import pl.swosek.sample.penguin.data.repository.function.PenguinsCsvBeanAndImagesToEntityFunction;
import pl.swosek.sample.penguin.data.repository.function.ResourceImagesToEntityFunction;
import pl.swosek.sample.penguin.image.loader.ImageResourceLoader;

import java.util.List;
import java.util.logging.Level;

/**
 * Penguin data initializer.
 */
@Component
@Log
public class DataInitializer implements InitializingBean {

    /**
     * Penguin repository.
     */
    private final PenguinRepository penguinRepository;

    /**
     * Csv reader implementation.
     */
    private final ReaderImplementation readerImplementation;

    /**
     * Converter function.
     */
    private final PenguinsCsvBeanAndImagesToEntityFunction penguinsCsvBeanToEntityFunction;

    /**
     * Image resource loader.
     */
    private final ImageResourceLoader imageResourceLoader;

    private final ResourceImagesToEntityFunction resourceImagesToEntityFunction;

    private final ImageRepository imageRepository;

    @Autowired
    public DataInitializer(
            PenguinRepository penguinRepository,
            ReaderImplementation readerImplementation,
            PenguinsCsvBeanAndImagesToEntityFunction penguinsCsvBeanToEntityFunction,
            ImageResourceLoader imageResourceLoader,
            ResourceImagesToEntityFunction resourceImagesToEntityFunction, ImageRepository imageRepository
    ) {
        this.penguinRepository = penguinRepository;
        this.readerImplementation = readerImplementation;
        this.penguinsCsvBeanToEntityFunction = penguinsCsvBeanToEntityFunction;
        this.imageResourceLoader = imageResourceLoader;
        this.resourceImagesToEntityFunction = resourceImagesToEntityFunction;
        this.imageRepository = imageRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (penguinRepository.count() == 0) {
            List<PenguinImage> penguinImages = resourceImagesToEntityFunction.apply(imageResourceLoader.loadImageResources());
            List<Penguin> penguins = penguinsCsvBeanToEntityFunction.apply(readerImplementation.readDataFromCsv(), penguinImages);
            penguins.forEach(penguin -> penguin.getImages().forEach(image -> image.setPenguin(penguin)));
            penguinRepository.saveAll(penguins);
            imageRepository.saveAll(penguinImages);
        }
    }

}

