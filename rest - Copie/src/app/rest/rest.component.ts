import { Component, OnInit } from '@angular/core';
import { Person } from '../models/person';
import { RestService } from '../rest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rest',
  templateUrl: './rest.component.html',
  styleUrls: ['./rest.component.css']
})
export class RestComponent  implements OnInit{

  nouveauPerson: Person = new Person(); // Initialise un nouvel objet Produit
  
  constructor(private restService: RestService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveProduit(){
    this.restService.createPerson(this.nouveauPerson).subscribe( data =>{
      console.log(data);
      this.goToPersonsList();
    },
    error => console.log(error));
  }

  goToPersonsList(){
    this.router.navigate(['/persons']);
  }
  
  onSubmit(){
    console.log(this.nouveauPerson);
    this.saveProduit();
  }

}
