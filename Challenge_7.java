public class Challenge_7 {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;  // Left pointer
        int right = height.length - 1;  // Right pointer
        int leftMax = 0;  // Maximum height to the left of the current bar
        int rightMax = 0;  // Maximum height to the right of the current bar
        int waterTrapped = 0;  // Total amount of trapped water

        while (left < right) {
            // Compare the left and right heights
            if (height[left] < height[right]) {
                // If left bar is shorter, calculate water from the left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // Update left max
                } else {
                    waterTrapped += leftMax - height[left];  // Water trapped at current bar
                }
                left++;  // Move the left pointer to the right
            } else {
                // If right bar is shorter, calculate water from the right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // Update right max
                } else {
                    waterTrapped += rightMax - height[right];  // Water trapped at current bar
                }
                right--;  // Move the right pointer to the left
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        // Example test cases
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + trap(height1));  // Output: 6

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Trapped water: " + trap(height2));  // Output: 9

        int[] height3 = {2, 0, 2};
        System.out.println("Trapped water: " + trap(height3));  // Output: 2
    }
}
