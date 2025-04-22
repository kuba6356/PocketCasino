package org.example.menu;

import org.example.coreLogic.Money;
import org.example.games.BlackJack;
import org.example.games.Roulette;
import org.example.games.crash.Crash;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.nextUp;

public class Menu {

    private BlackJack blackJack = new BlackJack();
    private Crash crash = new Crash();
    private Roulette roulette = new Roulette();
    private LeaderBoard leaderBoard = new LeaderBoard();
    private Money money = new Money();

    boolean playGame = true;

    public boolean isPlayGame() {
        return playGame;
    }

    public void setPlayGame(boolean playGame) {
        this.playGame = playGame;
    }

    public void renderInitialMenuOptions(){
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("------------------1.Choose Your Game-----------------");
        System.out.println("------------------2.Show Leaderboard-----------------");
        System.out.println("----------------3.Show Current Balance---------------");
        System.out.println("-----------------------4.Quit------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
    }

    public void renderGamesMenuOptions(){
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("---------------------1.Blackjack---------------------");
        System.out.println("---------------------2.Roulette----------------------");
        System.out.println("---------------------3.Crash-------------------------");
        System.out.println("---------------------4.Back--------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
    }

    public Integer getMenuOption() {
        Scanner getPlayerInput = new Scanner(System.in);
        try {
            int option = getPlayerInput.nextInt();
            return option;
        }
        catch (InputMismatchException e){
            System.out.println("the value you provided is outside the scope or/and isn't matching the correct values," +
                    "\nPlease use one of the options shown before");
            return null;
        }
    }

    public void gameMenu() throws InterruptedException, IOException {
        renderGamesMenuOptions();
        switch (getMenuOption()){
            case 1 -> blackJack.blackJackGame();
            case 2 -> roulette.rouletteGame();
            case 3 -> crash.crashGame();
            case 4 -> initialMenu();
        }
    }

    public void initialMenu() throws InterruptedException, IOException {
        renderInitialMenuOptions();

        switch (getMenuOption()){
            case 1 -> gameMenu();
            case 2 -> {
                leaderBoard.printLeaderBoard();
                TimeUnit.SECONDS.sleep(2);
            }
            case 3 -> {
                System.out.println("Your current balance is " + money.getBalance());
                TimeUnit.SECONDS.sleep(2);
            }
            case 4 -> {
                leaderBoard.addNewRecordToTheLeaderBoard(money.getBalance());
                setPlayGame(false);
            }
        }
    }
}
