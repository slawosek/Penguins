import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PenguinTableViewComponent } from './penguin/view/penguin-table-view/penguin-table-view.component';
import { HttpClientModule } from "@angular/common/http";
import { MatTableModule } from "@angular/material/table";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    PenguinTableViewComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
