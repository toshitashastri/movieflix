package io.toshita.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Rating.findAll", query="Select r from Rating r")
})
public class Rating {

	@Id
	private String id;
	private double rating;
	private User usr;
	private Movie mov;
	
	public Rating(){
		this.id=UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public User getUsr() {
		return usr;
	}
	public void setUsr(User usr) {
		this.usr = usr;
	}
	public Movie getMov() {
		return mov;
	}
	public void setMov(Movie mov) {
		this.mov = mov;
	}
}
