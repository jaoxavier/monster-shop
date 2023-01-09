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

  getMonsterByCategory(category: string){
    return this.http.get<any>(`${this.api}/category/${category}`, {headers: this.header})
  }

  getMonsterById(id: number){
    return this.http.get<any>(`${this.api}/id/${id}`, {headers: this.header})
  }
}
