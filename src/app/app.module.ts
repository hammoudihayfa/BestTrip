// src/app/app.module.ts

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule
import { AppRoutingModule } from './app-routing.module'; // Routing module
import { AppComponent } from './app.component'; // Main component
import { LodgingFormComponent } from './components/lodging-form/lodging-form.component'; // Lodging form component
import { LodgingListComponent } from './components/lodging-list/lodging-list.component'; // Lodging list component

@NgModule({
  declarations: [
    AppComponent,
    LodgingFormComponent, // Declare lodging form component
    LodgingListComponent, // Declare lodging list component
  ],
  imports: [
    BrowserModule,
    FormsModule, // Include FormsModule for template-driven forms
    HttpClientModule, // Include HttpClientModule for HTTP requests
    AppRoutingModule, // Import routing module
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

