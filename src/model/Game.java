package model;

import java.util.Random;

public class Game {

    BSTScore bst=new BSTScore();
    private double score=0;


    private PlayerNode playerNode;
    private Dice dice;

    private int diceValue;
    private Board board;
    private String theSymbols;
    private boolean gameOver;

    public Game() {
        this.dice = new Dice();
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
        System.out.println("El símbolo seleccionado no se encuentra disponible.");
        return false;
    }

    public void printPlayersOfBoard() {
        System.out.println(board.getPlayersOfBoard(playerNode));
    }

    public Player getCurrentPlayer() {
        return playerNode.getCurrent();
    }

    // Simulación dado

    public int rollingDice() {
        diceValue = dice.rollDice();
        return diceValue;
    }


    // Simulación movimiento del jugador
    public void movePlayer1() {
        rollingDice(); // llamamos al método para actualizar el valor de diceValue
        movePlayer(getCurrentPlayer());
        if (getCurrentPlayer().getPos() >= 18) { // verificamos si algún jugador ha llegado a la casilla 18 o superior
            System.out.println("El jugador " + getCurrentPlayer().getSymbol() + " ha ganado el juego.");
            gameOver = true; // establecemos el valor de gameOver en true
        }
    }

    public void movePlayer(){
        int diceValue = rollingDice();
        System.out.println("Valor del dado: " + diceValue);
        movePlayer(getCurrentPlayer());
        if (getCurrentPlayer().getPos() == getBoard().getEnd().getId()) {
            System.out.println("El juego terminó");
            System.out.println("Jugador ganador: " + getCurrentPlayer().getNickname() + ". Símbolo: " + getCurrentPlayer().getSymbol());
            //Cambio el puntaje del jugador que gano el juego
            getCurrentPlayer().setScore(score);
            //Lo registro en el arbol
            bst.add(getCurrentPlayer());

            setGameOver(true);
        } else {
            nextPlayer();
        }
    }



    private void movePlayer(Player current) {
        System.out.println("Posición anterior: " + current.getPos());
        int newPosition = current.getPos() + diceValue;
        Node node = board.getNodeByIndex(newPosition);
        if (newPosition > board.getLength()) {
            return;
        }
        if (node.hasSnake()) {
            System.out.println("Casilla serpiente");
            current.setPos(node.getId());
        } else if (node.hasLadder()) {
            System.out.println("Casilla escalera");
            current.setPos(node.getId());
        } else {
            current.setPos(newPosition);
        }
        System.out.println("Nueva posición: " + current.getPos());
    }

    public Player nextPlayer() {
        return playerNode.getNextPlayer();
    }

    // Getters and setters
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
