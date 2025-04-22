package org.example;

import org.example.coreLogic.Money;
import org.example.games.BlackJack;
import org.example.games.Roulette;
import org.example.games.crash.Crash;
import org.example.menu.Menu;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        Menu menu = new Menu();
        Money money = new Money();

        while(menu.isPlayGame()){
            menu.initialMenu();
            if(money.getBalance() == 0){
                menu.setPlayGame(false);
            }
        }
    }
}
