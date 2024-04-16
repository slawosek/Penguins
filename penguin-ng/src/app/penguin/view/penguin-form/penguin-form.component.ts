import { Component, OnInit } from '@angular/core';
import { PenguinService } from "../../service/penguin.service";
import { ActivatedRoute, Router } from "@angular/router";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { map } from "rxjs";
import { PenguinForm } from "../form/penguin-form.types";

@Component({
  selector: 'app-penguin-form',
  templateUrl: './penguin-form.component.html',
  styleUrl: './penguin-form.component.css'
})
export class PenguinFormComponent implements OnInit {

  /**
   * Form.
   */
  form: PenguinForm = new FormGroup({
    taxonKey: new FormControl('',{
      validators: [Validators.required],
      nonNullable: true
    }),
    scientificName: new FormControl('', {
      validators: [Validators.required],
      nonNullable: true
    }),
    numberOfOccurrences: new FormControl(1, {
      validators: [Validators.required, Validators.min(1)],
      nonNullable: true
    }),
    acceptedScientificName: new FormControl('', {
      validators: [Validators.required],
      nonNullable: true
    }),
    species: new FormControl('', {
      validators: [Validators.required],
      nonNullable: true
    })
  });

  /**
   * @param service penguin service
   * @param route current route
   * @param router router service
   */
  constructor(private service: PenguinService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  /**
   * Form initialization.
   */
  ngOnInit() {
    this.route.params
      .pipe(map((params) => params['taxonKey']))
      .subscribe((taxonKey) => {
        this.service.getPenguin(taxonKey).subscribe(penguin => {
          this.form.patchValue(penguin);
        });
      });
  }

  /**
   * On submit operations.
   */
  onSubmit() {

  }

}
