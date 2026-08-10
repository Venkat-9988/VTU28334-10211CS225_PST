Task 8: Is Palindrome Number?


import java.util.Scanner;

public class Main {

    // Method to check whether a number is palindrome
    public static boolean isPalindrome(int num) {
        int original = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        return original == reverse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isPalindrome(num)) {
            System.out.println(num + " is a Palindrome Number.");
        } else {
            System.out.println(num + " is Not a Palindrome Number.");
        }

        sc.close();
    }
}


Enter a number: 121
121 is a Palindrome Number.

=== Code Execution Successful ===
