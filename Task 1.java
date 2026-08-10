mport java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }

   public PerformOperation isOdd() {
    return (int a) -> a % 2 != 0;
}
public PerformOperation isPrime() {
    return (int a) -> {
        if (a <= 1) return false;
        if (a == 2) return true;
        if (a % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(a); i += 2) {
            if (a % i == 0) return false;
        }
        return true;
    };
}
public PerformOperation isPalindrome() {
    return (int a) -> {
        String s = String.valueOf(a);
        return new StringBuilder(s).reverse().toString().equals(s);
    };
  }
}




OUTPUT : Input (stdin)
5
1 4
2 5
3 898
1 3
2 12

Your Output (stdout)
EVEN
PRIME
PALINDROME
ODD
COMPOSITE

Expected Output
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
