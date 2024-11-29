import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'AlbumsFront';
  constructor(public authService : AuthService,
              private router : Router
  ) {}
  ngOnInit() {
    this.authService.loadToken();
    if (this.authService.getToken()==null ||
        this.authService.isTokenExpired())
      this.router.navigateByUrl('/login');
  }
  onLogout() { this.authService.logout(); }
}