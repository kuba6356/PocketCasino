package org.example.games;

import org.example.games.crash.Crash;
import org.example.games.crash.CrashCashoutMultiThreading;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
class CrashCashoutMultiThreadingTest {
    private CrashCashoutMultiThreading crashCashoutMultiThreading;
    private Crash crash;
    @BeforeEach
    void setUp() {
        crashCashoutMultiThreading = new CrashCashoutMultiThreading();
        crash = new Crash();
    }

    @Test
    public void checkIfInputWorksCorrectly() throws InterruptedException {
        String option = "test";
        ByteArrayInputStream in = new ByteArrayInputStream(option.getBytes());
        System.setIn(in);
        crashCashoutMultiThreading.start();
        crashCashoutMultiThreading.join();
        assertEquals(option, crash.getDidUserCashout());
    }
}