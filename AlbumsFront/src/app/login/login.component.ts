import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { User } from './../model/user.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: ``
})
export class LoginComponent implements OnInit {
  user = new User();
  err : number = 0;
  message : string = "login ou mot de passe erroné ! ";
  constructor(private authService : AuthService,
              private router : Router) { }
  ngOnInit(): void {
  }
  onLoggedin()
    {
    this.authService.login(this.user).subscribe({
    next: (data) => {
      let jwToken = data.headers.get('Authorization')!;
      this.authService.saveToken(jwToken);
      this.router.navigate(['/']);
      },
    error: (err: any) => {
      if(err.console.errorCause == "disabled")
        this.message = "Votre compte est desactive !";
      console.log("err " + err.message);
      this.err = 1;
    }
  });
  }

}
