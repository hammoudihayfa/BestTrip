import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AirlineReservationSystemService } from '../airline-reservation-system.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

interface Flight {
  route_id: {
    departure_city: string;
    arrival_city: string;
  };
  departure_time: string;
  arrival_time: string;
  plane_id: {
    company: string;
  };
}

interface TripId {
  route_id: {
    id: number; // Assurez-vous que l'id est un nombre
    departure_city: string;
    arrival_city: string;
  };
  departure_time: string;
  arrival_time: string;
}

interface Booking {
  id: string; // Vérifiez si c'est le bon type
  trip_id: TripId; // Modifiez ici pour le type correct
  date: string;
  passenger_id: any; // Ajustez selon le type
}

interface State {
  data?: Flight[];
  booking?: Booking[];
}

@Component({
  selector: 'app-flights-view',
  templateUrl: './flights-view.component.html',
  styleUrls: ['./flights-view.component.css']
})
export class FlightsViewComponent implements OnInit {
  state$: Observable<State>;
  flights: Flight[] = [];
  booking: Booking[] = []; // Initialisation correcte
  dates: any[] = []; // Initialisation correcte

  constructor(private airlineService: AirlineReservationSystemService, public activatedRoute: ActivatedRoute,
              private router: Router) {}

  ngOnInit(): void {
    this.state$ = this.activatedRoute.paramMap.pipe(map(() => window.history.state as State));
    this.state$.subscribe(res => {
      this.flights = res?.data || [];
      this.booking = res?.booking || []; // Initialisation correcte
      if (this.booking.length > 0) {
        this.getDatesForBookedFlight(this.booking[0].trip_id.route_id.id); // Assurez-vous que c'est un nombre
      }
    });
  }

  getDatesForBookedFlight(tripId: number) {
    this.airlineService.getFlights(tripId).subscribe(
      res => this.dates = res || [],
      err => console.error(err)
    );
  }

  selectDepartingFlight(flight: Flight) {
    this.router.navigate(['/passenger'], { state: { data: flight } });
  }

  selectFlight(changedDate: string) {
    const trip = this.getTrip(changedDate);
    if (trip) {
      const routeData = {
        id: Number(this.booking[0].id), // Convertir l'id en nombre si nécessaire
        trip: trip,
        passenger: this.booking[0].passenger_id,
        changedDate: changedDate
      };
      this.router.navigate(['/booking-summary'], { state: { data: routeData } });
    }
  }

  getTrip(date: string) {
    return this.dates?.find(object => object.date === date);
  }

  cancelFlight() {
    const bookingId = Number(this.booking[0].id); // Convertir l'id en nombre si nécessaire
    this.airlineService.deleteBooking(bookingId).subscribe(
      res => {
        console.log("Booking is deleted", res);
        this.booking = [];
      },
      err => console.error(err)
    );
  }
}
