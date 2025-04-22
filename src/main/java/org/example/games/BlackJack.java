package org.example.games;

import org.example.coreLogic.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {

    private static final int MIN_CARDTYPE_VALUE = 1;
    private static final int MAX_CARDTYPE_VALUE = 5;
    private static final int MIN_CARDNUMBER_VALUE = 2;
    private static final int MAX_CARDNUBMER_VALUE = 15;
    private static final double WIN_MULTIPLIER = 2.0;

    private int cardNumber;
    private int cardType;
    private Money money = new Money();

    private static List<int[]> cardsList = new ArrayList<int[]>();
    private static List<int[]> playerCards = new ArrayList<int[]>();
    private static List<int[]> dealerCards = new ArrayList<int[]>();


    public List<int[]> getCardsList() {
        return cardsList;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber() {
        this.cardNumber = (int) (Math.random()*(MAX_CARDNUBMER_VALUE - MIN_CARDNUMBER_VALUE)+MIN_CARDNUMBER_VALUE);
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType() {
        this.cardType = (int) (Math.random()*(MAX_CARDTYPE_VALUE - MIN_CARDTYPE_VALUE)+MIN_CARDTYPE_VALUE);
    }

    public void addCardToCardsList(int[] newCard) {
        cardsList.add(newCard);
    }

    public int[] getNewCard() {
        setCardNumber();
        setCardType();
        return new int[]{getCardNumber(), getCardType()};
    }

    public boolean checkCardDuplication(int[] newCard) {
        if(cardsList.contains(newCard)){
            return true;
        }
        return false;
    }
    public void addCardsToPlayer(int[] newCard){
        addCardToCardsList(newCard);
        playerCards.add(newCard);
    }

    public void addCardToDealer(int[] newCard){
        addCardToCardsList(newCard);
        dealerCards.add(newCard);
    }

    public int getCardValue(List<int[]> cards){
        int value = 0;
        int ace = 0;
        for(int[] card : cards){
            if(card[0] == 14){
               ace++;
            } else if(card[0] >= 10 && card[0] <= 13){
                value = value + 10;
            }else {
                value = value + card[0];
            }
        }

        while (ace != 0){
            if((value + 11) <= 21){
                value = value + 11;
            }
            else value= value + 1;
            ace--;
        }
        return value;
    }

    public int getChoiceFromPlayer(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void clearLists(){
        playerCards.clear();
        dealerCards.clear();
        cardsList.clear();
    }

    public void blackJackGame(){
        money.checkMoneyBeforeBet();
        addCardsToPlayer(getNewCard());
        int[] newCard = getNewCard();
            while (checkCardDuplication(newCard)){
                newCard = getNewCard();
            }
            addCardToDealer(newCard);
        System.out.println("Dealer card value is currently " + getCardValue(dealerCards));
        System.out.println("Your current card value is " + getCardValue(playerCards) + "\nPress 1 to get another card or 2 to to check");
        int choice = getChoiceFromPlayer();
        while(choice == 1 && getCardValue(playerCards) < 21){
            newCard = getNewCard();
            while (checkCardDuplication(newCard)){
                newCard = getNewCard();
            }
            addCardsToPlayer(newCard);
            if(getCardValue(playerCards) > 21){
                break;
            }
            System.out.println("Your current card value is " + getCardValue(playerCards) + "\nPress 1 to get another card or 2 to to check");
            choice = getChoiceFromPlayer();
        }
        if(getCardValue(playerCards) > 21){
            System.out.println("OH NO "+ getCardValue(playerCards) +"\nBUSTED!!!\nTry Again");
            clearLists();
            return;
        }

        newCard = getNewCard();
        while (checkCardDuplication(newCard)){
            newCard = getNewCard();
        }
        addCardToDealer(newCard);
        System.out.println("Dealer value with his 2nd card is " + getCardValue(dealerCards));

        while (getCardValue(dealerCards) < 17){
            newCard = getNewCard();
            while (checkCardDuplication(newCard)){
                newCard = getNewCard();
            }
            addCardToDealer(newCard);
            System.out.println("Dealer value after getting another card is " + getCardValue(dealerCards));
        }
        if(getCardValue(dealerCards) > 21){
            System.out.println("DEALER BUSTED!!!\n YOU WON");
            money.addWonBalance(WIN_MULTIPLIER);
            System.out.println("Your current balance is " + money.getBalance());
            clearLists();
            return;
        }
        if(getCardValue(playerCards) == getCardValue(dealerCards)){
            money.addWonBalance(1.00);
            System.out.println("THIS WAS A DRAW!!! \nYour money has been returned to you \nYou currently have " + money.getBalance());
        }
        else if (getCardValue(playerCards) > getCardValue(dealerCards)) {
            money.addWonBalance(WIN_MULTIPLIER);
            System.out.println("YOU WON!!!\nYour current balance is " + money.getBalance());
        }
        else{
            System.out.println("Dealer won this one");
        }
        clearLists();
    }
}
