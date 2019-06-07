package com.tts.PotluckAdventures.BlogPost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String postTitle;
	private String postAuthor;
	private String postBody;
	
	//Need empty constructor since it is a schema
	BlogPost(){
		
	}
	
	//Need a regular constructor as well
	BlogPost(String postTitle, String postAuthor, String postBody){
		this.postTitle = postTitle;
		this.postAuthor = postAuthor;
		this.postBody = postBody;
	}
	
///// Getters & Setters \\\\\\
	
  //Get for id **No setter since id cannot be changed 
	public long getId() {
		return id;
	}
	
	//Post Title
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	
  //Post Author
	public String getPostAuthor() {
		return postAuthor;
	}
	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}

  //Post Body
	public String getPostBody() {
		return postBody;
	}
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
//////////////////////////////////

	//Print info method
	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", postAuthor=" + postAuthor + 
				", postTitle=" + postTitle + ", postBody="+ postBody + "]";
	}
	
	
}
