import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountService } from '../account/account.service';

@Injectable({
  providedIn: 'root'
})
export class MonsterService {
  
  header = new HttpHeaders()
    .set('Authorization', `Bearer ${this.accountService.getToken()}`)

  api = "http://localhost:8080/api/monster";

  constructor(
    private http: HttpClient,
    private accountService: AccountService
  ) { }

  getAllMonsters(){
    return this.http.get<any>(`${this.api}/all`, {headers: this.header})
  }
}
