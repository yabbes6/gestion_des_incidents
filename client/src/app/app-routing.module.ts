import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/login/login.component';
import { authenticationGuard } from './guards/authentication.guard';
import { AdminComponent } from './components/admin/admin.component';
import { authorizationGuard } from './guards/authorization.guard';
import { NewIncidentComponent } from './components/new-incident/new-incident.component';
import { RegisterComponent } from './components/register/register.component';
import { IncidentListComponent } from './components/incident-list/incident-list.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { IncidentUpdateComponent } from './components/incident-update/incident-update.component';

const routes: Routes = [
  
  {path:"",component:HomePageComponent},
  {path:"register",component:RegisterComponent},
  {path:"login",component:LoginComponent /*, canActivate: [authenticationGuard]*/},
  {path :"users",component:AdminComponent},
  {path:"new-incident",component:NewIncidentComponent},
  { path: 'incidents/:id/update', component: IncidentUpdateComponent },
  {path:"comment",component:AddCommentComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
