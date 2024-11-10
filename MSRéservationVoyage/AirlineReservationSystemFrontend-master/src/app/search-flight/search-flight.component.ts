import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {
  searchFlightForm: FormGroup;
  modifyFlightForm: FormGroup;
  departureRoutes: any[] = []; 
  arrivalRoutes: any[] = []; 
  booking: any = undefined;
  faCalendarAlt: any; 

  // Déclarer 'flights' comme une propriété de la classe sans 'const'
  flights = [
    {
        route: 'Berlin-Londres',
        departure_time: '10:00 AM',
        arrival_time: '12:00 PM',
        company: 'British Airways',
        price: 150
    },
    {
        route: 'Berlin-Londres',
        departure_time: '1:00 PM',
        arrival_time: '3:00 PM',
        company: 'Lufthansa',
        price: 180
    },
    {
        route: 'Berlin-Londres',
        departure_time: '4:00 PM',
        arrival_time: '6:00 PM',
        company: 'easyJet',
        price: 130
    },
    {
        route: 'Madrid-Rome',
        departure_time: '9:00 AM',
        arrival_time: '11:00 AM',
        company: 'Iberia',
        price: 120
    },
    {
        route: 'Madrid-Rome',
        departure_time: '2:00 PM',
        arrival_time: '4:00 PM',
        company: 'Vueling',
        price: 115
    },
    {
        route: 'New York-Paris',
        departure_time: '6:00 PM',
        arrival_time: '7:30 AM',
        company: 'Air France',
        price: 600
    },
    {
        route: 'New York-Paris',
        departure_time: '8:00 PM',
        arrival_time: '9:30 AM',
        company: 'Delta Airlines',
        price: 650
    },
    {
        route: 'Tokyo-Seoul',
        departure_time: '11:00 AM',
        arrival_time: '1:00 PM',
        company: 'Korean Air',
        price: 200
    },
    {
        route: 'Tokyo-Seoul',
        departure_time: '5:00 PM',
        arrival_time: '7:00 PM',
        company: 'Asiana Airlines',
        price: 210
    }
  ];

  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.createForms();
  }

  createForms() {
    this.searchFlightForm = this.fb.group({
      departureCity: [''],
      arrivalCity: [''],
      departDate: [''],
      mealPreference: ['Pas de préférence'] // Valeur par défaut
    });

    this.modifyFlightForm = this.fb.group({
      modifyBooking: ['']
    });
  }

  getFlights() {
    if (this.searchFlightForm.valid) {
      const departureCity = this.searchFlightForm.value.departureCity;
      const arrivalCity = this.searchFlightForm.value.arrivalCity;

      if (!departureCity || !arrivalCity) {
        console.error("Departure or Arrival city is not defined.");
        return;
      }

      const route = `${departureCity}-${arrivalCity}`;
      const matchingFlights = this.flights.filter(flight => flight.route.toLowerCase() === route.toLowerCase());

      if (matchingFlights.length > 0) {
        this.router.navigate(['/flights-view'], { state: { data: matchingFlights } });
      } else {
        console.error("No flights found for the selected route.");
      }
    } else {
      console.error('Form is invalid:', this.searchFlightForm.errors);
    }
  }

  getDepartureRoutesOnPage() {
    console.log("Getting departure routes");
  }

  getArrivalRoutesOnPage() {
    console.log("Getting arrival routes");
  }

  getFlightBooking() {
    console.log("Getting flight booking");
  }
}
