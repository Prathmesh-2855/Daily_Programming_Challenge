public class Challenge_3 {
    public static int findDuplicate(int[] arr) {
        // Step 1: Initialize two pointers (tortoise and hare)
        int tortoise = arr[0];
        int hare = arr[0];
        
        // Step 2: Move tortoise by 1 step and hare by 2 steps until they meet
        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while (tortoise != hare);
        
        // Step 3: Find the entrance to the cycle (which is the duplicate number)
        tortoise = arr[0];
        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }
        
        // The duplicate number
        return hare;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number: " + findDuplicate(arr1)); // Output: 2

        // Test Case 2
        int[] arr2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate number: " + findDuplicate(arr2)); // Output: 3

        // Test Case 3
        int[] arr3 = {1, 1};
        System.out.println("Duplicate number: " + findDuplicate(arr3)); // Output: 1

        // Test Case 4
        int[] arr4 = {1, 4, 4, 2, 3};
        System.out.println("Duplicate number: " + findDuplicate(arr4)); // Output: 4

        // Test Case 5
        int n = 99999;
        int[] arr5 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr5[i - 1] = i;
        }
        arr5[n] = 50000; // Introduce a duplicate
        System.out.println("Duplicate number: " + findDuplicate(arr5)); // Output: 50000
    }
}

