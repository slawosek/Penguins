package pl.swosek.sample.penguin.csv.bean;

import com.opencsv.bean.CsvBindByName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Bean for mapping csv parsing.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PenguinCsvBean {

    @CsvBindByName
    private String taxonKey;

    @CsvBindByName
    private String scientificName;

    @CsvBindByName
    private String acceptedTaxonKey;

    @CsvBindByName
    private Integer numberOfOccurrences;

    @CsvBindByName
    private String acceptedScientificName;

    @CsvBindByName
    private String taxonRank;

    @CsvBindByName
    private String taxonomicStatus;

    @CsvBindByName
    private String kingdom;

    @CsvBindByName
    private String kingdomKey;

    @CsvBindByName
    private String phylum;

    @CsvBindByName
    private String phylumKey;

    @CsvBindByName(column = "class")
    private String biologicalClass;

    @CsvBindByName
    private String classKey;

    @CsvBindByName
    private String order;

    @CsvBindByName
    private String orderKey;

    @CsvBindByName
    private String family;

    @CsvBindByName
    private String familyKey;

    @CsvBindByName
    private String genus;

    @CsvBindByName
    private String genusKey;

    @CsvBindByName
    private String species;

    @CsvBindByName
    private String speciesKey;

    @CsvBindByName
    private String iucnRedListCategory;

}

