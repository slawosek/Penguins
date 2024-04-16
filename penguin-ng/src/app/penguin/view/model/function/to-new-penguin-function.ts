import { PenguinFormRawValue } from "../penguin-form-raw-value";
import { NewPenguin } from "../../../model/new-penguin";

/**
 * Converts {@link PenguinFormRawValue} to {@link NewPenguin}.
 */
export class ToNewPenguinFunction {

  apply(raw: PenguinFormRawValue): NewPenguin {
    return {
      scientificName: raw.scientificName,
      numberOfOccurrences: raw.numberOfOccurrences,
      acceptedScientificName: raw.acceptedScientificName,
      species: raw.species
    }
  }

}
