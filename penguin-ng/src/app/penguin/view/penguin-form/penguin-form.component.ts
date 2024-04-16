import { Component, OnInit } from '@angular/core';
import { PenguinService } from "../../service/penguin.service";
import { ActivatedRoute, Router } from "@angular/router";
import { map } from "rxjs";
import { PenguinForm } from "../form/penguin-form.types";
import { PenguinFormService } from "../form/penguin-form.service";

/**
 * Penguin form component.
 */
@Component({
  selector: 'app-penguin-form',
  templateUrl: './penguin-form.component.html',
  styleUrl: './penguin-form.component.css'
})
export class PenguinFormComponent implements OnInit {

  /**
   * Form.
   */
  form!: PenguinForm;

  /**
   * @param service penguin service
   * @param route current route
   * @param router router service
   * @param formService form service
   */
  constructor(
    private service: PenguinService,
    private route: ActivatedRoute,
    private router: Router,
    private formService: PenguinFormService
  ) {
  }

  /**
   * Form initialization.
   */
  ngOnInit() {
    this.route.params
      .pipe(map((params) => params['taxonKey']))
      .subscribe((taxonKey) => {
        this.service.getPenguin(taxonKey).subscribe(penguin => {
          this.form = this.formService.createForm(penguin);
        });
      });
  }

  /**
   * On submit operations.
   */
  onSubmit() {
    this.service.putPenguin(
      {
        scientificName: this.form.controls.scientificName.getRawValue(),
        numberOfOccurrences: this.form.controls.numberOfOccurrences.getRawValue(),
        acceptedScientificName: this.form.controls.acceptedScientificName.getRawValue(),
        species: this.form.controls.species.getRawValue()
      },
      this.form.controls.taxonKey.getRawValue()
    ).subscribe({
      next: () => this.router.navigate(['penguin/table']),
      error: () => alert('Penguin was NOT saved!')
    })
  }

}
