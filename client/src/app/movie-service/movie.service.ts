/**
 * Created by Toshita on 2/18/2017.
 */
import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';


@Injectable()
export class MovieService {

    constructor(private http: Http) {

    }
    getMovies(): Observable<any[]> {
        return this.http.get('http://localhost:8080/movieflix-api/api/movies')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    sortImdbRatings(): Observable<any[]> {
        return this.http.get('http://localhost:8080/movieflix-api/api/movies/sortByImdbRating')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    sortYear(): Observable<any[]> {
        return this.http.get('http://localhost:8080/movieflix-api/api/movies/movie/sortByYear')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    sortImdbVotes():Observable<any[]> {
        return this.http.get('http://localhost:8080/movieflix-api/api/movies/sortByVotes')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getByMovie():Observable<any[]> {
        return this.http.get('http://localhost:8080/movieflix-api/api/movies/findByTypeMovie')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getBySeries():Observable<any[]> {
        return this.http.get('http://localhost:8080/movieflix-api/api/movies/findByTypeSeries')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }


    getByYear(yearValue: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/movieflix-api/api/movies/findByYear/${yearValue}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    getByGenre(genreValue: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/movieflix-api/api/movies/findByGenre/${genreValue}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getByTitle(title: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/movieflix-api/api/movies/movie/${title}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getMovieById(id: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/movieflix-api/api/movies/${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    rating(rate: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post('http://localhost:8080/movieflix-api/api/ratings', rate, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getRate(usrId: string, movId: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/movieflix-api/api/ratings/${usrId}/${movId}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getAvgRating(movId: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/movieflix-api/api/ratings/avg/${movId}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getCommentById(id: string): Observable<any[]>{
        return this.http.get(`http://localhost:8080/movieflix-api/api/comments/id/${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getComments(): Observable<any[]>{
        return this.http.get(`http://localhost:8080/movieflix-api/api/comments`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    createComment(movieId: string, comment: string): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post(`http://localhost:8080/movieflix-api/api/comments/${movieId}/cmt=${comment}`, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    createMovie(movie: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post('http://localhost:8080/movieflix-api/api/movies', movie, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
}