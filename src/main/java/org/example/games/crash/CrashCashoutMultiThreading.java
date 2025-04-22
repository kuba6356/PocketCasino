package org.example.games.crash;

import java.util.Scanner;

public class CrashCashoutMultiThreading extends Thread{

    private Crash crash = new Crash();

    @Override
    public void run() {
        crash.cashout();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
