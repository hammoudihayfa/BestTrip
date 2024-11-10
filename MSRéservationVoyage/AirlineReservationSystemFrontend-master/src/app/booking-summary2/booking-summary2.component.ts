import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AirlineReservationSystemService } from '../airline-reservation-system.service';

@Component({
  selector: 'app-booking-summary2',
  templateUrl: './booking-summary2.component.html',
  styleUrls: ['./booking-summary2.component.css']
})
export class BookingSummary2Component {
  passenger: any = null; // Initialiser à null

  constructor(private router: Router, private airlineService: AirlineReservationSystemService) {
    // Récupérer les données du passager depuis l'état de la navigation
    const navigation = this.router.getCurrentNavigation();
    this.passenger = navigation?.extras?.state?.passenger || null;

    if (this.passenger) {
      console.log('Données du passager récupérées:', this.passenger);
    } else {
      console.error('Aucune donnée de passager trouvée dans l’état de navigation');
    }
  }

  confirmBooking() {
    // Enregistrez le passager dans la base de données
    this.airlineService.addPassenger(this.passenger).subscribe(
      (response) => {
        console.log('Réservation confirmée pour :', this.passenger);
        // Redirigez vers le composant de confirmation
        this.router.navigate(['/booking-confirmation'], { state: { passenger: this.passenger } });
      },
      (error) => {
        console.error('Erreur lors de la confirmation de la réservation :', error);
      }
    );
  }
}
