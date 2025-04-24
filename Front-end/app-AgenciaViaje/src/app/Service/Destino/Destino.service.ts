import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Destino } from '../../models/destino.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DestinoService {

  constructor() { }

  private http = inject(HttpClient);
  private URLBase = environment.apiUrl + '/api/v1/Destino'
  private URLDetails = environment.apiUrl + '/api/v1/Destino/with-details'

  public getHistory(): Observable<Destino[]> {
    return this.http.get<Destino[]>(this.URLDetails);
  }
}
