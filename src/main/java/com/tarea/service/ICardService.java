package com.tarea.service;

import java.util.List;

import com.tarea.model.Card;
import com.tarea.service.impl.CardNotFoundException;

public interface ICardService {


    List<Card> getAllCards();

    Card getCardById(int id) throws CardNotFoundException;

    void saveCard(Card card);

    void updateCard(int id, Card card) throws CardNotFoundException;

    void deleteCardById(int id)throws CardNotFoundException;
}
