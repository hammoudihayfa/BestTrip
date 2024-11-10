import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, of, Subject ,throwError} from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AirlineReservationSystemService {

  private baseUrl = 'http://localhost:8086'; // Assurez-vous que l'URL est correcte
  isLoading = new Subject<boolean>();

  constructor(private http: HttpClient) { }
  getRoutes(departureCity: string, arrivalCity: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/routes?departureCity=${departureCity}&arrivalCity=${arrivalCity}`);
  }

  getDepartureRoutes(departureCity: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/routes/departure-routes?city=${departureCity}`);
  }

  getArrivalRoutes(arrivalCity: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/routes/arrival-routes?city=${arrivalCity}`);
  }

  getFlights(routeId: number, departDate?: string, mealPreference?: string): Observable<any[]> {
    const params = new HttpParams()
      .set('routeId', routeId.toString())
      .set('departDate', departDate || '')
      .set('mealPreference', mealPreference || '');

    return this.http.get<any[]>(`${this.baseUrl}/flights`, { params });
  }

  getFlightById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/flights/${id}`)
      .pipe(
        tap(flight => console.log('Fetched flight with id:', id)),
        catchError(this.handleError<any>('getFlightById'))
      );
  }

  createFlight(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/flights`, data)
      .pipe(
        tap(flight => console.log('Created flight')),
        catchError(this.handleError<any>('createFlight'))
      );
  }

  updateFlight(id: number, data: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/flights/${id}`, data)
      .pipe(
        tap(flight => console.log('Updated flight with id:', id)),
        catchError(this.handleError<any>('updateFlight'))
      );
  }

  deleteFlight(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/flights/${id}`)
      .pipe(
        tap(() => console.log('Deleted flight with id:', id)),
        catchError(this.handleError<any>('deleteFlight'))
      );
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }


//Booking
  getBookings(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/bookings`)
      .pipe(
        tap(bookings => console.log('Fetched bookings')),
        catchError(this.handleError('getBookings', []))
      );
  }

  getBookingById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/bookings/${id}`)
      .pipe(
        tap(booking => console.log('Fetched booking with id:', id)),
        catchError(this.handleError<any>('getBookingById'))
      );
  }

  createBooking(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/bookings`, data)
      .pipe(
        tap(booking => console.log('Created booking')),
        catchError(this.handleError<any>('createBooking'))
      );
  }

  updateBooking(id: number, data: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/bookings/${id}`, data)
      .pipe(
        tap(booking => console.log('Updated booking with id:', id)),
        catchError(this.handleError<any>('updateBooking'))
      );
  }

  deleteBooking(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/bookings/${id}`)
      .pipe(
        tap(() => console.log('Deleted booking with id:', id)),
        catchError(this.handleError<any>('deleteBooking'))
      );
  }
// AirlineReservationSystemService

getBookingDetails(bookingId: number): Observable<any> {
  return this.http.get<any>(`${this.baseUrl}/bookings/selectedTrip/{idTrip}${bookingId}`)
    .pipe(
      tap(booking => console.log('Fetched booking details:', booking)),
      catchError(this.handleError<any>('getBookingDetails'))
    );
}

getSelectedTripDetails(tripId: number): Observable<any> {
  return this.http.get<any>(`${this.baseUrl}/bookings/trips/${tripId}`)
    .pipe(
      tap(trip => console.log('Fetched trip details:', trip)),
      catchError(this.handleError<any>('getSelectedTripDetails'))
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

  getFlightsByCities(departureCity: string, arrivalCity: string): Observable<any[]> {
    const params = new HttpParams()
      .set('departureCity', departureCity)
      .set('arrivalCity', arrivalCity);

    return this.http.get<any[]>(`${this.baseUrl}/flights/search`, { params })
      .pipe(
        tap(flights => console.log('Fetched flights by cities')),
        catchError(this.handleError('getFlightsByCities', []))
      );
  }
  makeBooking(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/bookings`, data) // Ensure you're using this.baseUrl
      .pipe(
        tap(booking => console.log('Created booking')),
        catchError(this.handleError<any>('makeBooking'))
      );
  }
  getTrip(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/trips`) 
      .pipe(
        tap(trip => console.log('Fetched trip:', trip)),
        catchError(this.handleError<any>('getTrip'))
      );
  }
  
  addPassenger(passenger: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/passengers`, passenger);
  }
}
