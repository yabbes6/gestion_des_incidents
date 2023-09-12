import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';
import { Observable } from 'rxjs';

export class authorizationGuard implements CanActivate{

  constructor(private authService: AuthService,private router : Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.authService.roles.includes('ADMIN'))
      return true
    else {
      this.router.navigateByUrl("/admin")
      return false
    }
  };

}