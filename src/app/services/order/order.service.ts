import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AccountService } from '../account/account.service';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  header = new HttpHeaders()
  .set('Authorization', `Bearer ${this.accountService.getToken()}`)

  api = "http://localhost:8080/api/orders"

  constructor(
    private http: HttpClient,
    private accountService: AccountService
  ) { }

  postOrder(order: any){
    return this.http.post<any>(`${this.api}/new`, order, {headers: this.header})
  }
}
