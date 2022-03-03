package interview_preparation_kit.warm_up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RepeatedStringResult {

	/*
	 * Complete the 'repeatedString' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. STRING s 2. LONG_INTEGER n
	 */

	public static long repeatedString(String s, long n) {
		if (s.trim().length() == 0) {
			return 0;
		}
		int len = s.length();
		if (n <= len) {
			return countA(s.substring(0, (int)n));
		}
		long numOfAs = countA(s);
		long rep = n / len;
		long count = numOfAs * rep;
		long rem = n % len;
		if (rem > 0) {
			count += countA(s.substring(0, (int)rem));
		}
		return count;
	}

	private static long countA(String s) {
		return s.chars().filter(ch -> {
			if ('a' == (char) ch) {
				return true;
			}
			return false;
		}).count();
	}

}

public class RepeatedString {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String s = bufferedReader.readLine();
		long n = Long.parseLong(bufferedReader.readLine().trim());
		long result = RepeatedStringResult.repeatedString(s, n);
		System.out.println(result);
		bufferedReader.close();
	}
}
