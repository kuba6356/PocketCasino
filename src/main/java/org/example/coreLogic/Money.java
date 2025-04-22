package org.example.coreLogic;

import java.util.Scanner;

import static java.lang.Math.round;

public class Money {
    private static Double balance = 500.00;
    private static Double currentBet;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }

    public void addWonBalance(Double winMultiplier){
        setBalance((double) (round((getBalance() + getCurrentBet() * winMultiplier)*100)/100));
    }

    public void bet(Double newBet){
        setBalance(getBalance() - newBet);
        setCurrentBet(newBet);
    }

    public void checkMoneyBeforeBet(){
        Scanner getBetFromPlayer = new Scanner(System.in);
        Double newBet;
        do{
            System.out.println("Bet some money!!!\nRemember that you can only bet the money you have.\nYou currently have " + getBalance() );
            newBet = getBetFromPlayer.nextDouble();
        }while(getBalance() < newBet);
        while (getBetFromPlayer.hasNextLine()) {
            getBetFromPlayer.nextLine();
            break;
        }
        bet(newBet);
    }

}
