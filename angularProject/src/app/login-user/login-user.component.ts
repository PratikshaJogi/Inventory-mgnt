import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent {
  customer = new Customer();
  id:number = 0;
  password:string = '';
  message = "Signin pls..";

  
  constructor(private customerService:CustomerService, private router:Router ){}

  loginCustomer(form: NgForm){
    this.customerService.getCustomerById(this.id).subscribe(data => {
      console.log(data);
      
      if(data.password == this.password)
        this.router.navigate(['customers']);
      else

        this.router.navigate(['login']);
        //alert("Sorry!! Invalid Credentials...");
        this.message = "Sorry!! Invalid Credentials";
        form.resetForm();
    });
    
  }


  
}



