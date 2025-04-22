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
        setBalance((double) (round((getBalance() + getCurrentBet() * winMultiplier)*100))/100);
    }

    public void bet(Double newBet){
        setBalance((double) (round((getBalance() - newBet)*100))/100);
        System.out.println(getBalance());
        setCurrentBet(newBet);
    }

    public void checkMoneyBeforeBet(){
        Scanner getBetFromPlayer = new Scanner(System.in);
        Double newBet = 0.00;
        do{
            System.out.println("Bet some money!!!\nRemember that you can only bet the money you have.\nYou currently have " + getBalance() );
            newBet = getBetFromPlayer.nextDouble();
        }while(getBalance() < newBet || newBet < 0.01);
        while (getBetFromPlayer.hasNextLine()) {
            getBetFromPlayer.nextLine();
            break;
        }
        bet(newBet);
    }

}
