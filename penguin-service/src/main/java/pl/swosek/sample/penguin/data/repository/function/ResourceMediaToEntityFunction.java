package pl.swosek.sample.penguin.data.repository.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;

import java.io.IOException;
import java.util.function.Function;

@Component
public class ResourceMediaToEntityFunction implements Function<Resource, PenguinMedia> {

    private final FilenameToMimeTypeFunction filenameToMimeTypeFunction;

    @Autowired
    public ResourceMediaToEntityFunction(FilenameToMimeTypeFunction filenameToMimeTypeFunction) {
        this.filenameToMimeTypeFunction = filenameToMimeTypeFunction;
    }

    @Override
    public PenguinMedia apply(Resource resource) {
        try {
            return PenguinMedia.builder()
                    .bytes(resource.getContentAsByteArray())
                    .filename(resource.getFilename())
                    .mimeType(filenameToMimeTypeFunction.apply(resource.getFilename()))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
