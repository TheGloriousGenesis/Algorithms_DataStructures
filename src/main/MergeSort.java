package main;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int[] helper = new int[n];
        for(int i=0; i<n; i++) {
            array[i] = scanner.nextInt();
        }
        mergeSort(array, helper, 0, n - 1);
        for(int i: array) {
            System.out.printf(i + " ");
        }
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (high + low) /2 ;
            mergeSort(array, helper, low, mid);
            mergeSort(array, helper, mid+1, high);
            mergeSort(array, helper, low, mid, high);
        }
    }

    private static void mergeSort(int[] array, int[] helper, int low, int mid, int high) {
        for(int i=0; i<=high; i++) {
            helper[i] = array[i];
        }
        int leftSubArray = low;
        int rightSubArray = mid + 1;
        int pointer = low;
        while(leftSubArray <= mid && rightSubArray <= high) {
            if (helper[leftSubArray] <= helper[rightSubArray]) {
                array[pointer] = helper[leftSubArray];
                leftSubArray++;
            } else {
                array[pointer] = helper[rightSubArray];
                rightSubArray++;
            }
            pointer++;
        }
        int remaining = mid - leftSubArray;

        // right side already copied over as element are already in copy array
        for (int i=0; i<remaining; i++) {
            array[pointer + i] = helper[leftSubArray + i];
        }
    }
}
