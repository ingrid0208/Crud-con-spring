import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { Excursion, ExcursionDto } from '../../models/Excursion.models';

@Injectable({
  providedIn: 'root'
})
export class ExcursionService {

  constructor() { }

  private http = inject(HttpClient);
  private URLBase =  environment.apiUrl + '/api/v1/Excursion';

  public getPriorities():Observable<Excursion[]> {
    return this.http.get<Excursion[]>(this.URLBase);
  }
  public getAllById(id: number): Observable<Excursion> {
    return this.http.get<Excursion>(`${this.URLBase}/${id}`);
  }
  public created(Excursion: ExcursionDto) {
    return this.http.post(this.URLBase, Excursion);
  }

  public update(id: number, task: ExcursionDto) {
    return this.http.put(`${this.URLBase}/${id}`, task);
  }

  public delete(id: number) {
    return this.http.delete(this.URLBase + '/' + id);
  }
}
