import { FormControl, FormGroup } from "@angular/forms";

/**
 * Penguin form.
 */
export type PenguinForm = FormGroup<{
  taxonKey: FormControl<string>,
  scientificName: FormControl<string>,
  numberOfOccurrences: FormControl<number>,
  acceptedScientificName: FormControl<string>,
  species: FormControl<string>
}>;
