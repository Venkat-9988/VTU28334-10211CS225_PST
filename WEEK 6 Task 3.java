import java.util.*;

public class Main {

    static String twoStrings(String s1, String s2) {
        boolean[] seen = new boolean[26];

        // Store characters of s1
        for (char c : s1.toCharArray()) {
            seen[c - 'a'] = true;
        }

        // Check characters of s2
        for (char c : s2.toCharArray()) {
            if (seen[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(twoStrings(s1, s2));
        }

        sc.close();
    }
}
