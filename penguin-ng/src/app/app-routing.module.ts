import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

/**
 * Global navigation routes.
 */
const routes: Routes = [
];

/**
 * Global application routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
