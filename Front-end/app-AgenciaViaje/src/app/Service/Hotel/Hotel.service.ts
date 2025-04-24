import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { Hotel } from '../../models/Hotel.models';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor() { }
  private http = inject(HttpClient);
  private URLBase = environment.apiUrl = 'api/v1/Hotel'
  // getAll Reminders
  getAll():Observable<Hotel[]>{
    return this.http.get<Hotel[]>(this.URLBase);
  }
}
