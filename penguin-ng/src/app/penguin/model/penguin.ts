/**
 * Penguin model.
 */
export interface Penguin {

  /**
   * Taxon key used as ID.
   */
  taxonKey: string;

  /**
   * Scientific name.
   */
  scientificName: string ;

  /**
   * Number of occurrences.
   */
  numberOfOccurrences: number;

  /**
   * Accepted scientific name.
   */
  acceptedScientificName: string;

  /**
   * Species.
   */
  species: string;

}
