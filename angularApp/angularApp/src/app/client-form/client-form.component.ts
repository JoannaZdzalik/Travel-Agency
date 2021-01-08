import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientDto } from '../model/client';
import { ClientService } from '../service/client.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent implements OnInit {

  constructor(private clientService: ClientService) { }

  client: ClientDto = new ClientDto();
  submitted = false;
  formdata: any;


  ngOnInit() {
    this.submitted = false;

    this.formdata = new FormGroup({
     name: new FormControl('', Validators.compose([Validators.required, Validators.minLength(3)])),
     surname: new FormControl('', Validators.compose([Validators.required, Validators.minLength(3)])),
     passportNr: new FormControl('', Validators.required)
    });
  }

  saveClient(data: any) {
    this.client.name = data.name;
    this.client.surname = data.surname;
    this.client.passportNr = data.passportNr;
    this.submitted = true;
    this.save();
  }

  save() {
    this.clientService.createClient(this.client)
      .subscribe(data => console.log(data), error => console.log(error));
    this.client = new ClientDto();
  }

  addClientForm() {
    this.submitted = false;
    this.formdata.reset();
  }
}  
