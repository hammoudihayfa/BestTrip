import { Component } from '@angular/core';
import { PassengerService } from '../passenger.service'; // Assurez-vous que le chemin est correct
import { Router } from '@angular/router'; // Importez Router

@Component({
  selector: 'app-add-passenger3',
  templateUrl: './add-passenger3.component.html',
  styleUrls: ['./add-passenger3.component.css']
})
export class AddPassenger3Component {
  passenger = {
    nom: '',
    prenom: '',
    email: '',
    age: null,
    sex: '',
    seatNumber: '',
    foodPreferences: [],
    tripId: null
  };
  
  isSubmitted = false;

  // Injection du service Router en plus de PassengerService
  constructor(private passengerService: PassengerService, private router: Router) {}

  onSubmit() {
    this.isSubmitted = true;
  
    // Appelle createPassenger pour envoyer les données au backend
    this.passengerService.createPassenger(this.passenger).subscribe(
      (response) => {
        console.log('Passager créé avec succès:', response);
        
        // Redirige vers /booking et passe les données du passager comme état
        this.router.navigate(['/booking'], { state: { passenger: response } });
      },
      (error) => {
        console.error('Erreur lors de la création du passager:', error);
      }
    );
  }
}
