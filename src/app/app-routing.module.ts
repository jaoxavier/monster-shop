import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationComponent } from './account/authentication/authentication.component';
import { CreateAccountComponent } from './account/create-account/create-account.component';
import { LoginComponent } from './account/login/login.component';

const routes: Routes = [
  {
  path: '',
  component: AuthenticationComponent,  
  children: [
    {path: '', redirectTo: 'login', pathMatch: 'full',},
    {path: 'login', component: LoginComponent},
    {path: 'create-account', component: CreateAccountComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
