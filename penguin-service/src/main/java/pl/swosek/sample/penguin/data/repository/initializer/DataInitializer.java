package pl.swosek.sample.penguin.data.repository.initializer;

import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.csv.parser.ReaderImplementation;
import pl.swosek.sample.penguin.data.repository.api.MediaRepository;
import pl.swosek.sample.penguin.data.repository.api.PenguinRepository;
import pl.swosek.sample.penguin.data.repository.entity.Penguin;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;
import pl.swosek.sample.penguin.data.repository.function.PenguinsCsvBeanAndMediaToEntityFunction;
import pl.swosek.sample.penguin.data.repository.function.ResourceMediasToEntityFunction;
import pl.swosek.sample.penguin.image.loader.MediaResourceLoader;

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
    private final PenguinsCsvBeanAndMediaToEntityFunction penguinsCsvBeanToEntityFunction;

    /**
     * Image resource loader.
     */
    private final MediaResourceLoader mediaResourceLoader;

    private final ResourceMediasToEntityFunction resourceMediasToEntityFunction;

    private final MediaRepository mediaRepository;

    @Autowired
    public DataInitializer(
            PenguinRepository penguinRepository,
            ReaderImplementation readerImplementation,
            PenguinsCsvBeanAndMediaToEntityFunction penguinsCsvBeanToEntityFunction,
            MediaResourceLoader mediaResourceLoader,
            ResourceMediasToEntityFunction resourceMediasToEntityFunction, MediaRepository mediaRepository
    ) {
        this.penguinRepository = penguinRepository;
        this.readerImplementation = readerImplementation;
        this.penguinsCsvBeanToEntityFunction = penguinsCsvBeanToEntityFunction;
        this.mediaResourceLoader = mediaResourceLoader;
        this.resourceMediasToEntityFunction = resourceMediasToEntityFunction;
        this.mediaRepository = mediaRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (penguinRepository.count() == 0) {
            List<PenguinMedia> penguinMedia = resourceMediasToEntityFunction.apply(mediaResourceLoader.loadMediaResources());
            log.log(Level.WARNING, penguinMedia.get(0).getFilename());
            List<Penguin> penguins = penguinsCsvBeanToEntityFunction.apply(readerImplementation.readDataFromCsv(), penguinMedia);
            penguins.forEach(penguin -> penguin.getMedias().forEach(media -> media.setPenguin(penguin)));
            penguinRepository.saveAll(penguins);
            mediaRepository.saveAll(penguinMedia);
        }
    }

}

