import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Inventory Management System';
  signedIn = false;

  change(){
    if(this.signedIn)
    this.signedIn = false;
    else
    this.signedIn = true;
    }
  }


