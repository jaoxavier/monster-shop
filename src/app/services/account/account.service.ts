import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  api = "http://localhost:8080/api/clients"

  constructor(
    private http: HttpClient
  ) { }

  login(user: any){
    const result = this.http.post<any>(`${this.api}/auth`, user);
    
    result.subscribe(
      data => {
        var token = data.token;
        if(data && token != undefined){
          window.localStorage.setItem('token', token);
          window.localStorage.setItem('id', data.id)
        }
    });

    return result;
  }

  createAccount(account: any){
    return this.http.post<any>(`${this.api}/new`, account);
  }

  getToken(){
    return window.localStorage.getItem('token');
  }

  getTokenExpiration(token: string){
    const decoded: any = jwt_decode(token);

    if(decoded.exp == undefined){
      return null;
    }

    const date = new Date(0);
    date.setUTCSeconds(decoded.exp);
    return date;
  }

  isTokenExpired(token: string): Boolean{
    if(!token){
      return true;
    }

    const date = this.getTokenExpiration(token);
    
    if(date === undefined){
      return false;
    }
    return !(date!.valueOf() > new Date().valueOf());
  }

  isUserLogged(): Boolean{
    const token = this.getToken();
    if(!token){
      return false
    }else if (this.isTokenExpired(token)){
      return false
    }
    return true;
  }
}
