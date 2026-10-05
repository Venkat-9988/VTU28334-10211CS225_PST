import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int[] count = new int[26];

        // Count characters
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
