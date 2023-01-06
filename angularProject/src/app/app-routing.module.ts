import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { HomeComponent } from './home/home.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';

const routes: Routes = [
  {path:'customers',component:CustomerListComponent},
  {path:'create-Customer',component:CreateCustomerComponent},
  {path:'', redirectTo: 'customers', pathMatch:'full'},
  {path:'update-customer/:id',component:UpdateCustomerComponent},
  {path:'customer-details/:id',component:CustomerDetailsComponent},
  {path:"login",component:LoginUserComponent},
  {path:"home",component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
