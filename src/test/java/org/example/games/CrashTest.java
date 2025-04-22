package org.example.games;

import org.example.games.crash.Crash;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class CrashTest {


    private Crash crash;

    @BeforeEach
    void setup(){
        crash = new Crash();
    }

    @Test
    public void checkIfTheRandomGeneratorGeneratesNumbers(){
        crash.setRandomNumber();
        assertTrue(crash.getRandomNumber() > 0 && crash.getRandomNumber() < 100);
    }

    @Test
    public void isCrashAddingToTheMultiplier(){
        crash.addToMultiPlier(0.01);
        assertTrue(crash.getMultiplier() > 1.00);
    }

    @Test
    public void isTheRandomNumberBeingCheckedCorrectly(){
        crash.setRandomNumber();
        if(crash.getRandomNumber() == 50){
            assertTrue(crash.crashCheck());
        }
        else assertFalse(crash.crashCheck());
    }

    @Test
    public void doesCashoutReturnTheCorrectValueOnInput(){
        String option = "test";
        ByteArrayInputStream in = new ByteArrayInputStream(option.getBytes());
        System.setIn(in);
        crash.cashout();
        assertFalse(crash.getDidUserCashout().isEmpty());
    }


}
