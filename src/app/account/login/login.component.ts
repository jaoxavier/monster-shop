import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from 'src/app/services/account/account.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(
    private accountService: AccountService,
    private router: Router
  ){}

  login = {
    username: '',
    password: ''
  }

  onSubmit(){
    this.accountService.login(this.login).subscribe(
      data => this.router.navigate(['/home'])
    );
  }


}
