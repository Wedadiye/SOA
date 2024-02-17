import { Component, OnInit } from '@angular/core';
import { Person } from '../models/person';
import { ActivatedRoute } from '@angular/router';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-detail-person',
  templateUrl: './detail-person.component.html',
  styleUrls: ['./detail-person.component.css']
})
export class DetailPersonComponent implements OnInit{
  
  nni!: number 
  person!: Person 
  constructor(private route: ActivatedRoute, private restService: RestService) { }

  ngOnInit(): void {
    this.nni = this.route.snapshot.params['nni'];

    this.person = new Person();
    this.restService.getPersonByNni(this.nni).subscribe( data => {
      this.person = data;
    });
  }

}
