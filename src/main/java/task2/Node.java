package task2;

public class Node<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Key key;
    private Value value;
    private Node<Key, Value> left;
    private Node<Key, Value> right;
    private boolean color;

    public Node(Key key, Value value, boolean color) {
        this.key = key;
        this.value = value;
        this.color = color;
    }

    public Key getKey() {return key;}

    public void setKey(Key key) {this.key = key;}

    public Value getValue() {return value;}

    public void setValue(Value value) {this.value = value;}

    public Node<Key, Value> getLeft() {return left;}

    public void setLeft(Node<Key, Value> left) {this.left = left;}

    public Node<Key, Value> getRight() {return right;}

    public void setRight(Node<Key, Value> right) {this.right = right;}

    public boolean getColor() {
        return this.color;
    }
    public void setColor(boolean color) {this.color = color;}

    public boolean isRed() {
        return color == RED;
    }

    public void setRed() {color = RED;}


    public boolean isBlack() {
        return color == BLACK;
    }

    public void setBlack() {color = BLACK;}
}
