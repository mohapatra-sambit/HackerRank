package interview_preparation_kit.warm_up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

	/*
	 * Complete the 'countingValleys' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER steps 2. STRING path
	 */

	public static int countingValleys(int steps, String path) {
		int count = 0, numOfValleys = 0;
		boolean flag = true;
		for (int i = 0; i < path.length(); i++) {
			switch (path.charAt(i)) {
			case 'U':
				++count;
				break;
			case 'D':
				--count;
				break;
			default:
				continue;
			}
			if (count < 0) {
				if (flag) {
					++numOfValleys;
					flag = false;
				}
			} else {
				flag = true;
			}
		}
		return numOfValleys;
	}

}

public class CountingValleys {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int steps = Integer.parseInt(bufferedReader.readLine().trim());

		String path = bufferedReader.readLine();

		int result = Result.countingValleys(steps, path);

		System.out.println(result);

		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
