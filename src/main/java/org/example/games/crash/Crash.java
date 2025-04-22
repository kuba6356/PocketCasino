package org.example.games.crash;

import org.example.coreLogic.Money;

import java.util.Scanner;

public class Crash {

    private static final int LUCKY_NUMBER = 50;
    private static final int CRASH_ODDS = 100;
    private static boolean didCrashCrash = false;
    private static String didUserCashout = "";
    private static double multiplier = 1.00;
    private int randomNumber;
    private Money money = new Money();

    public boolean isDidCrashCrash() {
        return didCrashCrash;
    }

    public void setDidCrashCrash(boolean didCrashCrash) {
        Crash.didCrashCrash = didCrashCrash;
    }

    public String getDidUserCashout() {
        return didUserCashout;
    }

    public void setDidUserCashout(String didUserCashout) {
        this.didUserCashout = didUserCashout;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        Crash.multiplier = multiplier;
    }

    public void setRandomNumber() {
        this.randomNumber = (int) (Math.random() * CRASH_ODDS);
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void addToMultiPlier(double addedValue) {
        if(getMultiplier() > 2){
            addedValue = addedValue*2;
        }
        if(getMultiplier() > 5){
            addedValue = addedValue*2;
        }
        if(getMultiplier() > 10){
            addedValue = addedValue*2;
        }
        if(getMultiplier() > 20){
            addedValue = addedValue*2;
        }
        setMultiplier((double) Math.round((getMultiplier() + addedValue) * 100) /100);
    }

    public boolean crashCheck() {
        return getRandomNumber() == LUCKY_NUMBER;
    }

    public void cashout() {
        Scanner scanner = new Scanner(System.in);
        didUserCashout = scanner.nextLine();
    }

    public void softReset(){
        multiplier = 1.00;
        randomNumber = 0;
        didCrashCrash = false;
        didUserCashout = "";
    }

    public void  crashGame() throws InterruptedException {
        money.checkMoneyBeforeBet();
        CrashCashoutMultiThreading crashCashoutMultiThreading = new CrashCashoutMultiThreading();
        System.out.println("type anything to cashout");
        crashCashoutMultiThreading.start();
        while((!didCrashCrash) && (didUserCashout.isEmpty())){
            CrashLogicMultiThreading crashLogicMultiThreading = new CrashLogicMultiThreading();
            crashLogicMultiThreading.start();
            crashLogicMultiThreading.join();
            System.out.println(getMultiplier());
        }
        if(didCrashCrash){
            System.out.println("CRASH!!!!\nYOU LOSE!");
        }
        if(!didUserCashout.isEmpty()){
            money.addWonBalance(multiplier);
            System.out.println("YOU WON\n Your new balance is " + money.getBalance());
        }
        softReset();
    }
}
