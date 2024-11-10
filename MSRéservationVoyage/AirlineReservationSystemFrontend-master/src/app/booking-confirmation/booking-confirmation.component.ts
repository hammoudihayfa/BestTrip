import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking-confirmation',
  templateUrl: './booking-confirmation.component.html',
  styleUrls: ['./booking-confirmation.component.css']
})
export class BookingConfirmationComponent implements OnInit {
  passenger: any = null;

  constructor(private router: Router) {
    // Récupérer les données du passager depuis l'état de la navigation
    const navigation = this.router.getCurrentNavigation();
    this.passenger = navigation?.extras?.state?.passenger || null;

    if (this.passenger) {
      console.log('Données du passager pour confirmation:', this.passenger);
    } else {
      console.error('Aucune donnée de passager trouvée dans l’état de navigation');
    }
  }

  ngOnInit(): void {
    // Vous pouvez effectuer d'autres initialisations ici si nécessaire
  }
}
