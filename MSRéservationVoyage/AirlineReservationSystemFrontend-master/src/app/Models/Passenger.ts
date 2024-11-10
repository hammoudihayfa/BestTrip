export interface Passenger {
  idPass?: number;
  nom: string;     
  prenom: string;  
  email: string;   
  age: number;     
  sex: string;     
  foodPreferences?: string[]; 
  seatNumber?: string; 
  tripId?: number; 
}
