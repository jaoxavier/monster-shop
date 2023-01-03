import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from 'src/app/services/account/account.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent {

  constructor(
    private accountService: AccountService,
    private router: Router
  ){}

  login = {
    username: '',
    password: ''
  }

  onSubmit(){
    this.accountService.createAccount(this.login).subscribe(
      data => this.router.navigate(['/login'])
    );
  }
}
