import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PenguinTableViewComponent } from "./penguin/view/penguin-table-view/penguin-table-view.component";

/**
 * Global navigation routes.
 */
const routes: Routes = [
  {
    path: 'penguin/table',
    component: PenguinTableViewComponent,
  }
];

/**
 * Global application routing module.
 */
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
