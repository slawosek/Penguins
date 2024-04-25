package pl.swosek.sample.penguin.image.loader;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ImageResourceLoader {

    /**
     * Path to images.
     */
    public static final String PATH_TO_IMAGES = "classpath:data/photos/*";

    private final ResourceLoader resourceLoader;

    public ImageResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource[] loadImageResources() throws IOException {
        return ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(PATH_TO_IMAGES);
    }

}
