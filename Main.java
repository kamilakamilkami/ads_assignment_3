import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Binary search tree
        BinarySearchTree<Integer, Character> binarySearchTree = new BinarySearchTree<Integer, Character>();
        String values = "ABCDEFGHIJK";
        for(int i=0;i<10;i++){
            binarySearchTree.put(i,values.charAt(i));
        }

        for (Integer k : binarySearchTree) {
            System.out.println("Key: " + k + ", Value: " + binarySearchTree.get(k));
        }
        // Hash Table
        MyHashTable<TestClass, Book> hashTable = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            TestClass key = new TestClass("Key" + random.nextInt());
            Book value = new Book("Title" + i, "Author" + i);
            hashTable.insert(key, value);
        }
        hashTable.printBuckets();
    }

}