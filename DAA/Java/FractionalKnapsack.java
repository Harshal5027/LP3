package Java;

// import java.util.Arrays;
// import java.util.Comparator;



// class Item {
//     double weight;
//     double value;

//     // Constructor
//     public Item(double weight, double value) {
//         this.weight = weight;
//         this.value = value;
//     }
// }

// public class FractionalKnapsack {

//     // Method to calculate the maximum value for the given knapsack capacity
//     public static double getMaxValue(Item[] items, double capacity) {
//         // Sort items by value-to-weight ratio in descending order
//         Arrays.sort(items, new Comparator<Item>() {
//             @Override
//             public int compare(Item item1, Item item2) {
//                 double r1 = item1.value / item1.weight;
//                 double r2 = item2.value / item2.weight;
//                 return Double.compare(r2, r1);
//             }
//         });

//         double totalValue = 0.0;

//         for (Item item : items) {
//             if (capacity > 0 && item.weight <= capacity) {
//                 // Take the whole item
//                 capacity -= item.weight;
//                 totalValue += item.value;
//             } else {
//                 // Take the fractional part of the item
//                 double fraction = capacity / item.weight;
//                 totalValue += item.value * fraction;
//                 capacity = 0;
//                 break;
//             }
//         }

//         return totalValue;
//     }

//     public static void main(String[] args) {
//         // Example items (weight, value)
//         Item[] items = {
//             new Item(10, 60),
//             new Item(20, 100),
//             new Item(30, 120)
//         };
        
//         double capacity = 50; // Knapsack capacity
//         double maxValue = getMaxValue(items, capacity);
//         System.out.println("Maximum value in Knapsack = " + maxValue);
//     }
    
// }



import java.util.*;

// Class to represent an item
class Item {
    double value;
    double weight;
    
    // Constructor to initialize item
    public Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Method to solve the fractional knapsack problem
    public static double getMaxValue(Item[] items, double capacity) {
        // Step 1: Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        
        double totalValue = 0.0;  // Total value in the knapsack
        double remainingCapacity = capacity;

        // Step 2: Add items to the knapsack
        for (Item item : items) {
            if (remainingCapacity == 0) {
                break;  // Knapsack is full
            }

            if (item.weight <= remainingCapacity) {
                // If the item can be fully added
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // If the item can only be partially added
                totalValue += item.value * ((double) remainingCapacity / item.weight);
                remainingCapacity = 0;  // Knapsack is now full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Example items (value, weight)
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        double capacity = 50;  // Knapsack capacity

        // Calculate and print the maximum value we can carry
        double maxValue = getMaxValue(items, capacity);
        
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}