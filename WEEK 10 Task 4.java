import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> marks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark: ");
            marks.add(sc.nextInt());
        }

        int highest = marks.get(0);
        int total = 0;

        System.out.println("\nStudent Marks:");

        for (int mark : marks) {
            System.out.println(mark);

            if (mark > highest) {
                highest = mark;
            }

            total += mark;
        }

        double average = (double) total / marks.size();

        System.out.println("Highest Mark = " + highest);
        System.out.println("Average = " + average);
    }
}
