import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { catchError, tap, finalize } from 'rxjs/operators';
import { Passenger } from './Models/Passenger';
@Injectable({
  providedIn: 'root'
})
export class PassengerService {

  private baseUrl = 'http://localhost:8086/passengers';
  private passengers: Passenger[] = []; // Stocker les passagers localement
  public isLoading = new BehaviorSubject<boolean>(false);


  constructor(private http: HttpClient) {}

  getPassengers(): Observable<Passenger[]> {
    return this.http.get<Passenger[]>(this.baseUrl)
      .pipe(
        tap((data) => {
          this.passengers = data; // Stocke les passagers localement
          console.log('Fetched passengers');
        }),
        catchError(this.handleError<Passenger[]>('getPassengers', []))
      );
  }

  setPassengers(passengers: Passenger[]): void {
    this.passengers = passengers; // Met à jour la liste des passagers localement
  }

  createPassenger(data: Passenger): Observable<Passenger> {
    return this.http.post<Passenger>(this.baseUrl, data)
      .pipe(
        tap(() => console.log('Created passenger')),
        catchError(this.handleError<Passenger>('createPassenger'))
      );
  }

  deletePassenger(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`)
      .pipe(
        tap(() => console.log(`Deleted passenger with id=${id}`)),
        catchError(this.handleError('deletePassenger'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  // Méthode pour obtenir les préférences alimentaires
  getFoodPref(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/passengers/food-preferences`)
      .pipe(
        tap(foodPrefs => console.log('Fetched food preferences')),
        catchError(this.handleError('getFoodPref', []))
      );
  }

  // Méthode pour obtenir les sièges disponibles pour un passager
  getAvailableSeats(idPass: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/passengers/${idPass}/available-seats`)
      .pipe(
        tap(seats => console.log('Fetched available seats for passenger:', idPass)),
        catchError(this.handleError('getAvailableSeats', []))
      );
  }
  show() {
    console.log("Loading started");
    this.isLoading.next(true);
  }

  hide() {
    console.log("Loading stopped");
    this.isLoading.next(false);
  }
  getSelectedTripDetails(tripId: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/bookings/trips/${tripId}`)
      .pipe(
        tap(trip => console.log('Fetched trip details:', trip)),
        catchError(this.handleError<any>('getSelectedTripDetails'))
      );
  }
}
