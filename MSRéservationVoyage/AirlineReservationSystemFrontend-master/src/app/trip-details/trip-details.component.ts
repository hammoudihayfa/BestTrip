import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirlineReservationSystemService } from '../airline-reservation-system.service';

@Component({
  selector: 'app-trip-details',
  templateUrl: './trip-details.component.html',
  styleUrls: ['./trip-details.component.css']
})
export class TripDetailsComponent implements OnInit {

  trip: any; // Assurez-vous que les détails du voyage sont disponibles ici

  constructor(private router: Router, private tripService: AirlineReservationSystemService) { }

  ngOnInit() {
    this.getTripDetails();
  }

  getTripDetails() {
    this.tripService.getTrip().subscribe(res => {
        this.trip = res[0]; // ou la logique pour obtenir le bon trip
        console.log('Trip details: ', this.trip);
    }, err => {
        console.error('Error fetching trip details: ', err);
    });
}


  getTripId(): number {
    return this.trip ? this.trip.id : -1; // Remplacez `id` par la clé appropriée de votre objet `trip`
  }

  navigateToAddPassenger() {
    const tripId = this.getTripId();
    if (tripId !== -1) {
        const routeData = { trip: this.trip, tripId: tripId }; // Assurez-vous que `this.trip` contient les bonnes données
        this.router.navigate(['/add-passenger'], { state: { data: routeData } });
    } else {
        console.error('Trip is not defined, cannot navigate.');
    }
}


}
