import { Component, OnInit } from '@angular/core';
import { ClientDto } from '../model/client';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  // public clients: ClientDto[] = [];


  public clients: any = [];
  
  constructor(private clientService: ClientService) {

  }

  ngOnInit() {
   // this.clients.push(new ClientDto(1, 'Asia', 'aaaaaa','eb6744'));
    this.clientService.getData().subscribe((data) => {
      this.clients = data;
    });
  }

 

}
