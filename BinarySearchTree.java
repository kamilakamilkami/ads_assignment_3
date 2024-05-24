import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private Node<Key, Value> root;

    private int size;

    public void put(Key key, Value value) {
        Node<Key, Value> newNode = new Node<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            Node<Key, Value> current = root;
            if (current.getKey().equals(newNode.getKey())) {
                newNode.setLeft(current.getLeft());
                newNode.setRight(current.getRight());
                current.setLeft(null);
                current.setRight(null);
            } else {
                while (true) {
                    if (current.getKey().compareTo(newNode.getKey()) > 0) {
                        if (current.getLeft() != null) {
                            current = current.getLeft();
                        } else {
                            current.setLeft(newNode);
                            break;
                        }
                    } else {
                        if (current.getRight() != null) {
                            current = current.getRight();
                        } else {
                            current.setRight(newNode);
                            break;
                        }
                    }
                }
            }
        }
        size++;
    }

    public Value get(Key key) {
        Node<Key, Value> current = root;
        while (current != null && !current.getKey().equals(key)) {
            if (current.getKey().compareTo(key) > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        if (current == null) {
            throw new NoSuchElementException("No value found with this key");
        }
        return current.getValue();
    }

    public void delete(Key key) {
        root = deleteNode(root, key);
        size--;
    }

    private Node<Key, Value> deleteNode(Node<Key, Value> node, Key key) {
        if (node == null)
            return null;

        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(deleteNode(node.getLeft(), key));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRight(deleteNode(node.getRight(), key));
        } else {
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();

            Node<Key, Value> minNode = findMinimum(node.getRight());
            node.setKey(minNode.getKey());
            node.setValue(minNode.getValue());
            node.setRight(deleteNode(node.getRight(), node.getKey()));
        }

        return node;
    }

    private Node<Key, Value> findMinimum(Node<Key, Value> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public Iterator<Key> iterator() {
        return new MyIterator<>(root);
    }

    public int getSize() {
        return size;
    }

    private static class MyIterator<K extends Comparable<K>, V> implements Iterator<K> {
        private Stack<Node<K, V>> stack;

        public MyIterator(Node<K, V> root) {
            stack = new Stack<>();
            pushNodes(root);
        }

        private void pushNodes(Node<K, V> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No elements in the tree");
            }
            Node<K, V> current = stack.pop();
            pushNodes(current.getRight());
            return current.getKey();
        }
    }

    private static class Node<Key extends Comparable<Key>, Value> {
        private Key key;
        private Value value;
        private Node<Key, Value> left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        public Node<Key, Value> getLeft() {
            return left;
        }

        public void setLeft(Node<Key, Value> left) {
            this.left = left;
        }

        public Node<Key, Value> getRight() {
            return right;
        }

        public void setRight(Node<Key, Value> right) {
            this.right = right;
        }
    }
}
