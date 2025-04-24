import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { Reserva, } from '../../models/Reserva.models';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  constructor() { }
  private http = inject(HttpClient);
  private URLBase = environment.apiUrl + '/api/v1/Reserva/with-details';
  private URLCrear = environment.apiUrl + '/api/v1/Reserva';

  public filter(id: number): Observable<Reserva[]>{
    return this.http.get<Reserva[]>(`${this.URLCrear}/filter/${id}`)
  }

  public getTasks(): Observable<Reserva[]> {
    return this.http.get<Reserva[]>(this.URLBase);
  }

  public getAllById(id: number): Observable<Reserva> {
    return this.http.get<Reserva>(`${this.URLCrear}/${id}`);
  }
  
  public created(task: Reserva) {
    return this.http.post(this.URLCrear, task);
  }

  public update(id: number, task: Reserva) {
    return this.http.put(`${this.URLCrear}/${id}`, task);
  }

  updateActive(id: number, active: boolean) {
    return this.http.put(`${this.URLCrear}/toggle-active/${id}?active=${active}`, null);
  }

  public delete(id: number) {
    return this.http.delete(this.URLCrear + '/' + id);
  }
}
