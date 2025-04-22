package org.example.games;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;


class RouletteTest {

    private Roulette roulette;

    @BeforeEach
    void setup(){
        roulette = new Roulette();
    }

    @Test
    void checkIfTheWinningNumberIsInRangeAndIsNotNegative(){
        roulette.setWinningNumber();
        assertTrue(roulette.getWinningNumber() >= 0 || roulette.getWinningNumber() <= 36);
    }

    @Test
    void specificNumberWinConditionCheck(){
        roulette.setWinningNumber();
        String option = roulette.getWinningNumber().toString();
        ByteArrayInputStream in = new ByteArrayInputStream(option.getBytes());
        System.setIn(in);
        assertTrue(roulette.checkWinConditionForNumber());
    }

    @Test
    void ColorWinConditionCheck(){
        roulette.setWinningNumber();
        String option = roulette.getWinningNumber().toString();
        ByteArrayInputStream in = new ByteArrayInputStream(option.getBytes());
        System.setIn(in);
        assertTrue(roulette.checkWinConditionForColor());
    }

    @Test
    void checkIfChoiceThatPlayerMakesWorksCorrectly(){
        String option = "2";
        ByteArrayInputStream in = new ByteArrayInputStream(option.getBytes());
        System.setIn(in);
        assertEquals((int) roulette.getBetChoiceNumber(), Integer.parseInt(option));
    }
}