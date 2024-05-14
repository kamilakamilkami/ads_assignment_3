package MyHashTable;

import java.util.NoSuchElementException;

public class MyHashTable<K, V> {
    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public HashNode<K, V> getNext() {
            return next;
        }

        public void setNext(HashNode<K, V> next) {
            this.next = next;
        }
    }

    private HashNode<K, V>[] bucketArray;
    private int capacity = 11;
    private int size;
    private double loadFactor = 0.6;

    public MyHashTable() {
        bucketArray = new HashNode[capacity];
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        bucketArray = new HashNode[this.capacity];
    }

    private int hash(K key) {
        int hashValue = Math.abs(key.hashCode());
        return hashValue % capacity;
    }

    public void insert(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        int index = hash(key);
        if (bucketArray[index] == null) {
            bucketArray[index] = newNode;
        } else {
            HashNode<K, V> current = bucketArray[index];
            while (current != null) {
                if (current.getKey().equals(key)) {
                    current.setValue(value);
                    return;
                }
                current = current.getNext();
            }
            newNode.setNext(bucketArray[index]);
            bucketArray[index] = newNode;
        }
        size++;
        if ((double) size / capacity >= loadFactor) {
            resize();
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        HashNode<K, V>[] newBucketArray = new HashNode[newCapacity];
        for (int i = 0; i < bucketArray.length; i++) {
            HashNode<K, V> current = bucketArray[i];
            while (current != null) {
                HashNode<K, V> next = current.getNext();
                int newIndex = hash(current.getKey()) % newCapacity;
                current.setNext(newBucketArray[newIndex]);
                newBucketArray[newIndex] = current;
                current = next;
            }
        }
        bucketArray = newBucketArray;
        capacity = newCapacity;
    }

    public V retrieve(K key) {
        int index = hash(key);
        HashNode<K, V> current = bucketArray[index];
        while (current != null && !current.getKey().equals(key)) {
            current = current.getNext();
        }
        if (current == null) {
            throw new NoSuchElementException("No entry found with this key");
        }
        return current.getValue();
    }

    public K delete(K key) {
        int index = hash(key);
        HashNode<K, V> current = bucketArray[index];
        if (current != null && current.getKey().equals(key)) {
            bucketArray[index] = null;
            size--;
            return current.getKey();
        }
        while (current != null && current.getNext() != null && !current.getNext().getKey().equals(key)) {
            current = current.getNext();
        }
        if (current == null || current.getNext() == null) {
            throw new NoSuchElementException("No entry found with this key");
        }
        HashNode<K, V> nodeToDelete = current.getNext();
        current.setNext(nodeToDelete.getNext());
        nodeToDelete.setNext(null);
        size--;
        return nodeToDelete.getKey();
    }

    public boolean containsValue(V value) {
        for (HashNode<K, V> current : bucketArray) {
            while (current != null) {
                if (current.getValue().equals(value)) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        HashNode<K, V> current = bucketArray[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
}
