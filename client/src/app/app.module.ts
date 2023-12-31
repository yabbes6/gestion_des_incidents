import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { IncidentListComponent } from './components/incident-list/incident-list.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { NewIncidentComponent } from './components/new-incident/new-incident.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AdminComponent } from './components/admin/admin.component';
//import { AppHttpInterceptor } from './interceptors/app-http.interceptor';

import { MatToolbarModule } from '@angular/material/toolbar'; 
import {MatIconModule} from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule, MatIconButton } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { RegisterComponent } from './components/register/register.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { IncidentUpdateComponent } from './components/incident-update/incident-update.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    IncidentListComponent,
    HomePageComponent,
    NewIncidentComponent,
    LoginComponent,
    AdminComponent,
    RegisterComponent,
    AddCommentComponent,
    IncidentUpdateComponent,
        
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule, 
    MatInputModule,
    MatCheckboxModule,
    MatSnackBarModule,
    MatIconModule,
    
 
  ],
  providers: [
    //{provide: HTTP_INTERCEPTORS , useClass: AppHttpInterceptor , multi : true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
