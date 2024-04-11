import { Component, OnInit } from '@angular/core';
import { PenguinService } from "../../service/penguin.service";
import { Penguin } from "../../model/penguin";
import { Observable } from "rxjs";
import { Penguins } from "../../model/penguins";
import { PenguinTableColumns } from "../model/penguin-table-columns";

@Component({
  selector: 'app-penguin-table-view',
  templateUrl: './penguin-table-view.component.html',
  styleUrl: './penguin-table-view.component.css'
})
export class PenguinTableViewComponent {

  /**
   * Observable of potential penguins.
   */
  penguins: Observable<Penguins> = this.service.getPenguins();

  /**
   * Column references.
   */
  displayedColumns: string[] = PenguinTableColumns;

  /**
   * @param service penguin service
   */
  constructor(private service: PenguinService) {
  }

}
