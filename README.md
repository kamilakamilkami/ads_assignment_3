# Algorithm and Data Structures Assignment 3

# Hash Table

The `MyHashTable` class implements a generic Hash Table data structure. It handles collisions using separate chaining and automatically resizes itself to maintain a load factor below a specified threshold.

## Usage

To use the Hash Table, instantiate an object of the `MyHashTable` class and perform operations such as `insert()`, `retrieve()`, and `delete()`.


# TestClass

The `TestClass` class is a simple class used for testing the Hash Table. It provides custom implementations of `hashCode()` and `equals()` methods to define equality of objects.

## Custom Hashing

The `TestClass` class overrides the `hashCode()` method to provide custom hashing based on the object's properties.


# Test Class: Book

The `Book` class represents a simple book object with properties such as title and author.

## Properties

- `title`: Represents the title of the book.
- `author`: Represents the author of the book.

## Constructors

- `Book(String title, String author)`: Initializes a new instance of the `Book` class with the specified title and author.

## Methods

- `getTitle()`: Returns the title of the book.
- `setTitle(String title)`: Sets the title of the book.
- `getAuthor()`: Returns the author of the book.
- `setAuthor(String author)`: Sets the author of the book.


# Binary Search Tree

The `BinarySearchTree` class implements a generic Binary Search Tree data structure. It supports operations such as insertion, retrieval, and deletion of key-value pairs. Additionally, it provides an iterator for traversing the tree in ascending order of keys.

### Usage

To use the Binary Search Tree, instantiate an object of the `BinarySearchTree` class and perform operations such as `put()`, `get()`, and `delete()`.

```java
BinarySearchTree<Integer, Character> bst = new BinarySearchTree<>();
bst.put(1, 'A');
bst.put(2, 'B');
bst.put(3, 'C');
System.out.println(bst.get(2)); // Output: B
bst.delete(2);




