package org.example;
import org.example.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Spausdinti su random skip dydziu: ");
        SkipListRandom<Integer, String> skipList = new SkipListRandom<>();

        // Insert key-value pairs
        skipList.insert(10, "Alice");
        skipList.insert(25, "Bob");
        skipList.insert(5, "Charlie");
        skipList.insert(15, "David");
        skipList.insert(20, "Eva");
        skipList.insert(12, "Frank");
        skipList.insert(7, "Grace");
        skipList.insert(3, "Henry");
        skipList.insert(18, "Ivy");
        skipList.insert(30, "Jack");

        skipList.print();

        // Search for values
        System.out.println("Value for key 10: " + skipList.search(10));
        System.out.println("Value for key 25: " + skipList.search(25));
        System.out.println("Value for key 5: " + skipList.search(5));
        System.out.println("Value for key 15: " + skipList.search(15));
        System.out.println("Value for key 20: " + skipList.search(20));

        // Delete nodes
        skipList.remove(25);
        System.out.println("After deleting key 25: " + skipList.search(25));

        // Insert more key-value pairs
        skipList.insert(12, "Eva");
        skipList.insert(30, "Frank");

        // Search again after insertion and deletion
        System.out.println("Value for key 12: " + skipList.search(12));
        System.out.println("Value for key 25: " + skipList.search(25)); // Should be null after deletion
        System.out.println("Value for key 30: " + skipList.search(30));


        System.out.println("Spausdinti su fiksuotu skip dydziu: ");
        SkipListFixed<Integer, String> skipListFixed = new SkipListFixed<>();

        // Insert key-value pairs
        skipListFixed.insert(10, "Alice");
        skipListFixed.insert(25, "Bob");
        skipListFixed.insert(5, "Charlie");
        skipListFixed.insert(15, "David");
        skipListFixed.insert(20, "Eva");
        skipListFixed.insert(12, "Frank");
        skipListFixed.insert(7, "Grace");
        skipListFixed.insert(3, "Henry");
        skipListFixed.insert(18, "Ivy");
        skipListFixed.insert(30, "Jack");

        skipListFixed.print();

        // Search for values
        System.out.println("Value for key 10: " + skipListFixed.search(10));
        System.out.println("Value for key 25: " + skipListFixed.search(25));
        System.out.println("Value for key 5: " + skipListFixed.search(5));
        System.out.println("Value for key 15: " + skipListFixed.search(15));
        System.out.println("Value for key 20: " + skipListFixed.search(20));

        // Delete nodes
        skipListFixed.remove(25);
        System.out.println("After deleting key 25: " + skipListFixed.search(25));

        // Insert more key-value pairs
        skipListFixed.insert(12, "Eva");
        skipListFixed.insert(30, "Frank");

        // Search again after insertion and deletion
        System.out.println("Value for key 12: " + skipListFixed.search(12));
        System.out.println("Value for key 25: " + skipListFixed.search(25)); // Should be null after deletion
        System.out.println("Value for key 30: " + skipListFixed.search(30));
    }
}