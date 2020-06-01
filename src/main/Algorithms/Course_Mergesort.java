import java.util.LinkedList;

public class Course_Mergesort {
    private static void sort(final int[] a,
                             final int[] b) {
        int[] ab = new int[a.length + b.length];
        int pointerA = 0;
        int pointerB = 0;
        int pointerAB = 0;

        while (pointerA + pointerB < (a.length + b.length) - 1) {
            if (a[pointerA] < b[pointerB]) {
                ab[pointerAB] = a[pointerA];
                pointerA++;
            } else if (a[pointerA] == b[pointerB]) {
                ab[pointerAB] = a[pointerA];
                pointerA++;
                pointerB++;
            } else {
                ab[pointerAB] = b[pointerB];
                pointerB++;
            }
            pointerAB++;
        }
    }

    private static int countingInversions(final int[] a) {
        //pair of entries (doesn't need to be side by side) where a[i] > a[j]
        // and i < j
        // [4, 3, 8, 1, 2, -4] -> 11
        int count = 0;
        for (int i=0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void shuffleLinkedList(final LinkedList<Integer> list) {

    }


}
