package io.toshita.api.entity;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Rating.findAll", query="Select r from Rating r"),
	@NamedQuery(name="Rating.findRate", query="Select avg(r.rating) from Rating r INNER JOIN r.mov m where m.id= :rMovie")
})
public class Rating {

	@Id
	@Column(name = "RATING_ID")
	private String id;
	private double rating;
	@ManyToOne
	private User usr;
	@ManyToOne
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
