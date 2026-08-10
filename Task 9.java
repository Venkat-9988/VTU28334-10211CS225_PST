Task 9: Count the Number of Digits in an Integer


import java.util.Scanner;

public class Main {

    // Method to count the digits
    public static int countDigits(int num) {
        if (num == 0) {
            return 1;
        }

        int count = 0;
        num = Math.abs(num);

        while (num > 0) {
            count++;
            num = num / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        int digits = countDigits(num);

        System.out.println("Number of digits = " + digits);

        sc.close();
    }
}


Enter an integer: 12345
Number of digits = 5

=== Code Execution Successful ===
