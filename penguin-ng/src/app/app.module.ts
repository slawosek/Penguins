import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PenguinTableViewComponent } from './penguin/view/penguin-table-view/penguin-table-view.component';
import { HttpClientModule } from "@angular/common/http";
import { MatTableModule } from "@angular/material/table";
import { MainComponent } from './layout/main/main.component';
import { MainNavigationComponent } from './layout/main-navigation/main-navigation.component';
import { MatButtonModule } from "@angular/material/button";
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import {
  CdkCell,
  CdkCellDef,
  CdkColumnDef,
  CdkHeaderCell,
  CdkHeaderCellDef, CdkHeaderRow,
  CdkHeaderRowDef, CdkRow,
  CdkRowDef, CdkTable
} from "@angular/cdk/table";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    MainNavigationComponent,
    PenguinTableViewComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    CdkHeaderCell,
    CdkCell,
    CdkColumnDef,
    CdkHeaderRowDef,
    CdkRowDef,
    CdkCellDef,
    CdkHeaderCellDef,
    CdkHeaderRow,
    CdkRow,
    CdkTable
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
