package com.tarea.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Card;
import com.tarea.repository.CardRepository;
import com.tarea.service.ICardService;

@Service
public class CardServiceImpl implements ICardService {

	@Autowired
	private CardRepository cardRepository;

	@Override
	public List<Card> getAllCards() {
		List<Card> cardList = new ArrayList<>();
		Card card1 = new Card();
		card1.setTarjetaId(1);
		card1.setNumeroTrjt("XXX XXX XXX XXX");
		card1.setTipoTrjt("VISA");
		card1.setLimiteCredito(10000.00);
		card1.setTasaInteres(0.15);
		cardList.add(card1);

		Card card2 = new Card();
		card2.setTarjetaId(2);
		card2.setNumeroTrjt("XXX XXX XXX XXX");
		card2.setTipoTrjt("Mastercard");
		card2.setLimiteCredito(15000.00);
		card2.setTasaInteres(0.12);
		cardList.add(card2);
		return cardList;
	}

	@Override
	public void saveCard(Card card) {
        cardRepository.save(card);

	}

	@Override
    public Card getCardById(int id) throws CardNotFoundException {
        Card card = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
        // Procesar la tarjeta
        return card;
    }


	@Override
    public void updateCard(int id, Card cardDetails) throws CardNotFoundException {
        Card card = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
        card.setNumeroTrjt(cardDetails.getNumeroTrjt());
        card.setTipoTrjt(cardDetails.getTipoTrjt());
        card.setLimiteCredito(cardDetails.getLimiteCredito());
        card.setTasaInteres(cardDetails.getTasaInteres());
        cardRepository.save(card);
    }

	@Override
	public void deleteCardById(int id) {
        cardRepository.deleteById(id);
	}


}
