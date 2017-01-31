package io.toshita.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m"),
	@NamedQuery(name="Movie.findByType", query="Select m from Movie m where m.type= :pType"),
	@NamedQuery(name="Movie.findByYear", query="Select m from Movie m where m.year= :pYear"),
	@NamedQuery(name="Movie.findByGenre", query="Select m from Movie m where m.genre= :pGenre and m.type= :pType"),
	@NamedQuery(name="Movie.findByTitle", query="Select m from Movie m where m.title= :pTitle"),
	@NamedQuery(name="Movie.sortByImdbRating", query="Select m from Movie m ORDER BY m.imdbRating DESC"),
	@NamedQuery(name="Movie.sortByYear", query="Select m from Movie m ORDER BY m.year DESC"),
	@NamedQuery(name="Movie.getTopRated", query="Select m from Movie m WHERE m.type = :mType ORDER BY m.imdbRating desc"),
	@NamedQuery(name="Movie.sortByImdbVotes", query="Select m from Movie m ORDER BY m.imdbVotes DESC"),

})
public class Movie {

	@Id
	@Column(name="MOV_ID")
	private String id;
	
	@Column(unique=true)
	private String title;
	
	private String year;
	private String rated;

	private String released;
	private String runtime;
	private String genre;

	private String director;
	private String writer;
	private String actors;
	private String plot;

	private String language;

	private String country;
	private String awards;
	private String poster;

	private String metaScore;
	
	private String imdbRating;
	private String imdbVotes;
	private String imdbId;
	private String type;
	
	public Movie(){
		this.id=UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(String metaScore) {
		this.metaScore = metaScore;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
}
