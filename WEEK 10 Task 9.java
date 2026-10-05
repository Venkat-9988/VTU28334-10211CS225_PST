import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> marks = new HashMap<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();

            System.out.print("Enter marks: ");
            int mark = sc.nextInt();

            marks.put(roll, mark);
        }

        System.out.print("\nEnter roll number to search: ");
        int searchRoll = sc.nextInt();

        if (marks.containsKey(searchRoll)) {
            System.out.println("Marks = " + marks.get(searchRoll));
        } else {
            System.out.println("Student not found.");
        }
    }
}
