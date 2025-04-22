package org.example.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeaderBoard {
    private static final String LEADERBOARD_FILEPATH = "src/main/resources/leaderBoard.json";

    public FileReader getLeaderBoardFile() throws FileNotFoundException {
        return new FileReader(LEADERBOARD_FILEPATH);
    }
    public JSONArray leaderBoardArray() {
        try{
            JSONParser jsonParser = new JSONParser();
            return (JSONArray) jsonParser.parse(getLeaderBoardFile());
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void printLeaderBoard() {
        try {
            System.out.println("-----------------------------------");
            for(Object player : leaderBoardArray() ){
                System.out.println( "-----------" +
                                    ((JSONObject) player).get("place") + "--" +
                                    ((JSONObject) player).get("playerName") + "--" +
                                    ((JSONObject) player).get("moneyEarned")
                                    + "-----------");
            }
            System.out.println("-----------------------------------");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasPlayerEarnedEnough(int moneyEarned){
        if(moneyEarned <= Integer.parseInt((((JSONObject)leaderBoardArray().getLast()).get("moneyEarned")).toString())){
            System.out.println("You didn't earn enough to be placed on the leaderBoard come back when u have more than " +
                    (((JSONObject)leaderBoardArray().getLast()).get("moneyEarned")));
            return false;
        }
        return true;
    }
    public void overwriteLeaderBoardWithNew(List<Object> newLeaderBoard) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.writeValue( new File(LEADERBOARD_FILEPATH) , newLeaderBoard);
    }
    public void addNewRecordToTheLeaderBoard(int moneyEarned) throws IOException {
        if(!hasPlayerEarnedEnough(moneyEarned)){
            return;
        }
        List<Object> newLeaderBoard = new ArrayList<>();
        boolean playerAdded = false;
        for(Object player : leaderBoardArray()){
            if(player.equals(leaderBoardArray().getLast())){
                break;
            }
            int topPlayerMoneyEarned = Integer.parseInt(((JSONObject) player).get("moneyEarned").toString());
            if(topPlayerMoneyEarned > moneyEarned || playerAdded){
                newLeaderBoard.add(new PlayerModel((long) newLeaderBoard.size()+1, topPlayerMoneyEarned,  ((JSONObject) player).get("playerName").toString()));
            }
            else {
                System.out.println("Input 3 letters that will represent you in the leaderBoard");
                Scanner nameGetter = new Scanner(System.in);
                String name = "";
                while (name.length() != 3){
                    name = nameGetter.nextLine();
                }
                newLeaderBoard.add(new PlayerModel((long) (newLeaderBoard.size()+1), moneyEarned, name));
                playerAdded = true;
                newLeaderBoard.add(new PlayerModel((long) newLeaderBoard.size()+1, topPlayerMoneyEarned,  ((JSONObject) player).get("playerName").toString()));
            }
        }
        overwriteLeaderBoardWithNew(newLeaderBoard);
    }
}
