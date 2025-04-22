package org.example.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class LeaderBoardTest {

    private LeaderBoard leaderBoard;

    @BeforeEach
    void setup(){
        leaderBoard = new LeaderBoard();
    }
    @Test
    void checkIfTheFileReadsCorrectlyAndSavesIntoAVariable() throws IOException {
        assertTrue(leaderBoard.getLeaderBoardFile().ready());
    }
    @Test
    void trueTestHasPlayerEarnedEnough(){
        assertTrue(leaderBoard.hasPlayerEarnedEnough(99999999));
    }
    @Test
    void falseTestHasPlayerEarnedEnough(){
        assertFalse(leaderBoard.hasPlayerEarnedEnough(1));
    }
    @Test
    void checkIfNewRecordIsAddedToTheLeaderBoard() throws IOException {
        String option = "TES";
        ByteArrayInputStream in = new ByteArrayInputStream(option.getBytes());
        System.setIn(in);
        leaderBoard.addNewRecordToTheLeaderBoard(2201);
    }

}