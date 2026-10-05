import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Object>> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter grade: ");
            double grade = sc.nextDouble();

            ArrayList<Object> student = new ArrayList<>();
            student.add(name);
            student.add(grade);

            students.add(student);
        }

        // Find lowest grade
        double lowest = Double.MAX_VALUE;

        for (ArrayList<Object> student : students) {
            double grade = (double) student.get(1);

            if (grade < lowest) {
                lowest = grade;
            }
        }

        // Find second lowest grade
        double secondLowest = Double.MAX_VALUE;

        for (ArrayList<Object> student : students) {
            double grade = (double) student.get(1);

            if (grade > lowest && grade < secondLowest) {
                secondLowest = grade;
            }
        }

        // Store names with second lowest grade
        ArrayList<String> names = new ArrayList<>();

        for (ArrayList<Object> student : students) {
            String name = (String) student.get(0);
            double grade = (double) student.get(1);

            if (grade == secondLowest) {
                names.add(name);
            }
        }

        // Sort names alphabetically
        Collections.sort(names);

        System.out.println("\nStudents with second lowest grade:");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
