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
import { CdkTableModule } from "@angular/cdk/table";
import { MatMenu, MatMenuItem, MatMenuTrigger } from "@angular/material/menu";
import { AboutComponent } from './info/view/about/about.component';
import { PenguinFormComponent } from './penguin/view/penguin-form/penguin-form.component';
import { MatError, MatFormField, MatLabel } from "@angular/material/form-field";
import { MatInput } from "@angular/material/input";
import { ReactiveFormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AboutComponent,
    AppComponent,
    MainComponent,
    MainNavigationComponent,
    PenguinFormComponent,
    PenguinTableViewComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    CdkTableModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatError,
    MatMenu,
    MatMenuItem,
    MatMenuTrigger,
    MatFormField,
    MatInput,
    MatLabel,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
