package pl.swosek.sample.penguin.data.repository.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

/**
 * Converts filename {@link String} to {@link MediaType}.
 */
@Component
public class FilenameToMimeTypeFunction implements Function<String, MediaType> {

    /**
     * Converts extension {@link String} to {@link MediaType}.
     */
    private final ExtensionToMimeTypeFunction extensionToMimeTypeFunction;

    @Autowired
    public FilenameToMimeTypeFunction(ExtensionToMimeTypeFunction extensionToMimeTypeFunction) {
        this.extensionToMimeTypeFunction = extensionToMimeTypeFunction;
    }

    @Override
    public MediaType apply(String filename) {
        return this.extensionToMimeTypeFunction.apply(parseExtension(filename));
    }

    /**
     * Obtains extension from filename.
     *
     * @param filename filename
     * @return file extension
     */
    public String parseExtension(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1).toLowerCase())
                .get();
    }

}
