
////1.	Write a program to calculate Fibonacci numbers and find its step count

package Java;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 10; // Specify the position in the Fibonacci sequence
        int result = fibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + result);
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1, c = 0;
        int stepCount = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
            stepCount++;
        }

        System.out.println("Step count: " + stepCount);
        return c;
    }
    
}

////-----------------------------------------------------------------------------------------

// //By Recurssive Way 

// public class Fibonacci {

//     public static void main(String[] args) {
//         int n = 10; // Specify the position in the Fibonacci sequence
//         int result = fibonacci(n);
//         System.out.println("Fibonacci number at position " + n + " is: " + result);
//     }

//     public static int fibonacci(int n) {
//         if (n <= 1) {
//             return n;
//         }
//         return fibonacci(n - 1) + fibonacci(n - 2);
//     }
// }

