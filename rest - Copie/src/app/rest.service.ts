import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Person } from './models/person';


@Injectable({
  providedIn: 'root'
})

export class RestService {

  
  
  private baseURL = "http://localhost:8080/person";

  constructor(private httpClient: HttpClient) { }
  
  getPersonsList(): Observable<Person[]>{

    return this.httpClient.get<Person[]>(`${this.baseURL}`);
  }
  
  createPerson(Person: Person): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, Person);
  }

  getPersonByNni(nni: number): Observable<Person>{
    return this.httpClient.get<Person>(`${this.baseURL}/${nni}`);
  }

  updatePerson(nni: number, Person: Person): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${nni}`, Person);
  }
  
  deletePerson(nni: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${nni}`);
  }
}
