import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInput } from '@angular/material/input';
import { Router, RouterLink } from '@angular/router';
import { FormulariosComponent } from '../../formularios/formularios.component';
import { ClienteDto, RequestRegisterCategories } from '../../models/Cliente.models';
import { CategoriesService } from '../../Service/Cliente/Cliente.service';

@Component({
  selector: 'app-create-Cliente',
  imports: [FormulariosComponent],
  templateUrl: './create-Cliente.component.html',
  styleUrl: './create-Cliente.component.css'
})
export class CreateClienteComponent {

  ClienteService = inject(ClienteService);
  router = inject(Router);

  public readonly formBuilder = inject(FormBuilder);
  form = this.formBuilder.group({
    name: ['']
  })

  guardarCliente(Cliente: ClienteDto) {
    this.ClienteService.created(Cliente).subscribe(() => {
      this.router.navigate(['Cliente'])
    })
  }
}
