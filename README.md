# Algorithm and Data Structures Assignment 3

# Binary Search Tree and Hash Table

This repository contains implementations of a Binary Search Tree and a Hash Table in Java. The Binary Search Tree provides efficient methods for insertion, retrieval, and deletion of key-value pairs, while the Hash Table offers similar functionality with a different underlying data structure.

## Binary Search Tree

The `BinarySearchTree` class implements a generic Binary Search Tree data structure. It supports operations such as insertion, retrieval, and deletion of key-value pairs. Additionally, it provides an iterator for traversing the tree in ascending order of keys.

### Usage

To use the Binary Search Tree, instantiate an object of the `BinarySearchTree` class and perform operations such as `put()`, `get()`, and `delete()`.

Example:

```java
BinarySearchTree<Integer, Character> bst = new BinarySearchTree<>();
bst.put(1, 'A');
bst.put(2, 'B');
bst.put(3, 'C');
System.out.println(bst.get(2)); // Output: B
bst.delete(2);

