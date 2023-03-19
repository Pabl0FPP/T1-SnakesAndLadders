package ui;

import model.*;

import java.util.Scanner;

public class Menu {

    Game game = new Game();
    BSTScore bst=new BSTScore();

    Scanner sc = new Scanner(System.in);
    int option;



    public Menu(){
        bst=new BSTScore();
        game = new Game();

        double score=0;

        boolean exit = false;

        boolean exit1 = false;

        while(!exit){

            System.out.println("1. Jugar\n2. Salir");
            option=sc.nextInt();

            switch (option){
                case 1:

                    System.out.println("<<< Datos del tablero >>>");
                    System.out.println("Digite la cantidad de filas: ");
                    int rows=sc.nextInt();
                    System.out.println("Digite la cantidad de columnas:");
                    int columns=sc.nextInt();
                    System.out.println("Digite la cantidad de serpientes:");
                    int snakes=sc.nextInt();
                    System.out.println("Digite la cantidad dde escaleras: ");
                    int ladders= sc.nextInt();
                    game.initGame(rows, columns, snakes, ladders);

                    sc.nextLine();
                    System.out.println("<<< Datos de los jugadores >>>");
                    for(int i=1;i<=3;i++){
                        System.out.println("Digite el nickname del jugador "+ i);

                        String nickname=sc.nextLine();
                        System.out.println("¿Cuál de los siguientes símbolos desea "+nickname+", para ser reconocido en el tablero? *, !, O, X, %, $, #, +, & ");
                        String symbol=sc.nextLine();
                        game.addPlayer(symbol, nickname);
                    }
                    System.out.println("Asi quedo el tablero: ");
                    game.printPlayersOfBoard();

                    /*
                    //Turnos
                    long startTime = System.currentTimeMillis();

                    game.setGameOver(false);


                    while (!game.gameOver()) {
                        Player currentPlayer = game.getCurrentPlayer();
                        System.out.println("\nTurno de " + currentPlayer.getNickname() + ". Símbolo: " + currentPlayer.getSymbol());

                        // Tirar el dado
                        int diceValue = game.rollingDice();
                        System.out.println("Valor del dado: " + diceValue);


                        // Mover jugador
                        game.movePlayer();

                        // Verificar si el jugador ganó
                        if (currentPlayer.getPos() == game.getBoard().getEnd().getId()) {
                            long endTime = (System.currentTimeMillis() - startTime)/1000;
                            score=(600-endTime)/6;
                            System.out.println("El juego terminó");
                            System.out.println("Jugador ganador: " + currentPlayer.getNickname() + ". Símbolo: " + currentPlayer.getSymbol());
                            //Cambio el puntaje del jugador que gano el juego
                            currentPlayer.setScore(score);
                            //Lo registro en el arbol
                            bst.add(currentPlayer);
                            bst.inOrder();

                            game.setGameOver(true);
                        } else {
                            game.nextPlayer();
                        }
                    }
                    */

                    long startTime = System.currentTimeMillis();
                    menu1();
                    long endTime = (System.currentTimeMillis() - startTime)/1000;
                    score=(600-endTime)/6;



                    break;
                case 2:
                    exit = true;
                    System.out.println("Juego finalizado:)");
                    bst.inOrder();

                    break;
                default:
                    System.out.println("Digite una opción disponible");
                    break;
            }

        }

    }

    public int validateIntegerInput() {
        int option = 0;
        boolean isValid = false;
        do {
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error. Ingrese un valor numérico.");
            }
        } while (!isValid);
        return option;
    }


    public void menu1(){
        int score=0;
        Player currentPlayer = game.getCurrentPlayer();
        //game = new Game();

        //bst=new BSTScore();

        game.setGameOver(false);

        while(!game.gameOver()){
            System.out.println("1. Tirar dado\n" +
                    "2. Ver escaleras y serpientes\n");
            int option1=sc.nextInt();

            switch (option1){
                case 1:

                    // Mover jugador
                    game.movePlayer();

                    break;
                case 2:
                    //ver serpientes y escaleras


                    break;
                default:
                    System.out.println("Digite una opción disponible");
                    break;
            }
/*
            if (currentPlayer.getPos() == game.getBoard().getEnd().getId()) {
                System.out.println("El juego terminó");
                System.out.println("Jugador ganador: " + currentPlayer.getNickname() + ". Símbolo: " + currentPlayer.getSymbol());
                //Cambio el puntaje del jugador que gano el juego
                currentPlayer.setScore(score);
                //Lo registro en el arbol
                bst.add(currentPlayer);

                game.setGameOver(true);
            } else {
                game.nextPlayer();
            }
            */

        }

    }



}
