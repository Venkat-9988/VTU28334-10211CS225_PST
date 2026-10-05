import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> marks = new TreeSet<>();

        System.out.print("Enter number of marks: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark: ");
            marks.add(sc.nextInt());
        }

        System.out.println("\nUnique Marks in Ascending Order:");

        for (int mark : marks) {
            System.out.println(mark);
        }
    }
}
