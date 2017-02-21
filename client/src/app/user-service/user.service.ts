import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';


@Injectable()
export class UserService {

    private logged = false;

    constructor(private http: Http) {
        this.logged = !!localStorage.getItem('auth_token');
    }

    getUsers(): Observable<any[]> {
        return this.http.get('http://localhost:8080/movieflix-api/api/users')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    getUserById(id: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/movieflix-api/api/users${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    createUser(user: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post('http://localhost:8080/movieflix-api/api/users', user, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    updateUser(id: string, user: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post(`http://localhost:8080/movieflix-api/api/users${id}`, user, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getUserByEmail(email: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/movieflix-api/api/users/${email}/findByEmail`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getLogin(email: string, password: string): Observable<any[]>{
        return this.http.get(`http://localhost:8080/movieflix-api/api/users/${email}/${password}`)
            .map(response => response.json())

            .catch(error => Observable.throw(error.statusText));
    }


}

