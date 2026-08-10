Task 7: Nth Fibonacci Number


import java.util.Scanner;

public class Main {

    // Method to find the Nth Fibonacci number
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int first = 0, second = 1, next = 0;

        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        System.out.println("The " + n + "th Fibonacci number is: " + fibonacci(n));

        sc.close();
    }
}



Enter the value of N: 7
The 7th Fibonacci number is: 13

=== Code Execution Successful ===
