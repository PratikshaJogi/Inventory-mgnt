import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './customer';
import { Observable } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
private baseURL=`http://localhost:8080/inventoryMgt/customers`;
  
  constructor(private httpClient:HttpClient) { }

  getCustomerList():Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`${this.baseURL}`);
  }
  getCustomerById(id:number):Observable<Customer>{
    return this.httpClient.get<Customer>(`${this.baseURL}/${id}`);
  }
  
  createCustomer(customer:Customer):Observable<Customer>{
    return this.httpClient.post<Customer>(`${this.baseURL}`,customer);
  }
  

  
  updateCustomer(id: number,customer:Customer):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,customer);
  }
  deleteCustomer(id:number):Observable<Object>{
    return this.httpClient.delete<Customer>(`${this.baseURL}/${id}`);
  }

  /*checklogin(loginData:Login):Observable<Object>{
    return this.httpclient.post(`http://localhost:8080/employeeMgt/loginUser`,loginData);
  }*/
}
