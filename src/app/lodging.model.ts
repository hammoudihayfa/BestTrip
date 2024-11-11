export interface Lodging {
    id?: number;           // Optional id
    name: string;
    location: string;
    pricePerNight: number;
    address?: string;       // Optional address
  }