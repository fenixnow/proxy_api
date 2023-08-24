import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ShopsComponent } from './shops/shops.component';
import { FormsModule } from "@angular/forms";
import { AuthContentComponent } from './auth-content/auth-content.component';
import { HeaderComponent } from './header/header.component';
import { ContentComponent } from './content/content.component';
import {AxiosService} from "./axios.service";
import { LoginFormComponent } from './login-form/login-form.component';

@NgModule({
  declarations: [
    AppComponent,
    ShopsComponent,
    AuthContentComponent,
    HeaderComponent,
    ContentComponent,
    LoginFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [AxiosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
