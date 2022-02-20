package problem_solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class BreakingTheRecordsResult {

	/*
	 * Complete the 'breakingRecords' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY scores as parameter.
	 */

	public static List<Integer> breakingRecords(List<Integer> scores) {
		int max = scores.get(0);
		int min = scores.get(0);
		int maxRecordCount = 0, minRecordCount = 0;
		for (int i = 1; i < scores.size(); i++) {
			if (max < scores.get(i)) {
				max = scores.get(i);
				maxRecordCount++;
			}
			if (min > scores.get(i)) {
				min = scores.get(i);
				minRecordCount++;
			}
		}
		List<Integer> result = new ArrayList<>();
		result.add(maxRecordCount);
		result.add(minRecordCount);
		return result;
	}

}

public class BreakingTheRecords {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		String[] scoresTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> scores = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int scoresItem = Integer.parseInt(scoresTemp[i]);
			scores.add(scoresItem);
		}

		List<Integer> result = BreakingTheRecordsResult.breakingRecords(scores);

		for (int i = 0; i < result.size(); i++) {
			bufferedWriter.write(String.valueOf(result.get(i)));

			if (i != result.size() - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
