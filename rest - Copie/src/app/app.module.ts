import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestComponent } from './rest/rest.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ListPersonComponent } from './list-person/list-person.component';
import { UpdatePersonComponent } from './update-person/update-person.component';
import { DetailPersonComponent } from './detail-person/detail-person.component';

@NgModule({
  declarations: [
    AppComponent,
    RestComponent,
    ListPersonComponent,
    UpdatePersonComponent,
    DetailPersonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule ,
    HttpClientModule
    ,
    // Ajoutez FormsModule ici

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
