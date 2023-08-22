import {Component, OnInit} from '@angular/core';
import {User} from "../user";
import {LoginService} from "../login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  user:User = new User();

  constructor(private userService: LoginService) {
  }

  ngOnInit(): void {
  }

  protected readonly User = User;

  userLogin() {
    this.userService.loginUser(this.user).subscribe(data=>{
      alert("Login Success")
    },error => alert("Not auth"));
  }
}
