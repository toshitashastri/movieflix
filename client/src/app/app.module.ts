import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent}  from './app.component';
import {MovieListComponent} from './movie-list/movie-list.component';
import {MovieDetailsComponent} from './movie-details/movie-details.component';
import {ContactComponent} from './contact/contact.component';
import {NotFoundComponent} from './not-found/not-found.component';
import { FormsModule }   from '@angular/forms';
import {UserService} from './user-service/user.service';
import {MovieService} from './movie-service/movie.service';
import {UserFormComponent} from './user-form/user-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import {CreateComponent} from './create/create.component';

const appRoutes: Routes = [
    {path: '', component: UserFormComponent},
    {path: 'movies', component: MovieListComponent},
    {path: 'movies/:id', component: MovieDetailsComponent},
    {path: 'contact', component: ContactComponent},
    {path: 'create', component: CreateComponent}
];

@NgModule({
    imports: [BrowserModule, HttpModule, RouterModule.forRoot(appRoutes), FormsModule, ReactiveFormsModule],
    declarations: [AppComponent, NotFoundComponent, UserFormComponent, MovieListComponent, MovieDetailsComponent, ContactComponent, CreateComponent],
    providers: [UserService, MovieService],
    bootstrap: [AppComponent]
})
export class AppModule {

}

console.log('Running');
