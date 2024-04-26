import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { map } from "rxjs";
import { PenguinService } from "../../service/penguin.service";

@Component({
  selector: 'app-penguin-media-display',
  templateUrl: './penguin-media-display.component.html',
  styleUrl: './penguin-media-display.component.css'
})
export class PenguinMediaDisplayComponent implements OnInit {

  source!: string;

  constructor(
    private route: ActivatedRoute,
    private service: PenguinService
  ) {
  }

  ngOnInit(): void {
    this.route.params
      .pipe(map((params) => params['taxonKey']))
      .subscribe((taxonKey) => this.service.getVideoInfo(taxonKey)
        .subscribe(info => this.source = info.source)
      );
  }

}
