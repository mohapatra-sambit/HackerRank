package problem_solving;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double plusCount = 0;
        double minusCount = 0;
        double zeroCount = 0;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] > 0) {
                ++plusCount;
            } else if (arr[i] < 0) {
                ++minusCount;
            } else {
                ++zeroCount;
            }
        }
        DecimalFormat df = new DecimalFormat("###.######");
        
        System.out.println(df.format((plusCount/arr.length)));
        System.out.println(df.format((minusCount/arr.length)));
        System.out.println(df.format((zeroCount/arr.length)));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
