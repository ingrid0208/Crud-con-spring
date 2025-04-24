import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { provideNativeDateAdapter } from '@angular/material/core';
import { Paquete } from '../../models/Paquete.models';
import { PaqueteService } from '../../Service/Paquete.service';



@Component({
  selector: 'app-created-task',
  providers: [provideNativeDateAdapter()],
  imports: [PaqueteComponent],
  templateUrl: './created-Paquete.component.html',
  styleUrl: './created-Paquete.component.css'
})
export class PaqueteComponent {

    PaqueteService = inject(PaqueteService);
  router = inject(Router);

  guardar(Paquete: Paquete) {
    this.PaqueteService.created(Paquete).subscribe(() => {
      this.router.navigate(['/']);
    });
  }


  delete(id: number) {
    this.PaqueteService.delete(id).subscribe(() => {
      this.router.navigate(['/']);
    })
  }
}