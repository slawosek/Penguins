package pl.swosek.sample.penguin.data.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.net.URI;
import java.util.UUID;

/**
 * Penguins representation.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Schema(description = "Penguin image information representation.")
public class GetPenguinImageInfo {

    private UUID uuid;

    private String penguinSpecie;

    private String filename;

    private String penguinTaxonKey;

    private URI source;

}
