public class BinarySearchTree<K extends Comparable<K>,V> {
    private Node root;
    private class Node {
        private K key;
        private V val;
        private Node left,right;
        public Node(K key,V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key,V value){

    }
    public V get(K key){

    }
    public void delete(K key){

    }
    public Iterable<K> iterator() {

    }

}
