package problem_solving;

import java.util.Scanner;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long maxSum = 0;
        long minSum = Long.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            long temp = 0;
            for(int j=0; j<arr.length; j++) {
                if (i != j) {
                    temp += arr[j];
                }
            }
            if (maxSum < temp) {
                maxSum = temp;
            }
            if (minSum > temp) {
                minSum = temp;
            }
        }
        System.out.println(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
