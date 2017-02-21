/**
 * Created by Toshita on 2/18/2017.
 */
import {Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {MovieService} from '../movie-service/movie.service';
import {UserService} from "../user-service/user.service";
import {email} from "ng2-validation/dist/email";

@Component({
    templateUrl: 'movie-details.component.html'

})
export class MovieDetailsComponent {

    movie: any = {};
    user : any = {};
    rate: any={};
    userId:string = "";
    avg: any = {};
    commentList: any[];
    comment: any={};
    constructor(private route: ActivatedRoute, private movieService: MovieService, private userService: UserService) {
        var loggedin='';

        this.route.params.subscribe(
            params => {
                movieService.getMovieById(params['id'])
                    .subscribe(
                        movie => this.movie = movie,
                        error => console.log(error)
                    );
                loggedin=localStorage.getItem("email");
                userService.getUserByEmail(loggedin)
                    .subscribe(
                        user => {this.user = user; if(this.user) this.userId=this.user.id;},
                        error => console.log(error)
                    );
                movieService.getCommentById(params['id'])
                    .subscribe(
                        comment => this.commentList = comment,
                        error => console.log(error)
                    );


               // movieService.getAvgRating(params['id'])
               //     .subscribe(
               //         avg => this.avg = avg,
               //         error => console.log(error)
               //     );

            });
        // var loggedin=localStorage.getItem("email");
        // this.userService.getUserByEmail(loggedin)
        //     .subscribe(
        //         user => {this.user = user;console.log(this.user.id);},
        //         error => console.log(error)
        //     );


    }

    rating(val: string, id: string){
        console.log(val);
        console.log("bleh");
        //console.log(this.user);

        this.rate.rating=val;
        this.rate.usr=this.user;
        this.rate.mov=this.movie;

         this.movieService.rating(this.rate)
             .subscribe(
                 rate => this.rate = rate,
                error => console.log(error)
             );
    }
    addComment(value :string, movieId: string){
        this.comment.comment= value;
        this.comment.mov= this.movie.id;
        console.log(this.comment);
        this.movieService.createComment(this.movie.id, this.comment.comment)
            .subscribe(
                comment => this.comment =comment,
                error => console.log(error)
            );

        location.reload();

    }
}