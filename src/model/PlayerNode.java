package model;

public class PlayerNode {

    private Player current;
    private double score;

    private String winner;

    private PlayerNode right;

    private PlayerNode left;

    public PlayerNode() {
        this.score=score;
        this.winner=winner;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public PlayerNode getRight() {
        return right;
    }

    public void setRight(PlayerNode right) {
        this.right = right;
    }

    public PlayerNode getLeft() {
        return left;
    }

    public void setLeft(PlayerNode left) {
        this.left = left;
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
        return " " + getPlayers(id, current.getNext());
    }

}
