package org.example.coreLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    private Money money;

    @BeforeEach
    public void setup(){
        money = new Money();
    }

    @Test
    void checkIfTheBalanceIsBeingAddedCorrectly(){
        money.setCurrentBet(300.0);
        money.setBalance(0.0);
        money.addWonBalance(2.0);
        assertEquals(600.00, money.getBalance());
    }

    @Test
    void checkIfBetsAboveTheValueOfPlayersWalletAreNotAllowed(){
        String badNumber = "40000,0";
        ByteArrayInputStream in = new ByteArrayInputStream(badNumber.getBytes());
        System.setIn(in);
        String goodNumber = "10,0";
        in = new ByteArrayInputStream(goodNumber.getBytes());
        System.setIn(in);
        money.checkMoneyBeforeBet();
        assertNotEquals(40000.0, money.getCurrentBet());
        assertEquals(10.0, money.getCurrentBet());
    }
}