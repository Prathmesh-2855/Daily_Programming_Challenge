import java.util.*;

public class Challenge_20 { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("Enter number of elements:");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("The number of elements should be greater than zero.");
            scanner.close(); // Close the scanner if input is invalid
            return;
        }

        System.out.println("Enter elements into the stack:");
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }

        scanner.close(); // Close the scanner after taking all input

        System.out.println("Original stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted stack: " + stack);
    }

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop(); // Pop the top element
        sortStack(stack); // Recursively sort the remaining stack
        sortedInsert(stack, top); // Insert the popped element back in sorted order
    }

    // Helper function to insert elements in sorted order
    private static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        int top = stack.pop(); // Remove the top element
        sortedInsert(stack, element); // Recursively insert the current element
        stack.push(top); // Push the previously removed element back
    }
}
