import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestComponent } from './rest/rest.component';
import { ListPersonComponent } from './list-person/list-person.component';
import { UpdatePersonComponent } from './update-person/update-person.component';
import { DetailPersonComponent } from './detail-person/detail-person.component';

const routes: Routes = [
  {path: 'persons', component: ListPersonComponent},
  {path: '', redirectTo: 'persons', pathMatch: 'full'},
  {path: 'create-person', component: RestComponent},
  
  {path: 'update-person/:nni', component: UpdatePersonComponent},
  {path: 'person-details/:nni', component: DetailPersonComponent}

]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
