import { Routes } from '@angular/router';
import { ClienteComponent } from './Create/create-Cliente/create-Cliente.component';
import { CreateDestinoComponentComponent } from './Create/create-Destino/create-Destino.component';
import { CreateHotelComponent } from './Create/create-Hotel/create-Hotel.component';
import { CreateItinerarioComponent } from './Create/created-Itinerario/created-Itinerario.component';
import { CreatedClienteComponent } from './Read/list-Cliente/list-Cliente.component';
import { EditClienteComponentComponent } from './Update/edit-Cliente/edit-Cliente.component';
import { EditDestinoComponent } from './Update/edit-Destino/edit-Destino.component';
import { CreatedDestinoComponent } from './Read/list-Destino/list-Destino.component';




export const routes: Routes = [
    { path: '', component: ListaTareasComponent },


    { path: 'Cliente', component: ClienteComponent },

    { path: 'categories', component: CreateDestinoComponentComponent },
    { path: 'categories/created', component: CreateHotelComponent },
    { path: 'categories/editar/:id', component: CreateItinerarioComponent },

    { path: 'tasks/created', component: CreatedClienteComponent },
    { path: 'tasks/editar/:id', component: EditClienteComponentComponent },

    { path: 'taskStatus', component: CreatedDestinoComponent },
    { path: 'taskStatus/created', component: EditDestinoComponent },

    { path: 'priority', component: CreateDestinoComponentComponent },
    { path: 'priorities/created', component: EditDestinoComponent },

];
