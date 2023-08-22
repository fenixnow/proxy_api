import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {User} from "./user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseURL = "http://localhost:8080/user/login"

  constructor(private httpClient:HttpClient) {  }

  loginUser(user: User):Observable<object> {
    console.log(user);
    return this.httpClient.post(`${this.baseURL}`, user);
  }
}
