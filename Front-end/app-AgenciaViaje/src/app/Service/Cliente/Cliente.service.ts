import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable, retry } from 'rxjs';
import { environment } from '../../../environments/environment';
import { Cliente, ClienteDto } from '../../models/Cliente.models';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor() { }

  private http = inject(HttpClient);
  private URLBase = environment.apiUrl + '/api/v1/Cliente';

  public getCliente(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.URLBase);
  }

  public getAllById(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.URLBase}/${id}`);
  }
  public created(Cliente: ClienteDto) {
    return this.http.post(this.URLBase, Cliente);
  }

  public update(id: number, task: ClienteDto) {
    return this.http.put(`${this.URLBase}/${id}`, task);
  }

  public delete(id: number) {
    return this.http.delete(this.URLBase + '/' + id);
  }

}
