import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';
import { Observable } from 'rxjs';
import { LoginComponent } from '../components/login/login.component';
import { LoginService } from '../services/login.service';

export class authorizationGuard implements CanActivate{

  constructor(private loginService: LoginService,private router : Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.loginService.roles.includes('ADMIN'))
      return true
    else {
      this.router.navigateByUrl("/admin")
      return false
    }
  };

}