import { Component, OnInit } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  currentUser = "";

  constructor(private router:Router) {
      this.currentUser = JSON.parse(localStorage.getItem('jwtToken'));
  }


  ngOnInit(): void {

    if (!localStorage.getItem('jwtToken')) {
      this.router.navigate(['login'], { });
    }

  }



  deleteUser(id:number) {
 //   this.userService.delete(id).pipe(first()).subscribe(() => { 
       console.log("deleted");
    };

    private loadAllUsers() {
      // this.userService.getAll().pipe(first()).subscribe(users => { 
       //    this.users = users; 
       };

  }

