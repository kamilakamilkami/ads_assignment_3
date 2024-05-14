import MyHashTable.MyHashTable;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<String, Integer>();
        hashTable.insert("Hello", 23);
        System.out.println(hashTable.retrieve("Hello"));
    }

}
