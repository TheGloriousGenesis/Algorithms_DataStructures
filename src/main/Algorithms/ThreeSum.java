import java.util.Arrays;
import java.util.HashMap;

public class ThreeSum {

    public static void main(String[] args) {
        int threeSum = threeSum(new int[]{1, 2, 3, -3});
        System.out.println(threeSum);
        int inBitonicArray =  bitonicArray(new int[]{1,2,4,5, 3,0}, 9);
        System.out.println(inBitonicArray);
    }

    private static int threeSum(int[] arr1) {
        Arrays.sort(arr1);
        int numberOfThreeSums = 0;
        HashMap<Integer, Integer> memory = new HashMap<>();
        for (int i=0; i<arr1.length; i++) {
            memory.put(arr1[i], i);
        }

        for (int i=0; i<arr1.length; i++) {
            for (int j=i + 1; j<arr1.length; j++) {
                numberOfThreeSums+= memory.containsKey(-(arr1[i] + arr1[j])) ? 1 : 0;
            }
        }
        return numberOfThreeSums;
    }

    private static int bitonicArray(final int[] arr, final int element) {
        int indexOfPeak = binaryMaxSearch(arr, 0, arr.length -1);
        if (arr[indexOfPeak] < element) {
            return -1;
        }
        if (arr[indexOfPeak] == element) {
            return element;
        }
        int searchAscendingSection = binarySearchInOrder(arr, 0, indexOfPeak-1, element);
        if (searchAscendingSection != -1 ){
            return searchAscendingSection;
        }
        return binarySearchReverse(arr, indexOfPeak + 1, arr.length - 1, element);
    }

    private static int binaryMaxSearch(int[] arr, int low, int high) {
        if (high < low) {
            return -1;
        }
        int mid = (high + low) / 2;
        int midMinusOne = mid-1;
        int midPlusOne = mid+1;
        boolean inRange = midMinusOne <= high && midPlusOne >= 0;
        if (inRange && (arr[midPlusOne] <= arr[mid] && arr[midMinusOne] <= arr[mid])) {
            return mid;
        }
        if (inRange && (arr[midMinusOne] <= arr[mid] && arr[mid] <= arr[midPlusOne])) {
            return binaryMaxSearch(arr,mid+1, high);
        }
        if (inRange && (arr[midMinusOne] >= arr[mid] && arr[mid] >= arr[midPlusOne])) {
            return binaryMaxSearch(arr,low, mid-1);
        }
        return -1;
    }

    private static int binarySearchInOrder(int[] arr, int low, int high, int element) {
        if (high < low) {
            return -1;
        }
        int mid = (high + low) / 2;
        if (arr[mid] == element) {
            return arr[mid];
        }
        if (element < arr[mid] ) {
            return binarySearchInOrder(arr, low, mid-1, element);
        }

        if (element > arr[mid]) {
            return binarySearchInOrder(arr, mid+1, high, element);
        }
        return -1;
    }

    private static int binarySearchReverse(int[] arr, int low, int high, int element) {
        if (high < low) {
            return -1;
        }
        int mid = (high + low) / 2;
        if (arr[mid] == element) {
            return arr[mid];
        }
        if (element > arr[mid] ) {
            return binarySearchReverse(arr, low, mid-1, element);
        }

        if (element < arr[mid]) {
            return binarySearchReverse(arr, mid+1, high, element);
        }
        return -1;
    }

}
