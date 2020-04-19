import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        int[] helper = new int[arr.length];
        long counter = mergeSort(arr, helper, 0, arr.length-1);
        return counter;
    }

    static long mergeSort(int[] arr, int[] helper, int low, int high) {
        long counter = 0;
        if (low < high) {
            int mid = (high + low) / 2;
            counter += mergeSort(arr, helper, low, mid);
            counter += mergeSort(arr, helper, mid+1, high);
            counter += mergeSort(arr, helper, low, mid, high);
        }
        return counter;
    }

    static long mergeSort(int[] arr, int[] helper, int low, int mid, int high) {
        long counter = 0;
        for(int i=low; i<= high; i++) {
            helper[i] = arr[i];
        }

        int leftSubarray = low;
        int rightSubarray = mid + 1;
        int pointer = low;

        while(leftSubarray <= mid && rightSubarray <= high) {
            if (helper[leftSubarray] <= helper[rightSubarray]) {
                arr[pointer] = helper[leftSubarray];
                leftSubarray++;
            } else {
                arr[pointer] = helper[rightSubarray];
                rightSubarray++;
                counter+= mid + 1 - leftSubarray;
            }
            pointer++;
        }

        int remaining = mid - leftSubarray;

        for(int i= 0; i<= remaining; i++) {
            arr[pointer + i] = helper[leftSubarray + i];
        }

        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
