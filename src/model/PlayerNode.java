package model;

public class PlayerNode {

    private Player current;

    public PlayerNode() {
    }

    public void addPlayer(String symbol, String nickname) {
        Player newPlayer = new Player(symbol, nickname);

        if (current == null) {
            current = newPlayer;
            current.setNext(current);
            current.setPrevious(current);
        } else {
            Player previousPlayer = current.getPrevious();
            previousPlayer.setNext(newPlayer);
            newPlayer.setPrevious(previousPlayer);
            newPlayer.setNext(current);
            current.setPrevious(newPlayer);
        }
    }


    public Player getCurrent() {
        return current;
    }

    public Player getNextPlayer(){
        current = current.getNext();
        return current;
    }

    public String getPlayers(int id) {
        return getPlayers(id, this.current);
    }

    private String getPlayers(int id, Player current) {
        if (current.getNext() == this.current) {
            if (current.getPos() == id) {
                return current.getSymbol();
            } else {
                return "";
            }
        }
        if (current.getPos() == id) {
            return current.getSymbol() + getPlayers(id, current.getNext());
        }
        return "" + getPlayers(id, current.getNext());
    }

}
