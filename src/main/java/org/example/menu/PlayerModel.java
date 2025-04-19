package org.example.menu;

public class PlayerModel {
    private Long place;
    private Integer moneyEarned;
    private String playerName;

    public PlayerModel(Long place, Integer moneyEarned, String playerName) {
        this.place = place;
        this.moneyEarned = moneyEarned;
        this.playerName = playerName;
    }

    public Long getPlace() {
        return place;
    }

    public void setPlace(Long place) {
        this.place = place;
    }

    public Integer getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(Integer moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "PlayerModel{" +
                "place=" + place +
                ", moneyEarned=" + moneyEarned +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
