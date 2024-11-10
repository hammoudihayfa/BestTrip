import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { FlightsViewComponent } from './flights-view/flights-view.component';
import { NoPageFoundComponent } from './no-page-found/no-page-found.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AddPassengerComponent } from './add-passenger/add-passenger.component';
import { BookingSummaryComponent } from './booking-summary/booking-summary.component';
import { LoaderComponent } from './loader/loader.component';
import { LoaderInterceptor } from './loader.interceptor';
import { TripDetailsComponent } from './trip-details/trip-details.component';
import { FormsModule } from '@angular/forms';
import { BookingSummary2Component } from './booking-summary2/booking-summary2.component';
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { AddPassenger3Component } from './add-passenger3/add-passenger3.component';
import { BookingConfirmationComponent } from './booking-confirmation/booking-confirmation.component';


@NgModule({
  declarations: [
    AppComponent,
    SearchFlightComponent,
    FlightsViewComponent,
    NoPageFoundComponent,
    AddPassengerComponent,
    BookingSummaryComponent,
    LoaderComponent,
    TripDetailsComponent,
    BookingSummary2Component,
    ConfirmationComponent,
    AddPassenger3Component,
    BookingConfirmationComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    FontAwesomeModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: LoaderInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
