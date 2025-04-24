import { Component, EventEmitter, inject, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInput } from '@angular/material/input';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-form-Cliente',
  imports: [ReactiveFormsModule, MatFormFieldModule, MatInput, MatButtonModule, RouterLink],
  templateUrl: './form-Cliente.component.html',
  styleUrl: './form-Cliente.component.css'
})
export class ClienteComponent implements OnInit {


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
  guardarPriorities() {
    let priority = this.form.value as ClienteDto;
    this.posteoFormulario.emit(priority);
  }

}
