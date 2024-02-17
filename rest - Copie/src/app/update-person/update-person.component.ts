import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from '../models/person';

@Component({
  selector: 'app-update-person',
  templateUrl: './update-person.component.html',
  styleUrls: ['./update-person.component.css']
})
export class UpdatePersonComponent implements OnInit {

  nni!: number;
  person: Person = new Person();

  constructor(private restService: RestService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.nni = this.route.snapshot.params['nni'];

    this.restService.getPersonByNni(this.nni).subscribe(data => {
      this.person = data;
    },
     error => console.log(error));
  }

  onSubmit(){
    this.restService.updatePerson(this.nni, this.person).subscribe( data =>{
      this.goToPersonsList();
    }
    , error => console.log(error));
  }

  goToPersonsList(){
    this.router.navigate(['/persons']);
  }
}
