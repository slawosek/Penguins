package pl.swosek.sample.penguin.data.repository.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.repository.entity.PenguinImage;

import java.io.IOException;
import java.util.function.Function;

@Component
public class ResourceImageToEntityFunction implements Function<Resource,PenguinImage> {

    private final FilenameToMimeTypeFunction filenameToMimeTypeFunction;

    @Autowired
    public ResourceImageToEntityFunction(FilenameToMimeTypeFunction filenameToMimeTypeFunction) {
        this.filenameToMimeTypeFunction = filenameToMimeTypeFunction;
    }

    @Override
    public PenguinImage apply(Resource resource) {
        try {
            return PenguinImage.builder()
                    .bytes(resource.getContentAsByteArray())
                    .filename(resource.getFilename())
                    .mimeType(filenameToMimeTypeFunction.apply(resource.getFilename()))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
