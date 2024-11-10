import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AirlineReservationSystemService } from '../airline-reservation-system.service';
import { Passenger } from '../Models/Passenger';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { PassengerService } from '../passenger.service';

@Component({
  selector: 'app-add-passenger',
  templateUrl: './add-passenger.component.html',
  styleUrls: ['./add-passenger.component.css']
})
export class AddPassengerComponent implements OnInit {
  selectedTripId: number = 1; // Exemple d'ID de voyage
  bookingSummary = {
    id: 1, // Exemple d'ID de réservation
    // Ajoutez d'autres informations de réservation si nécessaire
  };
  addPassengerForm: FormGroup;
  availableSeats: number[] = [];
  foodPrefs: string[] = [];
  foodName = ['Végétarien', 'Non Végétarien', 'Vegan']; 
  chooseSeats = ['1A', '1B', '1C'];
  tripId: number; 
  manualIds: number[] = [1, 2, 3]; 
  currentIdIndex: number = 0;


  isLoading: boolean = false; 
  constructor(
    private fb: FormBuilder,
    private bookingService: PassengerService,
    private router: Router,
    private location: Location,
    private activatedRoute: ActivatedRoute // Inject ActivatedRoute to access route data
  ) {
    this.addPassengerForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      age: ['', [Validators.required, Validators.min(0)]],
      sex: ['', Validators.required],
      chooseSeats: ['', Validators.required],
      foodName: ['', Validators.required],
    });
  }
  ngOnInit() {
    console.log('Composant AddPassenger initialisé.');
    this.getFoodPreferences();
    this.getTripId(); // Récupérer le tripId lors de l'initialisation
    this.getBookingSummary(); // Récupérer le résumé de réservation
}
navigateToAddPassenger() {
  // Passez un tripId spécifique ici (par exemple, 2)
  this.router.navigate(['/add-passenger'], {
    state: { 
      data: { 
        tripId: 2, // Passez un tripId existant ici
        bookingSummary: this.bookingSummary // Ajoutez le résumé de réservation si nécessaire
      } 
    }
  });
}


getTripId() {
  const navigation = this.router.getCurrentNavigation();
  if (navigation?.extras.state?.data && navigation.extras.state.data.tripId) {
      this.tripId = navigation.extras.state.data.tripId;
      console.log('Trip ID récupéré:', this.tripId);
  } else {
      this.tripId = this.manualIds[this.currentIdIndex]; // Utiliser un ID manuel si aucun n'est trouvé
      console.error('Aucun tripId trouvé. Utilisation de l\'ID manuel:', this.tripId);
  }
}


  getFoodPreferences() {
    this.bookingService.getFoodPref().subscribe({
      next: (prefs) => {
        this.foodPrefs = prefs;
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des préférences alimentaires:', err);
      }
    });
  }

  // New method to retrieve booking summary
  getBookingSummary() {
    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras.state?.data) {
      this.bookingSummary = navigation.extras.state.data; // Assuming data contains the booking summary
      console.log('Booking Summary retrieved:', this.bookingSummary);
    } else {
      console.error('No booking summary found in navigation state');
    }
  }

  buildPassengerObj(): Passenger {
    return {
      //idPass: this.manualIds[this.currentIdIndex], 
      nom: this.addPassengerForm.value.firstName,
      prenom: this.addPassengerForm.value.lastName,
      email: this.addPassengerForm.value.email,
      age: this.addPassengerForm.value.age,
      sex: this.addPassengerForm.value.sex,
     // foodPreferences: [this.addPassengerForm.value.foodName],
      seatNumber: this.addPassengerForm.value.chooseSeats,
      tripId: this.tripId // Include the tripId here
    };
  }

  onSubmit() {
    if (!this.tripId) {
      alert('Aucun Trip ID n\'est disponible. Veuillez réessayer après avoir sélectionné un voyage.');
      return;
    }
  
    this.isLoading = true;
    console.log('Form Submitted');
    
    if (this.addPassengerForm.valid) {
      this.bookingService.show(); // Start loading indicator
      
      const passenger = this.buildPassengerObj();
      console.log('Passenger data to submit:', passenger);
  
      this.bookingService.createPassenger(passenger).subscribe({
        next: (res) => {
          console.log('Passenger added successfully');
          this.bookingService.hide(); // Stop loading indicator
          alert('Passenger added successfully!');
  
          // Utilisez l'ID de réservation de `bookingSummary`
          const bookingId = this.bookingSummary['id'];
  
          // Récupérer les détails du voyage sélectionné
          this.bookingService.getSelectedTripDetails(this.tripId).subscribe({
            next: (selectedTripDetails) => {
              console.log('Selected trip details:', selectedTripDetails);
  
              // Naviguer vers la page de résumé de la réservation
              this.router.navigate(['/booking-summary'], {
                state: {
                  data: { ...res, trip: selectedTripDetails } // Envoyer les détails de la réservation et du voyage
                }
              });
            },
            error: (err) => {
              console.error('Erreur lors de la récupération des détails du voyage :', err);
              alert('Erreur lors de la récupération des détails du voyage. Veuillez réessayer.');
            }
          });
        },
        error: (err) => {
          this.bookingService.hide(); // Stop loading indicator
          console.error('Error adding passenger:', err);
          alert('Erreur lors de l\'ajout du passager. Veuillez réessayer.');
        },
        complete: () => {
          this.isLoading = false; // Stop loading in either case
        }
      });
    } else {
      this.isLoading = false; // Stop loading when form is invalid
      console.warn('The form is invalid, please correct the errors.');
      alert('Veuillez remplir tous les champs requis.');
    }
  }
  
}
