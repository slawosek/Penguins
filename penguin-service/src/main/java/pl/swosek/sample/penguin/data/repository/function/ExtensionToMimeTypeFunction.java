package pl.swosek.sample.penguin.data.repository.function;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Converts extension {@link String} to {@link MediaType}.
 */
@Component
public class ExtensionToMimeTypeFunction implements Function<String, MediaType> {

    @Override
    public MediaType apply(String extension) {
        return switch (extension) {
            case "jpg", "jpeg" -> MediaType.IMAGE_JPEG;
            case "png" -> MediaType.IMAGE_PNG;
            default -> MediaType.APPLICATION_PROBLEM_JSON;
        };
    }

}
