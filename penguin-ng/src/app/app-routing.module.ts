import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PenguinTableViewComponent } from "./penguin/view/penguin-table-view/penguin-table-view.component";
import { AboutComponent } from "./info/view/about/about.component";
import { PenguinFormComponent } from "./penguin/view/penguin-form/penguin-form.component";
import { PenguinMediaSelectionComponent } from "./penguin/view/penguin-media/penguin-media-selection.component";

/**
 * Global navigation routes.
 */
const routes: Routes = [
  {
    path: 'penguin/table',
    component: PenguinTableViewComponent,
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'penguin/media',
    component: PenguinMediaSelectionComponent
  },
  {
    path: 'penguin/:taxonKey',
    component: PenguinFormComponent
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
