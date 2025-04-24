import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { provideNativeDateAdapter } from '@angular/material/core';
import { Reserva } from '../../models/Reserva.models';
import { ReservaService } from '../../Service/Reserva.service';



@Component({
  selector: 'app-created-task',
  providers: [provideNativeDateAdapter()],
  imports: [ReservaComponent],
  templateUrl: './created-Reserva.component.html',
  styleUrl: './created-Reserva.component.css'
})
export class ReservaComponent {

  ReservaService = inject(ReservaService);
  router = inject(Router);

  guardar(Reserva: Reserva) {
    this.ReservaService.created(Reserva).subscribe(() => {
      this.router.navigate(['/']);
    });
  }


  delete(id: number) {
    this.ReservaService.delete(id).subscribe(() => {
      this.router.navigate(['/']);
    })
  }
}