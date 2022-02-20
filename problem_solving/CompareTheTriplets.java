package problem_solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplets {

	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> points = new ArrayList<Integer>(2);
		points.add(0, 0);
		points.add(1, 0);
		for (int i = 0; i < 3; i++) {
			if (a.get(i) > b.get(i)) {
				points.set(0, points.get(0) + 1);
			} else if (a.get(i) < b.get(i)) {
				points.set(1, points.get(1) + 1);
			}
		}
		return points;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> a = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a.add(aItem);
		}

		String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> b = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int bItem = Integer.parseInt(bItems[i]);
			b.add(bItem);
		}

		List<Integer> result = compareTriplets(a, b);

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
