import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  users: User[];

  constructor(private userService: RegisterService) { }
  ngOnInit(): void {
    this.getUsers()
  }

  private getUsers() {
    return this.userService.users().subscribe(
      (response: any) => {
        this.users = response;
      }, (error) => {
        console.log(error.message)
    });
  }

  delete(username:any){
    this.userService.deleteUser(username).subscribe(
      (response:any)=>{
        console.log("deleted successfully:"+response);
      },(error)=>{
        error?.error.message;
        console.error("noooooooooooo")
      }
    )
  }

}
