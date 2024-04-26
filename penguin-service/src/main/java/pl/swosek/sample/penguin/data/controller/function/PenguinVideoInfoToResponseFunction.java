package pl.swosek.sample.penguin.data.controller.function;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.controller.api.PenguinMediaController;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinVideoInfo;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;

import java.util.function.Function;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PenguinVideoInfoToResponseFunction implements Function<PenguinMedia, GetPenguinVideoInfo> {

    @Override
    public GetPenguinVideoInfo apply(PenguinMedia penguinMedia) {
        return GetPenguinVideoInfo.builder()
                .source(WebMvcLinkBuilder.linkTo(methodOn(PenguinMediaController.class)
                                .getPenguinImage(penguinMedia.getPenguin().getTaxonKey()))
                        .toUri())
                .build();
    }

}
