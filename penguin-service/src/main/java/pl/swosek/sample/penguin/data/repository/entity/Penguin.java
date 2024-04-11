package pl.swosek.sample.penguin.data.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Penguin entity.
 */
@Entity
@Table(name = "penguins")
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Penguin {

    /**
     * Taxon key.
     */
    @Id
    private String taxonKey;

    /**
     * Scientific name.
     */
    private String scientificName;

    /**
     * Number of occurrences.
     */
    private Integer numberOfOccurrences;

    /**
     * Accepted scientific name.
     */
    private String acceptedScientificName;

    /**
     * Species.
     */
    private String species;


}
