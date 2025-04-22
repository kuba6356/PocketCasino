package org.example;

import org.example.games.BlackJack;
import org.example.games.Roulette;
import org.example.games.crash.Crash;
import org.example.menu.Menu;

public class App {
    public static void main(String[] args) throws InterruptedException {
        boolean playGame = true;
        Menu menu = new Menu();
        while(playGame){
            menu.getMenuOption();
        }
    }
}
