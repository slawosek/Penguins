package pl.swosek.sample.penguin.data.controller.function;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import pl.swosek.sample.penguin.data.controller.api.PenguinMediaController;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinImageInfo;
import pl.swosek.sample.penguin.data.repository.entity.PenguinMedia;

import java.util.function.Function;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PenguinImageToInfoResponseFunction implements Function<PenguinMedia, GetPenguinImageInfo> {

    @Override
    public GetPenguinImageInfo apply(PenguinMedia penguinMedia) {
        return GetPenguinImageInfo.builder()
                .uuid(penguinMedia.getUuid())
                .penguinSpecie(penguinMedia.getPenguin().getSpecies())
                .penguinTaxonKey(penguinMedia.getPenguin().getTaxonKey())
                .filename(penguinMedia.getFilename())
                .source(WebMvcLinkBuilder.linkTo(methodOn(PenguinMediaController.class)
                                .getPenguinImage(penguinMedia.getPenguin().getTaxonKey()))
                        .toUri())
                .build();
    }

}
