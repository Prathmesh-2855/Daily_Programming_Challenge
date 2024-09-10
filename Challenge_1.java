import java.util.Arrays;

public class Sort012 {
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid], increment both low and mid
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // If the element is 1, just move mid to the next position
                mid++;
            } else {
                // Swap arr[mid] and arr[high], decrement high
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 0, 2, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr)); // Output: [0, 0, 0, 1, 1, 1, 2, 2]
        
        int[] arr2 = {2, 2, 2, 2};
        sortColors(arr2);
        System.out.println(Arrays.toString(arr2)); // Output: [2, 2, 2, 2]
        
        int[] arr3 = {0, 0, 0, 0};
        sortColors(arr3);
        System.out.println(Arrays.toString(arr3)); // Output: [0, 0, 0, 0]
        
        int[] arr4 = {1, 1, 1, 1};
        sortColors(arr4);
        System.out.println(Arrays.toString(arr4)); // Output: [1, 1, 1, 1]
        
        int[] arr5 = {2, 0, 1};
        sortColors(arr5);
        System.out.println(Arrays.toString(arr5)); // Output: [0, 1, 2]
        
        int[] arr6 = {};
        sortColors(arr6);
        System.out.println(Arrays.toString(arr6)); // Output: []
    }
}
