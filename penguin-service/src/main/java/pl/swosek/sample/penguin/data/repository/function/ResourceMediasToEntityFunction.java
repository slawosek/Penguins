package pl.swosek.sample.penguin.data.repository.function;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Component
public class ResourceMediasToEntityFunction implements Function<Resource[], List<PenguinMedia>> {

    ResourceMediaToEntityFunction function;

    @Autowired
    public ResourceMediasToEntityFunction(ResourceMediaToEntityFunction function) {
        this.function = function;
    }

    @Override
    public List<PenguinMedia> apply(Resource[] resources) {
        return Arrays.stream(resources)
                .map(function)
                .toList();
    }

}
