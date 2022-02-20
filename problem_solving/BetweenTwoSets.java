package problem_solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BetweenTwoSetsResult {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        //System.out.println(a);
        //System.out.println(b);

        int min = determineMin(b);
        //System.out.println("Min is b: " + min);
        int incr = determineMax(a);
        //System.out.println("Max is a: " + incr);
        int gcd = gcd(a);
        //System.out.println("GCD of a: " + gcd);
        int count = 0;
        for (int i = gcd; i <= min; i++) {
            //System.out.println("i: " + i);
            if (areAllNumberFactors(a, i)) {
                //System.out.println("All are factors in a");
                if (isFactorForAllNumbers(b, i)) {
                    //System.out.println("Factor for all in b");
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isFactorForAllNumbers(List<Integer> b, int i) {
        for (Integer n : b) {
            if (n % i != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean areAllNumberFactors(List<Integer> a, int i) {
        for (Integer n : a) {
            if (i % n != 0) {
                return false;
            }
        }
        return true;
    }

    private static int gcd(List<Integer> a) {
        int result = 0;
        for (Integer i : a) {
            result = gcd(result, i);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static int determineMax(List<Integer> a) {
        Collections.sort(a);
        return a.get(a.size() - 1);
    }

    private static int determineMin(List<Integer> b) {
        Collections.sort(b);
        return b.get(0);
    }

}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = BetweenTwoSetsResult.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
