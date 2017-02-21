/**
 * Created by Toshita on 2/17/2017.
 */
import { Component} from '@angular/core';
import {MovieService} from '../movie-service/movie.service';
import {UserService} from "../user-service/user.service";
import {email} from "ng2-validation/dist/email";
import {Router} from "@angular/router";

@Component({
    templateUrl: 'movie-list.component.html'
})
export class MovieListComponent {
    movieList: any = [];
    value = '';
    user: any = [];
    username=localStorage.getItem("email");
    validAdmin: boolean = false;
    constructor(private movieService: MovieService, private userService: UserService, private router: Router) {
        movieService.getMovies()
            .subscribe(
                movies => this.movieList = movies,
                error => console.log(error)
            );
        userService.getUserByEmail(this.username)
            .subscribe(
                user => this.user = user,
                error => console.log(error)
            );

    }

    onChange(selectedValue: String){
        if(selectedValue=="imdbRatings"){
            this.movieService.sortImdbRatings()
                .subscribe(
                    movies => this.movieList = movies,
                    error => console.log(error)
                );
        }
        else if(selectedValue=="sortyear"){
            this.movieService.sortYear()
                 .subscribe(
                    movies => this.movieList = movies,
                    error => console.log(error)
                );
        }
        else if(selectedValue=="imdbVotes"){
            this.movieService.sortImdbVotes()
                .subscribe(
                    movies => this.movieList = movies,
                    error => console.log(error)
                );
        }

    }
    logout(){
        localStorage.removeItem("email");
        this.router.navigate(['']);
    }

    filterChange(filterValue: String){
        if(filterValue=="movie"){
            this.movieService.getByMovie()
                .subscribe(
                    movies => this.movieList = movies,
                    error => console.log(error)
                );
        }
        else if(filterValue=="series"){
            this.movieService.getBySeries()
                .subscribe(
                    movies => this.movieList = movies,
                    error => console.log(error)
                );
        }
    }

    yearChange(yearValue: string){
            //console.log(yearValue);
            this.movieService.getByYear(yearValue)
                .subscribe(
                    movies => this.movieList = movies,
                    error => console.log(error)
                );
    }

    genreChange(genreValue: string){
        this.movieService.getByGenre(genreValue)
        .subscribe(
            movies => this.movieList = movies,
            error => console.log(error)
        );
    }

    years(){
        var year: number [] = [];
        for(var i = 1980; i <= 2017; i++){
            year.push(i);
        }
        return year;
    }

    titleEnter(title: string){
        this.movieService.getByTitle(title)
            .subscribe(
                movies => this.movieList = movies,
                error => console.log(error)
            );
    }

    new(){
        this.router.navigate(['create']);
    }

}