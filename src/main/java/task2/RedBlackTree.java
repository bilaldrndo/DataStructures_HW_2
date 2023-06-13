package task2;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    public int numSteps = 0;

    public boolean isRed(Node<Key, Value> node) {
        if (node == null)
            return false;
        return node.isRed();
    }

    public int countRedLinks() {
        return countRedLinks(root);
    }

    private int countRedLinks(Node<Key, Value> node) {
        if (node == null)
            return 0;

        int count = countRedLinks(node.getLeft()) + countRedLinks(node.getRight());

        if (isRed(node.getLeft()) || isRed(node.getRight()))
            count++;

        return count;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node<Key, Value> node, Key key) {
        numSteps++;
        if (node == null)
            return null;

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0)
            return get(node.getLeft(), key);
        else if (cmp > 0)
            return get(node.getRight(), key);
        else
            return node.getValue();
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.setBlack();
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if (node == null)
            return new Node<>(key, value, RED);

        int cmp = key.compareTo(node.getKey());

        if (cmp < 0)
            node.setLeft(put(node.getLeft(), key, value));
        else if (cmp > 0)
            node.setRight(put(node.getRight(), key, value));
        else
            node.setValue(value);

        if (isRed(node.getRight()) && !isRed(node.getLeft()))
            node = rotateLeft(node);
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft()))
            node = rotateRight(node);
        if (isRed(node.getLeft()) && isRed(node.getRight()))
            flipColors(node);

        return node;
    }

    private Node<Key, Value> rotateLeft(Node<Key, Value> node) {
        Node<Key, Value> x = node.getRight();
        node.setRight(x.getLeft());
        x.setLeft(node);
        x.setColor(node.getColor());
        node.setColor(RED);
        return x;
    }

    private Node<Key, Value> rotateRight(Node<Key, Value> node) {
        Node<Key, Value> x = node.getLeft();
        node.setLeft(x.getRight());
        x.setRight(node);
        x.setColor(node.getColor());
        node.setColor(RED);
        return x;
    }

    private void flipColors(Node<Key, Value> node) {
        node.setColor(RED);
        node.getLeft().setColor(BLACK);
        node.getRight().setColor(BLACK);
    }
}
