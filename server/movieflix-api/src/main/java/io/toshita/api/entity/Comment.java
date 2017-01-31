package io.toshita.api.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Comment.findAll", query="Select c from Comment c")
})
public class Comment {

	@Id
	@Column(name="COMMENT_ID")
	private String id;
	private String comment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USR_ID")
	private User usr;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="MOV_ID")
	private Movie mov;
	
	public Comment(){
		this.id=UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
