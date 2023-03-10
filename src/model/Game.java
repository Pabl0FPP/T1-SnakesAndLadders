package model;

public class Game {
    private PlayerNode playerNode;
    private Board board;
    private String theSymbols;
    private boolean gameOver;

    public Game() {
        playerNode = new PlayerNode();
        gameOver = false;
        theSymbols = "*!OX%$#+&";
    }

    public void initGame(int rows, int columns, int snakes, int ladders) {
        board = new Board(rows, columns);
        board.generateSnakesAndLadders(snakes, ladders);
    }

    public boolean gameOver() {
        return gameOver;
    }

    public String getTheSymbols() {
        return theSymbols;
    }

    public boolean addPlayer(String symbol, String nickname) {
        if (theSymbols.contains(symbol + "")) {
            playerNode.addPlayer(symbol, nickname);
            theSymbols = theSymbols.replace(symbol + "", "");
            return true;
        }
        System.out.println("El simbolo seleccionado no se encuentra disponible.");
        return false;
    }

    public void printPlayersOfBoard() {
        System.out.println(board.getPlayersOfBoard(playerNode));
    }

    public Player getCurrentPlayer() {
        return playerNode.getCurrent();
    }
}
