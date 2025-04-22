package org.example.games;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class BlackJackTest {

    private BlackJack blackJack;
    @BeforeEach
    void setUp() {
        blackJack = new BlackJack();
    }



    @Test
    public void checkIfCardRandomNumberIsAssignedCorrectly(){
        blackJack.setCardNumber();
        assertTrue(blackJack.getCardNumber()<=14);
        assertTrue(blackJack.getCardNumber() >= 2);
    }
    @Test
    public void checkIfCardRandomTypeIsAssignedCorrectly(){
        blackJack.setCardType();
        System.out.println(blackJack.getCardType());
        assertTrue(blackJack.getCardType()<=4);
        assertTrue(blackJack.getCardType() >= 1);
    }
    @Test
    public void checkIfTheCardIsBeingGeneratedCorrectlyAndValuesAreAssignedInAnArray(){
        assertNotNull(blackJack.getNewCard());
        assertEquals(blackJack.getNewCard()[0], blackJack.getCardNumber());
        assertEquals(blackJack.getNewCard()[1], blackJack.getCardType());
    }

    @Test
    public void checkIfTheCardsAreBeingAddedToTheListCorrectly(){
        blackJack.getCardsList().clear();
        blackJack.addCardToCardsList(blackJack.getNewCard());
        assertEquals(blackJack.getCardsList().get(0)[0], blackJack.getCardNumber());
        assertNotEquals(blackJack.getCardsList().get(0)[0], blackJack.getCardType());
        assertEquals(blackJack.getCardsList().get(0)[1], blackJack.getCardType());
        assertNotEquals(blackJack.getCardsList().get(0)[1], blackJack.getCardNumber());
    }


    @Test
    public void checkIfTheCardValueIsBeingCalculatedCorrectly(){
        int[] test = {13,2};
        int[] test3 = {12,2};
        int[] test2 = {14,2};
        List<int[]> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        testList.add(test3);
        blackJack.addCardsToPlayer(test);
        assertEquals(21, blackJack.getCardValue(testList) );
    }


}