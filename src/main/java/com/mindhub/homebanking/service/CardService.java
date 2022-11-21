package com.mindhub.homebanking.service;

import com.mindhub.homebanking.models.Card;

public interface CardService {

    public void saveCard(Card card);

    public Card getCardByNumber(String number);
}
