import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';
import { Observable } from 'rxjs';
import { LoginService } from '../services/login.service';


export class authenticationGuard implements CanActivate{

  constructor(private loginService: LoginService,private router : Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.loginService.isAuthenticated)
      return true
    else {
      this.router.navigateByUrl("/login")
      return false;}
  };

}
