import { Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { Router, RouterLink } from '@angular/router';
import { ExcursionService } from '../../Service/Excursion/Excursion.service';
import { Excursion } from '../../models/Seguro.models';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ExcursionDto } from '../../models/Paquete.models';

@Component({
  selector: 'app-create-tags',
  imports: [ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatButtonModule, RouterLink],
  templateUrl: './create-Excursion.component.html',
  styleUrl: './create-Excursion.component.css'
})
export class ExcursionComponent {

  private ExcursionServices = inject(ExcursionService);
  private readonly formBuildr = inject(FormBuilder);
  router = inject(Router)


  tags?: Excursion[];
  columnasAMostar = ['name', 'acciones'];

  form = this.formBuildr.group({
    name: ['']
  })

    guardarCambios(){
      let Excursion = this.form.value as ExcursionDto;
      this.ExcursionServices.created(Excursion).subscribe(()=>{
        this.router.navigate(["tag"])
      })
    }

}
