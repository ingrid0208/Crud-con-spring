import { Component, inject } from "@angular/core";
import { FormBuilder } from "@angular/forms";
import { Router } from "@angular/router";
import { FormPrioritiesComponent } from "../../form-Cliente/form-Destino.component";
import { FormulariosComponent } from "../../formularios/formularios.component";
import { RequestRegisterPriorities } from "../../models/Excursion.models";
import { PrioritiesService } from "../../Service/Destino/Destino.service";


@Component({
  selector: 'app-create-Destino',
  imports: [ FormDestinoComponent],
  templateUrl: './create-Destino.component.html',
  styleUrl: './create-Destino.component.css'
})
export class CreateDestinoComponent {

  DestinoServices = inject(DestinoService);
  router = inject(Router);

  public readonly formBuilder = inject(FormBuilder);
  form = this.formBuilder.group({
    name: ['']
  })

  guardarDestino(Destino: DestinoDto) {
    this.DestinoServices.created(Destino).subscribe(() => {
      this.router.navigate(['priority'])
    })
  }
}
