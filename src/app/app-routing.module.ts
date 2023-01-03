import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationComponent } from './account/authentication/authentication.component';
import { CreateAccountComponent } from './account/create-account/create-account.component';
import { AuthGuard } from './account/guard/auth.guard';
import { LoginComponent } from './account/login/login.component';
import { HomeComponent } from './main/home/home.component';
import { LayoutComponent } from './main/layout/layout.component';

const routes: Routes = [
  {
  path: '', component: LayoutComponent, children: [
    {path: '', redirectTo: 'home', pathMatch:'full'},
    {path: 'home', component: HomeComponent}
  ], 
  canActivate: [AuthGuard]
  },
  {
  path: '', component: AuthenticationComponent,  
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
