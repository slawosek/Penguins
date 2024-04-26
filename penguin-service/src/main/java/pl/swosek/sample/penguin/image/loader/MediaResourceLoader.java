package pl.swosek.sample.penguin.image.loader;

import lombok.extern.java.Log;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log
public class MediaResourceLoader {

    /**
     * Path to images.
     */
    public static final String PATH_TO_MEDIA = "classpath:data/media/*";

    private final ResourceLoader resourceLoader;

    public MediaResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource[] loadMediaResources() throws IOException {
        return ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(PATH_TO_MEDIA);
    }

}
