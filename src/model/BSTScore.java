package model;

public class BSTScore {


    private PlayerNode root;


    public void add(PlayerNode node) {
        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }
    }

    private void add(PlayerNode current, PlayerNode node) {
        if (node.getScore()-current.getScore() < 0) {
            //Meter a la izquierda
            if (current.getLeft() == null) {
                current.setLeft(node);
            } else {
                add(current.getLeft(), node);
            }
        } else if (node.getScore()-current.getScore() > 0) {
            //Meter a la derecha
            if (current.getRight() == null) {
                current.setRight(node);
            } else {
                add(current.getRight(), node);
            }

        } else {
            //No hacer nada
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(PlayerNode current){
        if(current == null){
            return;
        }
        inOrder(current.getLeft());
        System.out.println(current.getScore()+" ---- "+current.getWinner());
        inOrder(current.getRight());
    }

}
