import java.util.*;

public class Challenge_23 {

    // Function to find the maximum in every sliding window of size k
    public static int[] findMaxInSlidingWindow(int[] arr, int windowSize) {
        if (arr.length == 0 || windowSize == 0) return arr;

        int length = arr.length;
        int[] maxWindowValues = new int[length - windowSize + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            // Remove elements outside the current window
            if (!deque.isEmpty() && deque.peek() < i - windowSize + 1) {
                deque.poll();
            }

            // Remove smaller elements in the window
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add the current element index to the deque
            deque.offer(i);

            // Start recording the max value once the first window is complete
            if (i >= windowSize - 1) {
                maxWindowValues[i - windowSize + 1] = arr[deque.peek()];
            }
        }

        return maxWindowValues;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        
        if (size <= 0) {
            System.out.println("Invalid array size.");
            scanner.close();
            return;
        }

        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter the window size (K):");
        int windowSize = scanner.nextInt();

        if (windowSize <= 0 || windowSize > size) {
            System.out.println("Invalid window size.");
            scanner.close();
            return;
        }

        // Call the function to find the maximum in each sliding window
        int[] result = findMaxInSlidingWindow(array, windowSize);
        System.out.println("Maximum values in each sliding window: " + Arrays.toString(result));

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
