PROGRAM:

import java.util.Scanner;
import java.util.function.BiFunction;

public class LastDigitSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        BiFunction<Integer, Integer, Integer> sumLastDigits =
                (x, y) -> (x % 10) + (y % 10);

        System.out.println("Sum of last digits = " + sumLastDigits.apply(a, b));

        sc.close();
    }
}

OUTPUT:

Enter first number: 17
Enter second number: 22
Sum of last digits = 9
