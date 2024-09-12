import java.util.Arrays;

public class Challenge_4 {
    // Function to calculate the next gap
    private static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }
        return (gap / 2) + (gap % 2); // Ceiling of gap/2
    }

    // Function to merge arr1 and arr2 without extra space
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int gap = m + n; // Initial gap size is the sum of both arrays' lengths
        gap = nextGap(gap);

        while (gap > 0) {
            // Compare elements in the first array arr1
            for (int i = 0; i + gap < m; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    // Swap arr1[i] and arr1[i + gap]
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }

            // Compare elements between arr1 and arr2
            for (int i = 0; i < m && i + gap - m < n; i++) {
                if (arr1[i] > arr2[i + gap - m]) {
                    // Swap arr1[i] and arr2[i + gap - m]
                    int temp = arr1[i];
                    arr1[i] = arr2[i + gap - m];
                    arr2[i + gap - m] = temp;
                }
            }

            // Compare elements in the second array arr2
            for (int i = 0; i + gap < n; i++) {
                if (arr2[i] > arr2[i + gap]) {
                    // Swap arr2[i] and arr2[i + gap]
                    int temp = arr2[i];
                    arr2[i] = arr2[i + gap];
                    arr2[i + gap] = temp;
                }
            }

            gap = nextGap(gap); // Reduce the gap for the next iteration
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));

        // Test Case 2
        int[] arr3 = {10, 12, 14};
        int[] arr4 = {1, 3, 5};
        merge(arr3, arr4, arr3.length, arr4.length);
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("arr4: " + Arrays.toString(arr4));

        // Test Case 3
        int[] arr5 = {2, 3, 8};
        int[] arr6 = {4, 6, 10};
        merge(arr5, arr6, arr5.length, arr6.length);
        System.out.println("arr5: " + Arrays.toString(arr5));
        System.out.println("arr6: " + Arrays.toString(arr6));

        // Test Case 4
        int[] arr7 = {1};
        int[] arr8 = {2};
        merge(arr7, arr8, arr7.length, arr8.length);
        System.out.println("arr7: " + Arrays.toString(arr7));
        System.out.println("arr8: " + Arrays.toString(arr8));
    }
}
