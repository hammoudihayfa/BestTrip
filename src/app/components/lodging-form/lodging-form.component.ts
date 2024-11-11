// src/app/components/lodging-form/lodging-form.component.ts
import { Component } from '@angular/core';
import { LodgingService } from 'src/app/services/lodging.service';  // Import the service
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-lodging-form',
  templateUrl: './lodging-form.component.html',
  styleUrls: ['./lodging-form.component.css']
})
export class LodgingFormComponent {
  lodging = { name: '', location: '', pricePerNight: 0 };

  constructor(private lodgingService: LodgingService) {}  // Inject LodgingService

  submitLodgingForm(form: NgForm): void {
    if (form.valid) {
      console.log('Lodging submitted:', this.lodging);
      this.lodgingService.addLodging(this.lodging).subscribe(
        (response) => {
          console.log('Lodging added:', response);
          form.reset();  // Optionally reset the form after submission
        },
        (error) => {
          console.error('Error adding lodging:', error);
        }
      );
    }
  }
}

