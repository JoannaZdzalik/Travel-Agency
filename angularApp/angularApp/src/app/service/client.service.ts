import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ClientDto } from '../model/client';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private baseUrl = 'http://localhost:4200/travelagency';  
  private getUrl = 'http://localhost:4200/travelagency/clients';
  private addUrl = 'http://localhost:4200/travelagency/addclient'
  
  constructor(private http:HttpClient) { }  
  
  getClientList(): Observable<any> {  
    return this.http.get(this.baseUrl);  
  }  

  getData() {
    return this.http.get(this.getUrl);
  }
  
  createClient(client: ClientDto) {  
    return this.http.post(this.addUrl, client);  
   // return this.http.post(`${this.baseUrl}`+'/addclient', client);  
  }  


}
