import { Component, OnInit } from '@angular/core';
import { Person } from '../models/person';
import { RestService } from '../rest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-person',
  templateUrl: './list-person.component.html',
  styleUrls: ['./list-person.component.css']
})

export class ListPersonComponent implements OnInit {

  persons!: Person[];

  constructor(private restService: RestService,
    private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(){
    this.restService.getPersonsList().subscribe(data => {
      this.persons = data;
    });
  }

  personDetails(nni: number){
    this.router.navigate(['person-details', nni]);
  }

  updatePerson(nni: number){
    this.router.navigate(['update-person', nni]);
  }

  deletePerson(nni: number){
    this.restService.deletePerson(nni).subscribe( data => {
      console.log(data);
      this.getEmployees();
    })
  }

}
