package pl.swosek.sample.penguin.data.controller.dto;

import com.opencsv.bean.CsvBindByName;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Penguin representation.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Schema(description = "Penguin representation.")
public class GetPenguinResponse {

    /**
     * Scientific name.
     */
    private String scientificName;

    /**
     * Number of occurrences.
     */
    private String numberOfOccurrences;

    /**
     * Accepted scientific name.
     */
    private String acceptedScientificName;

    /**
     * Species.
     */
    private String species;

}
