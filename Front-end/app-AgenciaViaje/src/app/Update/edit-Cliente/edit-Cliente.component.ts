import { Component, inject, Input, numberAttribute, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { FormulariosComponent } from '../../formularios/formularios.component';
import { Cliente, ClienteDto } from '../../models/Cliente.models';
import { ClienteService } from '../../Service/Cliente/Cliente.service';

@Component({
  selector: 'app-edit-Cliente',
  imports: [FormulariosComponent],
  templateUrl: './edit-Cliente.component.html',
  styleUrl: './edit-Cliente.component.css'
})
export class EditClienteComponent implements OnInit {
  @Input({ transform: numberAttribute })
  id!: number;

  ClienteServices = inject(ClienteService);
  router = inject(Router);
  modelo?: Cliente;

  ngOnInit(): void {
    this.ClienteServices.getAllById(this.id).subscribe(Cliente => {
      this.modelo = Cliente;
    })
  }

  guardarCambios(Cliente: ClienteDto){
    this.ClienteServices.update(this.id, Cliente).subscribe(() => {
      this.router.navigate(['/Cliente'])
    })
  }
}
