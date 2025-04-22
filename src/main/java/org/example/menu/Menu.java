package org.example.menu;

import org.example.games.BlackJack;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.nextUp;

public class Menu {

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

    public void gameMenu(){
        renderGamesMenuOptions();
        switch (getMenuOption()){
            case 1 -> {
                return;
            }
        }
    }

    public void initialMenu(){
        renderInitialMenuOptions();

        switch (getMenuOption()){
            case 1 -> {
                return;
            }
        }
    }
}
