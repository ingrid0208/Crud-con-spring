import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { Paquete } from '../../models/Paquete.models';

@Injectable({
  providedIn: 'root'
})
export class PaqueteService {

  constructor() { }

  private http = inject(HttpClient);
  private URLBase = environment.apiUrl + '/api/v1/Paquete';

  getTags(): Observable<Paquete[]> {
    return this.http.get<Paquete[]>(this.URLBase);
  }

  created(tags: { name: string }): Observable<Paquete> {
    return this.http.post<Paquete>(this.URLBase, tags);
  }

  public delete(id: number) {
    return this.http.delete(this.URLBase + '/' + id);
  }

}
