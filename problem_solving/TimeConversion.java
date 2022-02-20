package problem_solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

	/*
	 * Complete the 'timeConversion' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String timeConversion(String s) {
		// Write your code here
		String[] parts = s.split(":");
		int hour = new Integer(parts[0]);
		if (s.endsWith("PM")) {
			if (hour < 12) {
				hour = hour + 12;
				if (hour > 23) {
					hour = 0;
				}
			}
		} else {
			if (hour == 12) {
				hour = 0;
			}
		}
		String hrInString = "";
		if (hour >= 0 && hour < 10) {
			hrInString = "0" + hour;
		} else {
			hrInString = "" + hour;
		}
		return hrInString + ":" + parts[1] + ":" + parts[2].substring(0, 2);
	}

}

public class TimeConversion {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = Result.timeConversion(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
