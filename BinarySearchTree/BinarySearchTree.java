package BinarySearchTree;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private class TreeNode<Key extends Comparable<Key>, Value> {
        private Key key;
        private Value value;
        private TreeNode<Key, Value> left, right;

        public TreeNode(Key key, Value value) {
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

        public TreeNode<Key, Value> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<Key, Value> left) {
            this.left = left;
        }

        public TreeNode<Key, Value> getRight() {
            return right;
        }

        public void setRight(TreeNode<Key, Value> right) {
            this.right = right;
        }
    }

    private TreeNode<Key, Value> root;
    private int size;

    public void insert(Key key, Value value) {
        TreeNode<Key, Value> newNode = new TreeNode<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode<Key, Value> current = root;
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

    public Value retrieve(Key key) {
        TreeNode<Key, Value> current = root;
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

    public void remove(Key key) {
        root = removeNode(root, key);
        size--;
    }

    private TreeNode<Key, Value> removeNode(TreeNode<Key, Value> node, Key key) {
        if (node == null)
            return null;

        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(removeNode(node.getLeft(), key));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRight(removeNode(node.getRight(), key));
        } else {
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();

            TreeNode<Key, Value> minNode = findMinimum(node.getRight());
            node.setKey(minNode.getKey());
            node.setValue(minNode.getValue());
            node.setRight(removeNode(node.getRight(), node.getKey()));
        }

        return node;
    }

    private TreeNode<Key, Value> findMinimum(TreeNode<Key, Value> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public Iterator<Key> iterator() {
        return new <>(root);
    }

    public int getSize() {
        return size;
    }
}
