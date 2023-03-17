package model;

import java.util.Scanner;

public class Menu {
    public void menu(){
        Game game=new Game();


        Scanner sc=new Scanner(System.in);
        int option;

        boolean exit=false;
        boolean exit1=false;

        while(!exit){

            System.out.println("1. Jugar\n2. Salir");
            option=sc.nextInt();

            switch (option){
                case 1:
                    long startTime = System.currentTimeMillis();


                    System.out.println("Digite el numero de filas que va a tener el tablero");
                    int rows=sc.nextInt();
                    System.out.println("Digite el numero de Columnas que va a tener el tablero");
                    int columns=sc.nextInt();
                    System.out.println("Digite el numero de serpientes que va a tener el tablero");
                    int snakes=sc.nextInt();
                    System.out.println("Digite el nummero de escaleras que va a tener el tablero");
                    int ladders= sc.nextInt();
                    game.initGame(rows, columns, snakes, ladders);

                    System.out.println("Ahora tienes que registrar 3 jugadores");
                    sc.nextLine();
                    for(int i=1;i<4;i++){
                        System.out.println("Digite el nickname del jugador "+ i);

                        String nickname=sc.nextLine();
                        System.out.println("Cual de los siguentes simbolos desea "+nickname+", para ser reconocido en el tablero? *, !, O, X, %, $, #, +, & ");
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
                    exit=true;

                    break;
                default:
                    System.out.println("Digite una opcion disponible");
                    break;
            }

        }



    }
}
