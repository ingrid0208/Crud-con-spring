import { Component, EventEmitter, inject, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInput } from '@angular/material/input';
import { RouterLink } from '@angular/router';
import { categories, Cliente, RequestRegisterCategories } from '../models/Cliente.models';

@Component({
  selector: 'app-formularios',
  imports: [ReactiveFormsModule, MatFormFieldModule, MatInput, MatButtonModule, RouterLink],
  templateUrl: './formularios.component.html',
  styleUrl: './formularios.component.css'
})
export class FormulariosComponent implements OnInit {

  public readonly formBuilder = inject(FormBuilder);

  @Input({ required: true })
  name?: string;

  @Input()
  modelo?: Cliente;

  @Output()
  posteoFormulario = new EventEmitter<ClienteDto>();
  form = this.formBuilder.group({
    name: ['']
  })

  ngOnInit(): void {
    if (this.modelo !== undefined) {
      this.form.patchValue(this.modelo)
    }
  }
  guardarCliente() {
    let category = this.form.value as ClienteDto;
    this.posteoFormulario.emit(category);
  }
}
