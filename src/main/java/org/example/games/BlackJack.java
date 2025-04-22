package org.example.games;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {

    private int cardNumber;
    private int cardType;

    private static List<int[]> cardsList = new ArrayList<int[]>();

    public List<int[]> getCardsList() {
        return cardsList;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public void addCardToCardsList() {
        cardsList.add(new int[]{getCardNumber(), getCardType()});
    }
}
