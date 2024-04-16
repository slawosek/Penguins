import { Injectable } from '@angular/core';
import { Penguin } from "../../model/penguin";
import { FormControl, FormGroup, Validators } from "@angular/forms";

/**
 * Penguin form service.
 */
@Injectable({
  providedIn: 'root'
})
export class PenguinFormService {

  constructor() {
  }

  /**
   * Creates penguin form from given penguin.
   *
   * @param penguin penguin
   */
  createForm(penguin: Penguin) {
    return new FormGroup({
      taxonKey: new FormControl(penguin.taxonKey, {
        validators: [Validators.required],
        nonNullable: true
      }),
      scientificName: new FormControl(penguin.scientificName, {
        validators: [Validators.required],
        nonNullable: true
      }),
      numberOfOccurrences: new FormControl(penguin.numberOfOccurrences, {
        validators: [Validators.required, Validators.min(1)],
        nonNullable: true
      }),
      acceptedScientificName: new FormControl(penguin.acceptedScientificName, {
        validators: [Validators.required],
        nonNullable: true
      }),
      species: new FormControl(penguin.species, {
        validators: [Validators.required],
        nonNullable: true
      })
    });
  }

}
