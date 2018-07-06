import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserCreateComponent } from './user/user-create/user-create.component';
import { StudentModule } from './student/student.module';
import { HttpModule } from '@angular/http';
import { StudentService} from './student/student.service';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    UserCreateComponent
  ],
  imports: [
    BrowserModule,
     ReactiveFormsModule,
    AppRoutingModule,
   
    StudentModule,
    
    HttpClientModule,
    FormsModule,
    HttpModule
  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
