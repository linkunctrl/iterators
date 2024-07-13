package related;

import java.util.*;

public class IterableDemo {
    public static void main(String[] args) {
        CustomCollection collection = new CustomCollection(4);
        collection.add("Item 1");
        collection.add("Item 2");
        collection.add("Item 3");
        collection.add("Item 4");

        System.out.println("Initial Collection:");
        for (String item : collection) {
            System.out.println(item);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an index to remove:");
        int removeindex = sc.nextInt();;


        try {
            collection.removeAtIndex(removeindex);
            System.out.println("Item at index " + removeindex + " removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCollection After Removal:");
        for (String item : collection) {
            System.out.println(item);
        }

        sc.close();
    }
    }

