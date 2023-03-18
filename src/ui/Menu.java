package ui;

import model.Game;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    int option;

    public Menu(){
        Game game = new Game();

        boolean exit = false;

        boolean exit1 = false;

        while(!exit){

            System.out.println("1. Jugar\n2. Salir");
            option=sc.nextInt();

            switch (option){
                case 1:
                    long startTime = System.currentTimeMillis();

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
                    for(int i=1;i<4;i++){
                        System.out.println("Digite el nickname del jugador "+ i);

                        String nickname=sc.nextLine();
                        System.out.println("¿Cuál de los siguientes símbolos desea "+nickname+", para ser reconocido en el tablero? *, !, O, X, %, $, #, +, & ");
                        String symbol=sc.nextLine();
                        game.addPlayer(symbol, nickname);
                    }
                    System.out.println("Asi quedo el tablero: ");
                    game.printPlayersOfBoard();

                    //Turnos

                    long endTime = (System.currentTimeMillis() - startTime)/1000;
                    double score=(600-endTime)/6;

                    //Le asigno el anterior puntaje al jugador que gano la partida y despues de esto lo agrego en un arbol

                    break;
                case 2:
                    exit = true;
                    System.out.println("Juego finalizado :)");
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
}
