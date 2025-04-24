import { Component, inject, Input, numberAttribute, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { Destino, Destino } from '../../models/Destino.models';
import { DestinoService } from '../../Service/Destino/Destino.service';

@Component({
  selector: 'app-edit-Destino',
  imports: [DestinoComponent],
  templateUrl: './edit-Destino.component.html',
  styleUrl: './edit-Destino.component.css'
})
export class DestinoComponent implements OnInit {
  @Input({ transform: numberAttribute })
  id!: number

  DestinoService = inject(DestinoService);
  router = inject(Router);
  model?: Destino;

  ngOnInit(): void {
    this.DestinoService.getAllById(this.id).subscribe(Destino => {

      this.model = Destino;
    })
  }

  guadar(Destino: Destino){
    this.DestinoService.update(this.id, Destino).subscribe(() => {
      this.router.navigate(['/'])
    })
  }
}
