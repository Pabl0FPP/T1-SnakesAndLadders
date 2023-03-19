package ui;

import model.*;

import java.util.Scanner;

public class Menu {

    Game game = new Game();
    BSTScore bst = new BSTScore();

    Scanner sc = new Scanner(System.in);
    int option;
    int totalBoxes;



    public Menu(){
        bst=new BSTScore();
        game = new Game();

        double score = 0;

        boolean exit = false;

        boolean exit1 = false;

        while(!exit){

            System.out.println("1. Jugar\n2. Salir");
            option=sc.nextInt();

            switch (option){
                case 1:
                    game = new Game();
                    System.out.println("<<< Datos del tablero >>>");
                    System.out.println("Digite la cantidad de filas: ");
                    int rows=sc.nextInt();
                    System.out.println("Digite la cantidad de columnas:");
                    int columns=sc.nextInt();
                    System.out.println("Digite la cantidad de serpientes:");
                    int snakes=sc.nextInt();
                    System.out.println("Digite la cantidad dde escaleras: ");
                    int ladders= sc.nextInt();
                    totalBoxes = rows * columns;
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

                    long startTime = System.currentTimeMillis();
                    menu1();
                    long endTime = (System.currentTimeMillis() - startTime)/1000;
                    score = (600-endTime)/6;



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
        int score = 0;
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
                    game.movePlayer(totalBoxes);

                    break;
                case 2:
                    //ver serpientes y escaleras
                    /*
                    game.getBoard().printBoard();

                     */

                    break;
                default:
                    System.out.println("Digite una opción disponible");
                    break;
            }

        }

    }

}
