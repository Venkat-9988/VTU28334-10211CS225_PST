import java.io.*;

class Result {

    public static String timeConversion(String s) {

        String[] parts = s.split(":");

        int hour = Integer.parseInt(parts[0]);
        String minutes = parts[1];
        String seconds = parts[2].substring(0, 2);
        String period = parts[2].substring(2);

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else { // PM
            if (hour != 12) {
                hour += 12;
            }
        }

        return String.format("%02d:%s:%s", hour, minutes, seconds);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
