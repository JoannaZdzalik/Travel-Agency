import { Component, OnInit } from '@angular/core';
import { ClientDto } from '../model/client';
import { ClientService } from '../service/client.service';
import { Observable, Subject } from "rxjs";
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  // public clients: ClientDto[] = [];
 // public clients: any = [];

  constructor(private clientService: ClientService) {

  }

  clientsArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

 
   clients?: any;
  //clients!: Observable<ClientDto[]>;
  client: ClientDto = new ClientDto();
  deleteMessage = false;
  clientlist?: any;
  isupdated = false;
  

  ngOnInit() {
    // this.clients.push(new ClientDto('Asia', 'aaaaaa','eb6744'));
    // this.clientService.getClientList().subscribe((data) => {
    //   this.clients = data;
    // });

    this.isupdated = false;
    this.dtOptions = {
      pageLength: 5,
      stateSave: true,
      lengthMenu: [[5, 15, 20, -1], [5, 15, 20, "All"]],
      processing: true
    };

    this.clientService.getClientList().subscribe(data => {
      this.clients = data;
      this.dtTrigger.next();
    })
  }

  deleteClient(id: number) {
    this.clientService.deleteClient(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage = true;
          this.clientService.getClientList().subscribe(data => {
            this.clients = data
          })
        },
        error => console.log(error));
  }

  updateClient(id: number) {

    this.clientService.getClient(id).subscribe(data => {
      this.clientlist = data;
    })
    // this.clientService.getClient(id)
    //   .subscribe(
    //     data => 
    //       this.clients = data
    //     )
  }

  clientupdateform = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    surname: new FormControl(),
    passportNr: new FormControl()
  });

  updateCli(updcli: any) {
    this.client = new ClientDto();
    this.client.id = updcli.id;
    this.client.name = updcli.name;
    this.client.surname = updcli.surname;
    this.client.passportNr = updcli.passportNr;
    console.log(updcli.surname.value);

    this.clientService.updateClient(updcli.id, this.client).subscribe(
      data => {
        this.isupdated = true;
        this.clientService.getClientList().subscribe(data => {
          this.clients = data
        })
      },
      error => console.log(error));
  }

  get ClientName() {
    return this.clientupdateform.get('name');
  }

  get ClientSurname() {
    return this.clientupdateform.get('surname');
  }

  get ClientPassportNr() {
    return this.clientupdateform.get('passportNr');
  }

  get ClientId() {
    return this.clientupdateform.get('id');
  }

  changeisUpdate() {
    this.isupdated = false;
  }

  // changeisUpdate(){  
  //   this.isupdated=false;  
  // }
}

