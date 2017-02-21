import {Component} from '@angular/core';

@Component({
    selector: 'movie-flix',
    template: `<router-outlet></router-outlet>
  `
    // templateUrl: './user-form/user-form.component.html'

})
export class AppComponent {
    user = {};

    addUser(){
        console.log(this.user);
    }
}

