import { Component, Input } from '@angular/core';
import { ImageInfo } from "../../model/image-info";

@Component({
  selector: 'app-penguin-image',
  templateUrl: './penguin-image.component.html',
  styleUrl: './penguin-image.component.css'
})
export class PenguinImageComponent {

  @Input()
  imageInfo!: ImageInfo;

}
