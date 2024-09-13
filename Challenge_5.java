import java.util.ArrayList;
import java.util.Collections;

public class Challenge_5 {
    public static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        if (n == 0) {
            return leaders; // Return empty list for an empty array
        }

        // The rightmost element is always a leader
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);

        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }

        // The leaders are currently in reverse order, reverse them to maintain original order
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        System.out.println("Leaders: " + findLeaders(arr1));

        // Test Case 2
        int[] arr2 = {1, 2, 3, 4, 0};
        System.out.println("Leaders: " + findLeaders(arr2));

        // Test Case 3
        int[] arr3 = {7, 10, 4, 10, 6, 5, 2};
        System.out.println("Leaders: " + findLeaders(arr3));

        // Test Case 4
        int[] arr4 = {5};
        System.out.println("Leaders: " + findLeaders(arr4));

        // Test Case 5
        int[] arr5 = {100, 50, 20, 10};
        System.out.println("Leaders: " + findLeaders(arr5));
    }
}

