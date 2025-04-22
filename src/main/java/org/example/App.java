package org.example;

import org.example.games.crash.Crash;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Crash crash = new Crash();
        crash.crashGame();
    }
}
