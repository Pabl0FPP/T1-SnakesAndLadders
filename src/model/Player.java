package model;

public class Player {
    private String symbol;

    private String nickname;

    private int pos;

    private Player next;
    private Player previous;

    public Player(String symbol, String nickname) {
        this.symbol = symbol;
        this.nickname = nickname;
        this.pos = 1;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }

    public Player getPrevious() {
        return previous;
    }

    public void setPrevious(Player previous) {
        this.previous = previous;
    }

}
