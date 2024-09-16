import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge_6 {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Check if the prefix sum itself is zero
            if (prefixSum == 0) {
                result.add(new int[] {0, i});
            }

            // Check if this prefix sum was seen before
            if (prefixSumMap.containsKey(prefixSum)) {
                int startIndex = prefixSumMap.get(prefixSum) + 1;
                result.add(new int[] {startIndex, i});
            }

            // Store the prefix sum with the current index
            prefixSumMap.put(prefixSum, i);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example inputs
        int[] arr1 = {1, 2, -3, 3, -1, 2};
        int[] arr2 = {4, -1, -3, 1, 2, -1};
        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {0, 0, 0};
        int[] arr5 = {-3, 1, 2, -3, 4, 0};

        // Find zero sum subarrays
        System.out.println("Subarrays with zero sum in arr1: " + printSubarrays(findZeroSumSubarrays(arr1)));
        System.out.println("Subarrays with zero sum in arr2: " + printSubarrays(findZeroSumSubarrays(arr2)));
        System.out.println("Subarrays with zero sum in arr3: " + printSubarrays(findZeroSumSubarrays(arr3)));
        System.out.println("Subarrays with zero sum in arr4: " + printSubarrays(findZeroSumSubarrays(arr4)));
        System.out.println("Subarrays with zero sum in arr5: " + printSubarrays(findZeroSumSubarrays(arr5)));
    }

    private static String printSubarrays(List<int[]> subarrays) {
        StringBuilder sb = new StringBuilder();
        for (int[] subarray : subarrays) {
            sb.append("[");
            sb.append(subarray[0]);
            sb.append(", ");
            sb.append(subarray[1]);
            sb.append("] ");
        }
        return sb.toString();
    }
}
