import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<String> items = new LinkedHashSet<>();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item: ");
            items.add(sc.nextLine());
        }

        System.out.println("\nUnique Items Purchased:");
        for (String item : items) {
            System.out.println(item);
        }
    }
}
