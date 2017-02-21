/**
 * Created by Toshita on 2/20/2017.
 */
import { Component} from '@angular/core';
import {MovieService} from '../movie-service/movie.service';

import {Router} from "@angular/router";

@Component({
    templateUrl: 'create.component.html'
})

export class CreateComponent{
    constructor(private movieService: MovieService, private router: Router) {

    }
    movie: any ={};
    valid: boolean=false;
    create(title: string, year: string, rated: string, release: string, runtime: string, genre: string, director: string, writer: string, actors: string, plot: string, language: string, country: string, awards: string, poster: string, metaScore: string, imdbRating: string, imdbVotes: string, imdbId: string, type: string)
    {

        this.movie.title=title;
        this.movie.year=year;
        this.movie.rated=rated;
        this.movie.release=release;
        this.movie.runtime=runtime;
        this.movie.genre=genre;
        this.movie.director=director;
        this.movie.writer=writer;
        this.movie.actors=actors;
        this.movie.plot=plot;
        this.movie.language=language;
        this.movie.country=country;
        this.movie.awards=awards;
        this.movie.poster=poster;
        this.movie.metaScore=metaScore;
        this.movie.imdbRating=imdbRating;
        this.movie.imdbVotes=imdbVotes;
        this.movie.imdbId=imdbId;
        this.movie.type=type;
        console.log(this.movie);
        this.movieService.createMovie(this.movie)
            .subscribe(
                movie => {this.movie = movie; this.valid=true;},
                error => console.log(error)
            );

    }
    reset(){
        this.movie.title="";
        this.movie.year="";
        this.movie.rated="";
        this.movie.release="";
        this.movie.runtime="";
        this.movie.genre="";
        this.movie.director="";
        this.movie.writer="";
        this.movie.actors="";
        this.movie.plot="";
        this.movie.language="";
        this.movie.country="";
        this.movie.awards="";
        this.movie.poster="";
        this.movie.metaScore="";
        this.movie.imdbRating="";
        this.movie.imdbVotes="";
        this.movie.imdbId="";
        this.movie.type="";
        this.valid=false;
    }
}