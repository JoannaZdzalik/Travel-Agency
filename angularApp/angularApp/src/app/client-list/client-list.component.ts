import { Component, OnInit } from '@angular/core';
import { ClientDto } from '../model/client';
import { ClientService } from '../service/client.service';
import { Observable,Subject } from "rxjs";  

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

  // clientsArray: any[] = [];  
  // dtOptions: DataTables.Settings = {};  
  // dtTrigger: Subject<any>= new Subject();  
  
  // clients?: any;  
  // client : ClientDto=new ClientDto();  
   deleteMessage=false;  
  // studentlist:any;  
  // isupdated = false; 

  ngOnInit() {
   // this.clients.push(new ClientDto('Asia', 'aaaaaa','eb6744'));
    this.clientService.getData().subscribe((data) => {
      this.clients = data;
    });
  }
  //   this.isupdated=false;  
  //   this.dtOptions = {  
  //     pageLength: 6,  
  //     stateSave:true,  
  //     lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],  
  //     processing: true  
  //   };  
      
  //   this.clientService.getClientList().subscribe(data =>{  
  //   this.clients =data;  
  //   this.dtTrigger.next();  
  //   })  
  // }

  deleteClient(id: number) {  
    this.clientService.deleteClient(id)  
      .subscribe(  
        data => {  
          console.log(data);  
          this.deleteMessage=true;  
          this.clientService.getClientList().subscribe(data =>{  
            this.clients =data  
            })  
        },  
        error => console.log(error));  
  } 
  
  
  // changeisUpdate(){  
  //   this.isupdated=false;  
  // }
}

