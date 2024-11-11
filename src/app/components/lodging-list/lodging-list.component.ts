import { Component, OnInit } from '@angular/core';
import { LodgingService } from 'src/app/services/lodging.service';  // Assuming you have a service to fetch lodgings

@Component({
  selector: 'app-lodging-list',
  templateUrl: './lodging-list.component.html',
  styleUrls: ['./lodging-list.component.css']
})
export class LodgingListComponent implements OnInit {
  lodgings: any[] = [];

  constructor(private lodgingService: LodgingService) {}

  ngOnInit(): void {
    this.lodgingService.getAllLodgings().subscribe((data: any[]) => {
      this.lodgings = data;
    });
  }
}


