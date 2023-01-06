import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  
  signedIn = false;

  change(){
    if(this.signedIn)
    this.signedIn = false;
    else
    this.signedIn = true;
    }
}
