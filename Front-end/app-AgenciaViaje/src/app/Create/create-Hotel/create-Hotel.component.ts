import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router, RouterLink } from '@angular/router';
import { HotelCreate } from '../../models/Hotel.model';
import { HotelService } from '../../Service/Hotel.service';

@Component({
  selector: 'app-create-Hotel',
  imports: [ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatButtonModule, RouterLink],
  templateUrl: './create-Hotel.component.html',
  styleUrl: './create-Hotel.component.css'
})
export class HotelComponent {

  private readonly formBuildr = inject(FormBuilder);
  HotelServices = inject(HotelService);
  router = inject(Router)
  
  form = this.formBuildr.group({
    name: ['']
  })

  guardarCambios(){
    let Hotel = this.form.value as HotelCreate;
    this.HotelServices.crear(Hotel).subscribe(()=>{
      this.router.navigate(["Hotel"])
    })
  }
}
