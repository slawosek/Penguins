package pl.swosek.sample.penguin.data.repository.function;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.repository.entity.PenguinImage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Component
public class ResourceImagesToEntityFunction implements Function<Resource[], List<PenguinImage>> {

    ResourceImageToEntityFunction function;

    @Autowired
    public ResourceImagesToEntityFunction(ResourceImageToEntityFunction function) {
        this.function = function;
    }

    @Override
    public List<PenguinImage> apply(Resource[] resources) {
        return Arrays.stream(resources)
                .map(function)
                .toList();
    }

}
