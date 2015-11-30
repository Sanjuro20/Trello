package com.trello.model;

import java.util.ArrayList;
import java.util.List;

public class TableList {
	public String name;
	private List<Card> cards;

	public TableList(String tableListName) {
		super();
		this.name = tableListName;
		this.cards = new ArrayList<Card>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void editCard(int cardIndex, String name) {
		cards.get(cardIndex).setName(name);
	}
	
	public void deleteCard(int cardIndex) {
		cards.remove(cardIndex);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public ArrayList<String> getComments(int cardIndex) {
		return cards.get(cardIndex).getComments();
	}

	public void addComment(int cardIndex, String commentText) {
		cards.get(cardIndex).addComment(commentText);
	}
	
	public void editComment(int cardIndex, int commentIndex, String commentText) {
		cards.get(cardIndex).editComment(commentIndex, commentText);
	}
	
	public void deleteComment(int cardIndex, int commentIndex) {
		cards.get(cardIndex).deleteComment(commentIndex);
	}
}

