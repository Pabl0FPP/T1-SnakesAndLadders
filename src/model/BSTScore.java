package model;

public class BSTScore {


    private Player root;


    public void add(Player node) {
        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }
    }

    private void add(Player current, Player node) {
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

    private void inOrder(Player current){
        if(current == null){
            return;
        }
        inOrder(current.getLeft());
        System.out.println(current.getScore()+" ---- "+current.getNickname());
        inOrder(current.getRight());
    }


}
