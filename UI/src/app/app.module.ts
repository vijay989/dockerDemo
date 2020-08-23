import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule }    from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// used to create fake backend
//import { fakeBackendProvider } from './_helpers';

import { AppComponent }  from './app.component';
import { routing }        from './app.routing';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './guard/auth.guard';

/*import { AlertComponent } from './_directives';
import { AuthGuard } from './_guards';
import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { AlertService, AuthenticationService, UserService } from './_services';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
*/
import { AuthenticationService } from '../app/services/login.service';
import { HomeComponent } from './components/home/home.component';

@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        routing
    ],
    declarations: [
        AppComponent,
        LoginComponent,
        HomeComponent
     /*   AlertComponent,
        HomeComponent,
        LoginComponent,
        RegisterComponent*/
    ],
    providers: [
        AuthenticationService,
        AuthGuard
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }