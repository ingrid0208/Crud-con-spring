import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { Itinerario } from '../../models/Itinerario.models';

@Injectable({
  providedIn: 'root'
})
export class ItinerarioService {

  constructor() { }
  private http = inject(HttpClient);
  private URLBase = environment.apiUrl + '/api/v1/Itinerario';

  public getItinerario(): Observable<Itinerario[]> {
    return this.http.get<Itinerario[]>(this.URLBase);
  }
}
