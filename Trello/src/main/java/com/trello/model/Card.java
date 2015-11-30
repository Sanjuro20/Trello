package com.trello.model;

import java.util.ArrayList;

public class Card {
	private String name;
	private String description;
	private ArrayList<String> comments;
		
	public Card(String cardName) {
		super();
		this.name = cardName;
		this.comments = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<String> getComments() {
		return comments;
	}

	public void addComment(String commentText) {
		comments.add(commentText);
	}
	
	public void editComment(int commentIndex, String commentText) {
		comments.set(commentIndex, commentText);
	}
	
	public void deleteComment(int commentIndex) {
		comments.remove(commentIndex);
	}
}
