import java.util.*;

public class Challenge_20 { 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("Enter number of elements:");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Number of elements should be greater than zero.");
            return;
        }
        
        System.out.println("Enter elements into the stack:");
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }

        System.out.println("Original stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted stack: " + stack);
        
        scanner.close(); // Close scanner to prevent resource leaks
    }

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively sort the rest of the stack
        sortStack(stack);

        // Insert the popped element back into the sorted stack
        sortedInsert(stack, top);
    }

    // Helper function to insert elements in sorted order
    private static void sortedInsert(Stack<Integer> stack, int element) {
        // Base case: Insert the element if the stack is empty or if it's greater than the top
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        // Otherwise, remove the top element
        int top = stack.pop();

        // Recursively insert the element in the sorted stack
        sortedInsert(stack, element);

        // Push the top element back onto the stack
        stack.push(top);
    }
}
