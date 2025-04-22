package org.example.games.crash;

public class CrashLogicMultiThreading extends Thread {

    private static final  double MULTIPLIER_PER_SECOND = 0.01;

    private Crash crash = new Crash();

    @Override
    public void run() {

        crash.setRandomNumber();
        if(crash.crashCheck()){
            crash.setDidCrashCrash(true);
            return;
        }
        if(crash.isDidCrashCrash() || !crash.getDidUserCashout().isEmpty()){
            return;
        }
        crash.addToMultiPlier(MULTIPLIER_PER_SECOND);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
