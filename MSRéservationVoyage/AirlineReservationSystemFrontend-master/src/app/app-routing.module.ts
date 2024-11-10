import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { FlightsViewComponent } from './flights-view/flights-view.component';
import { NoPageFoundComponent } from './no-page-found/no-page-found.component';
import { AddPassengerComponent } from './add-passenger/add-passenger.component';
import { BookingSummaryComponent } from './booking-summary/booking-summary.component';
import { BookingSummary2Component } from './booking-summary2/booking-summary2.component';
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { AddPassenger3Component } from './add-passenger3/add-passenger3.component';
import { BookingConfirmationComponent } from './booking-confirmation/booking-confirmation.component';

const routes: Routes = [
  { path: '', redirectTo: '/search-flight', pathMatch: 'full' },
  { path: 'search-flight', component: SearchFlightComponent },
  { path: 'flights-view', component: FlightsViewComponent },
  { path: 'add-passenger', component: AddPassengerComponent },
  { path: 'passenger', component: AddPassenger3Component },
  { path: 'booking', component: BookingSummary2Component },
  { path: 'booking-confirmation', component:BookingConfirmationComponent },
  { path: 'confirmation', component: ConfirmationComponent },
  { path: 'booking-summary', component: BookingSummaryComponent },
  { path: '**', component: NoPageFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
