/**
 * Created by Toshita on 2/15/2017.
 */
import { Component} from '@angular/core';
import {UserService} from '../user-service/user.service';
import {Router} from '@angular/router';

@Component({
    selector: 'movie-flix',
    templateUrl: 'user-form.component.html'
})

export class UserFormComponent {
    user = <any>{};
    values = '';
    valid: boolean = true;

    loginUser = <any>{};



    onKey(value: String) {
        // console.log(this.user.password);
        // console.log(this.values);
        if(this.user.password != this.values) {
            this.valid = false;
        } else {
            this.valid = true;
        }
    }

    addUser(){
        this.user.role="user";

       // console.log(this.user);

        this.userService.createUser(this.user)
            .subscribe(
                user => this.user = user,
                error => console.log(error)
            );

        location.reload();
    }

    login(event:any){

        console.log("working!!");
      this.userService.getLogin(this.loginUser.loginEmail, this.loginUser.loginPwd)
            .subscribe(
            user =>{
                this.user = user;
                if(this.user==true)
                {
                    localStorage.setItem("email",this.loginUser.loginEmail);
                    this.router.navigate(['/movies']);
                }

            },
            error => console.log(error)
            );

    }


    constructor(private userService: UserService, private router: Router) {
        if(localStorage.getItem("email")){
            this.router.navigate(['/movies']);
        }
    }
}