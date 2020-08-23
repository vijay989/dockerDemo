import { Routes, RouterModule } from '@angular/router';

/*import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { AuthGuard } from './_guards';
*/
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { AuthGuard } from './guard/auth.guard';

const appRoutes: Routes = [
{ path: 'login', component: LoginComponent },
{ path: 'home', component:  HomeComponent},
{ path: '', component:  HomeComponent, canActivate: [AuthGuard]}
];

export const routing = RouterModule.forRoot(appRoutes);