package interview_preparation_kit.warm_up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class SalesByMatchResult {

	/*
	 * Complete the 'sockMerchant' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n 2. INTEGER_ARRAY ar
	 */

	public static int sockMerchant(int n, List<Integer> ar) {
		List<Integer> l = new ArrayList<>();
		int pairs = 0;
		for (Integer i : ar) {
			if (l.contains(i)) {
				pairs++;
				l.remove(i);
			} else {
				l.add(i);
			}
		}
		return pairs;
	}

}

public class SalesByMatch {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> ar = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arTemp[i]);
			ar.add(arItem);
		}

		int result = SalesByMatchResult.sockMerchant(n, ar);

		System.out.println(result);
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();

		bufferedReader.close();
//		bufferedWriter.close();
	}
}
