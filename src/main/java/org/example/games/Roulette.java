package org.example.games;

import org.example.coreLogic.Money;

import java.util.Scanner;

public class Roulette {

    private static final Double NUMBER_BET_MULTIPLIER = 36.00;
    private static final Double COLOR_BET_MULTIPLIER = 2.0;
    private Integer winningNumber;
    private Money money = new Money();

    public Integer getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber() {
        this.winningNumber = (int) (Math.random() * 37);
    }

    public int betOnNumber(){
        Scanner getNumberFromPlayer = new Scanner(System.in);
        Integer betNumber;
        do {
            System.out.println("choose a number you want to bet on, odd are red even are black");
            betNumber = getNumberFromPlayer.nextInt();
        }while (betNumber < 0 || betNumber > 36);
        return betNumber;
    }

    public boolean checkWinConditionForNumber() {
        if(getWinningNumber() == betOnNumber()){
            return true;
        }
        return false;
    }

    public boolean checkWinConditionForColor(){
        if(getWinningNumber() % 2 == betOnNumber() % 2){
            return  true;
        }
        return false;
    }
    public Integer getBetChoiceNumber(){
        Scanner getNumberFromPlayer = new Scanner(System.in);
        System.out.println("Choose 1 to bet on a specific number or 2 to bet on red/black");
        int choice = getNumberFromPlayer.nextInt();
        while(choice <0 || choice > 2){
            System.out.println("please choose 1 or 2");
            choice = getNumberFromPlayer.nextInt();
        }
        return choice;
    }

    public void rouletteGame(){
        setWinningNumber();
        money.checkMoneyBeforeBet();
        Integer choice = getBetChoiceNumber();
        if(choice == 1 && checkWinConditionForNumber()){
            money.addWonBalance(NUMBER_BET_MULTIPLIER);
            System.out.println("you won!!! \nYour current balance is " + money.getBalance());
        }
        else if (choice == 2 && checkWinConditionForColor()) {
            money.addWonBalance(COLOR_BET_MULTIPLIER);
            System.out.println("you won!!! \nYour current balance is " + money.getBalance());
        }
    }
}
