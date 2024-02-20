package com.tarea.service.impl;

import java.io.Serializable;

public class CardNotFoundException extends Exception implements Serializable{

    private static final long serialVersionUID = -6832436722925163717L;

	public CardNotFoundException(int cardId) {
		super("Card with ID " + cardId + " not found");
	}
}
