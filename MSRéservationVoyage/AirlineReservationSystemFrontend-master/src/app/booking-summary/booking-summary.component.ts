import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AirlineReservationSystemService } from '../airline-reservation-system.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-booking-summary',
  templateUrl: './booking-summary.component.html',
  styleUrls: ['./booking-summary.component.css']
})
export class BookingSummaryComponent implements OnInit {
  state$: Observable<object>;
  bookingSummary: any = {};
  bookingResponse: any = undefined;
  trip: any; // Déclaration de la variable trip
  passenger: any; // Déclaration de la variable passenger
  manualIds: number[] = [201, 202, 203]; 
  currentBookingIdIndex: number = 0; 

  constructor(
    private airlineService: AirlineReservationSystemService,
    private activatedRoute: ActivatedRoute,
    private router: Router // Ajout du Router ici
  ) {}

  ngOnInit(): void {
    this.getRouteData(); // Récupérer les données de l'état
}


  getRouteData() {
    this.state$ = this.activatedRoute.paramMap.pipe(map(() => window.history.state));
    this.state$.subscribe(res => {
        console.log("Full state received: ", res);
        if (res && res['data']) {
            this.bookingSummary = res['data'];
            console.log("Booking Summary: ", this.bookingSummary);
            // Vérifiez si 'trip' et 'trip.id' existent
            if (!this.bookingSummary.trip || !this.bookingSummary.trip.id) {
                console.error('Trip or trip ID is missing in booking summary');
                // Gérer cette situation, par exemple rediriger ou afficher un message d'erreur
            }
        } else {
            console.error('No data found in the state');
        }
    });
}



selectDepartingFlight() {
  // Utilisation de l'ID manuel
  const tripId = this.bookingSummary['trip']['id'];
  const passengerId = this.manualIds[this.currentBookingIdIndex]; // Utilisation de l'ID de la liste manuelle

  let obj = {
    'book_type': "One-Way",
    'trip_id': tripId,
    'passenger_id': passengerId // Utiliser l'ID de la liste manuelle ici
  };
  
  this.bookingResponse = undefined;

  this.airlineService.makeBooking(obj).subscribe(res => {
    console.log(res);
    this.bookingResponse = res;
  }, err => {
    console.log(err);
  });
}

  updateFlight() {
    const bookingId = this.bookingSummary['id'];
    const updatedData = {
      'book_type': "One-Way",
      'trip_id': this.bookingSummary['trip']['id'],
      'passenger_id': this.bookingSummary['passenger']['id'],
    };

    this.bookingResponse = undefined;

    this.airlineService.updateBooking(bookingId, updatedData).subscribe(res => {
      console.log('Booking updated successfully:', res);
      this.bookingResponse = res;
    }, err => {
      console.error('Error updating booking:', err);
    });
  }
}
