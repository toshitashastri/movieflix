package io.toshita.api.entity;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name="Rating.findAll", query="Select r from Rating r")
})
public class Rating {

	@Id
	@Column(name = "RATING_ID")
	private String id;
	private double rating;
	@OneToOne
	private User usr;
	@OneToOne
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
