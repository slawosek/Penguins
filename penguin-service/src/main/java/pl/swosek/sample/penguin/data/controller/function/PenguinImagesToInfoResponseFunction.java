package pl.swosek.sample.penguin.data.controller.function;

import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinImagesInfo;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;

import java.util.List;
import java.util.function.Function;

@Component
public class PenguinImagesToInfoResponseFunction implements Function<List<PenguinMedia>, GetPenguinImagesInfo> {

    private final PenguinImageToInfoResponseFunction function;

    public PenguinImagesToInfoResponseFunction(PenguinImageToInfoResponseFunction function) {
        this.function = function;
    }

    @Override
    public GetPenguinImagesInfo apply(List<PenguinMedia> penguinsMedia) {
        return GetPenguinImagesInfo.builder()
                .imagesInfo(penguinsMedia.stream()
                        .map(function)
                        .toList())
                .build();
    }

}
