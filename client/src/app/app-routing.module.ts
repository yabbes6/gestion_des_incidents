import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/login/login.component';
import { authenticationGuard } from './guards/authentication.guard';
import { AdminComponent } from './components/admin/admin.component';
import { authorizationGuard } from './guards/authorization.guard';

const routes: Routes = [
  {path:"",component:HomePageComponent},
  {path:"login",component:LoginComponent /*, canActivate: [authenticationGuard]*/},
  {path :"admin",component:AdminComponent, canActivate : [authorizationGuard],data: {role:"ADMIN"}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
