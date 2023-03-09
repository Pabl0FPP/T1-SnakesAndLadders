package model;

public class Node {

    private int id;
    private Node next;
    private Node previous;
    private Node snake;
    private Node ladder;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getSnake() {
        return snake;
    }

    public void setSnake(Node snake) {
        this.snake = snake;
    }

    public Node getLadder() {
        return ladder;
    }

    public void setLadder(Node ladder) {
        this.ladder = ladder;
    }
}
