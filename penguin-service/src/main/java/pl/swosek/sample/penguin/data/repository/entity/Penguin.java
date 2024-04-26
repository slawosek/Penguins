package pl.swosek.sample.penguin.data.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
@NamedEntityGraph(
        name = Penguin.EntityGraphs.WITH_MEDIAS,
        attributeNodes = @NamedAttributeNode(Penguin_.MEDIAS)
)
public class Penguin {

    /**
     * Entity graph.
     */
    public static final class EntityGraphs {

        /**
         * Entity with attachments.
         */
        public static final String WITH_MEDIAS = "Penguin.medias";

    }

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

    /**
     * Attachments.
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "penguin")
    private List<PenguinMedia> medias;


}
