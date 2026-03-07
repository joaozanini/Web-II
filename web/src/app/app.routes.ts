import { Routes } from '@angular/router';
import { LoginComponent } from './features/auth/login/login.component';
import { DashboardClient } from './features/clientes/dashboard-client/dashboard-client';


export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },

  {    
    path: 'home',
    component: DashboardClient
  }
];