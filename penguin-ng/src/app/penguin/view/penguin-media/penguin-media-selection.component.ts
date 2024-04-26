import { Component, OnInit } from '@angular/core';
import { PenguinService } from "../../service/penguin.service";
import { ImageInfo } from "../../model/image-info";

@Component({
  selector: 'app-penguin-media',
  templateUrl: './penguin-media-selection.component.html',
  styleUrl: './penguin-media-selection.component.css'
})
export class PenguinMediaSelectionComponent implements OnInit {

  imagesInfo!: ImageInfo[];

  constructor(private penguinService: PenguinService) {
  }

  ngOnInit(): void {
    this.penguinService.getImagesInfo()
      .subscribe(imagesInfo => {
        this.imagesInfo = imagesInfo.imagesInfo;
      });
  }


}
