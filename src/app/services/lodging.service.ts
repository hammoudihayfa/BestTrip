import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Lodging } from '../lodging.model';  // Import your Lodging interface

@Injectable({
  providedIn: 'root'
})
export class LodgingService {
  private apiUrl = 'http://logement:8081/lodgings'; // Backend endpoint

  constructor(private http: HttpClient) {}

  // Get all lodgings with type Lodging[]
  getAllLodgings(): Observable<Lodging[]> {
    return this.http.get<Lodging[]>(this.apiUrl).pipe(
      catchError(this.handleError) // Optional error handling
    );
  }

  // Add new lodging
  addLodging(lodging: Lodging): Observable<Lodging> {
    return this.http.post<Lodging>(this.apiUrl, lodging).pipe(
      catchError(this.handleError) // Optional error handling
    );
  }

  // Handle errors in HTTP requests
  private handleError(error: any) {
    console.error('An error occurred:', error); // Log the error
    return throwError(error); // Use throwError to return the error to the caller
  }
}
