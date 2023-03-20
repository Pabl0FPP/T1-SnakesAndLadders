package model;

public class Board {

    private int rows;
    private int columns;
    public int length;

    private Node start;
    private Node end;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.length = rows * columns;
        initBoard(1);
    }

    private void initBoard(int index) {
        addNode(index);
        if (index < length) {
            initBoard(index + 1);
        }
    }

    private void addNode(int index) {
        Node node = new Node(index);

        if (start == null) {
            node.setPrevious(node);
            node.setNext(node);
            start = node;
            end = node;
        } else {
            end.setNext(node);
            node.setPrevious(end);
            node.setNext(start);
            start.setPrevious(node);
            end = node;
        }
    }

    public void generateSnakesAndLadders(int snakes, int ladders) {
        int maxSnakLad = length - 2;
        int totalSnaksLads = snakes + ladders;

        if (totalSnaksLads > maxSnakLad) {
            System.out.println("La cantidad de escaleras y serpientes es muy grande. ");
            snakes = maxSnakLad / 2;
            ladders = maxSnakLad - snakes;
            System.out.println("Escaleras: " + ladders);
            System.out.println("Serpientes: " + snakes);
        }
        // Validación adicional para evitar escaleras en la casilla 1
        int startLadders = 0;
        if (ladders > 0) {
            startLadders = generateRandomInt(2, length);
            if (startLadders == length) {
                startLadders--;
            }
        }

        initAllSnakesAndLadders(snakes, ladders, getNodeAtPosition(generateRandomInt(1, length), end), getNodeAtPosition(generateRandomInt(1, length), start));
    }

    private void initAllSnakesAndLadders(int snakes, int ladders, Node currentSnake, Node currentLadder) {
        if (snakes == 0 && ladders == 0) {
            return;
        }

        if (snakes > 0) {
            Node moveTo = getNodeAtPosition(generateRandomInt(1, currentSnake.getId()), currentSnake);
            if (moveTo == end) { // Si la casilla es la última, generar de nuevo
                initAllSnakesAndLadders(snakes, ladders, currentSnake, currentLadder);
            } else if (!moveTo.hasSnake() && !moveTo.hasLadder()) {
                currentSnake.setSnake(moveTo);
                initAllSnakesAndLadders(snakes - 1, ladders, getNodeAtPosition(generateRandomInt(1, length), end), currentLadder);
            } else {
                initAllSnakesAndLadders(snakes, ladders, moveTo, currentLadder);
            }
        } else {
            Node moveTo = getNodeAtPosition(generateRandomInt(1, length - currentLadder.getId()), currentLadder);
            if (moveTo == end || moveTo.hasLadder()) { // Validación adicional para evitar escaleras en la última casilla
                initAllSnakesAndLadders(snakes, ladders, currentSnake, currentLadder);
            } else if (!moveTo.hasSnake() && !moveTo.hasLadder()) {
                currentLadder.setLadder(moveTo);
                if (moveTo == end) { // Si la casilla a la que se está moviendo con la escalera es la última, generar de nuevo
                    initAllSnakesAndLadders(snakes, ladders - 1, currentSnake, getNodeAtPosition(generateRandomInt(1, length - 1), start));
                } else {
                    initAllSnakesAndLadders(snakes, ladders - 1, currentSnake, getNodeAtPosition(generateRandomInt(1, length), start));
                }
            } else {
                initAllSnakesAndLadders(snakes, ladders, currentSnake, moveTo);
            }
        }
    }

    public void printSnakesAndLadders() {
        printSnakesAndLadders(end, rows, 1, 'A', 0, 0, 0);
    }

    private void printSnakesAndLadders(Node currentNode, int currentRow, int currentCol, char currentLetter, int currentLadderCount, int currentSnakeCount, int currentPrintedCount) {
        if (currentRow == 0) {
            return;
        }

        System.out.print("[");
        char nextLetter = currentLetter;
        int nextLadderCount = currentLadderCount;
        int nextSnakeCount = currentSnakeCount;

        if (currentNode.hasSnake()) {
            if (currentSnakeCount <= currentPrintedCount) {
                System.out.print(" " + currentLetter + " ");
                nextLetter++;
                nextSnakeCount++;
            } else {
                System.out.print("   ");
            }
        } else if (currentNode.hasLadder()) {
            if (currentLadderCount <= currentPrintedCount) {
                nextLadderCount++;
                System.out.print(" " + (currentLadderCount + 1) + " ");
            } else {
                System.out.print("   ");
            }
        } else {
            System.out.print("   ");
        }
        System.out.print("]");

        if (currentCol < columns) {
            printSnakesAndLadders(currentNode.getPrevious(), currentRow, currentCol + 1, nextLetter, nextLadderCount, nextSnakeCount, currentPrintedCount);
        } else {
            System.out.print("\n");
            if (currentPrintedCount >= rows * columns - (currentSnakeCount + currentLadderCount)) {
                return;
            }
            printSnakesAndLadders(currentNode.getPrevious(), currentRow - 1, 1, nextLetter, nextLadderCount, nextSnakeCount, currentPrintedCount + currentSnakeCount + currentLadderCount);
        }
    }

    //quité el static
    public int generateRandomInt(int start, int end) {
        if (end > start) {
            return (int) ((Math.random() * (1 + end - start)) + start);
        }
        return start;
    }

    public Node getNodeByIndex(int num) {
        return getNodeAtPosition(num, start);
    }

    private Node getNodeAtPosition(int num, Node current) {
        if (num == 0) {
            return current;
        }
        if (num > 0) {
            return getNodeAtPosition(num - 1, current.getNext());
        } else {
            return getNodeAtPosition(num + 1, current.getPrevious());
        }
    }

    public String getPlayersOfBoard(PlayerNode players) {
        return getPlayersOfBoard(players, start, 1);
    }

    private String getPlayersOfBoard(PlayerNode players, Node current, int row) {
        if (row > rows) {
            return "";
        }
        return getPlayersOfBoard(players, getNodeAtPosition(columns, current), row + 1) + "\n"
                + convertRowToString(row, current, players);
    }

    private String convertRowToString(int row, Node current, PlayerNode players) {
        return (current.getId() % columns == 0) ? "[" + current.getId() + (players.getPlayers(current.getId())) + "]" :
                (row % 2 == 0) ? convertRowToString(row, current.getNext(), players) + "[" + current.getId() + (players.getPlayers(current.getId())) + "]" :
                        "[" + current.getId() + (players.getPlayers(current.getId())) + "]" + convertRowToString(row, current.getNext(), players);
    }


    // Getters y Setters

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }
}
