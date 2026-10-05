import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> history = new Stack<>();

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter page: ");
            history.push(sc.nextLine());
        }

        System.out.println("\nBrowser History: " + history);

        System.out.print("How many times to press Back? ");
        int back = sc.nextInt();

        for (int i = 0; i < back; i++) {
            if (!history.isEmpty()) {
                System.out.println("Back from: " + history.pop());
            } else {
                System.out.println("No more pages in history.");
            }
        }

        if (!history.isEmpty()) {
            System.out.println("Current Page: " + history.peek());
        } else {
            System.out.println("No page available.");
        }

        System.out.println("Remaining History: " + history);
    }
}
