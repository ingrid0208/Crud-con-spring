import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { provideNativeDateAdapter } from '@angular/material/core';
import { Itinerario } from '../../models/Itinerario.models';
import { ItinerarioService } from '../../Service/Itinerario.service';



@Component({
  selector: 'app-created-task',
  providers: [provideNativeDateAdapter()],
  imports: [ItinerarioComponent],
  templateUrl: './created-Itinerario.component.html',
  styleUrl: './created-Itinerario.component.css'
})
export class ItinerarioComponent {

  ItinerarioService = inject(ItinerarioService);
  router = inject(Router);

  guardar(Itinerario: Itinerario) {
    this.ItinerarioService.created(Itinerario).subscribe(() => {
      this.router.navigate(['/']);
    });
  }


  delete(id: number) {
    this.ItinerarioService.delete(id).subscribe(() => {
      this.router.navigate(['/']);
    })
  }
}

