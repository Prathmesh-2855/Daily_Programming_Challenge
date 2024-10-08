import java.util.*;

public class Challenge_22 {

    public static int firstOccurKtime(int[] arr, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Iterate over the array (not the HashMap) to preserve the order of first occurrence
        for (int num : arr) {
            if (frequencyMap.get(num) == k) {
                return num;
            }
        }

        return -1; // If no element occurs exactly k times
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2};
        int k = 2;

        System.out.println(firstOccurKtime(arr, k));
    }
}
