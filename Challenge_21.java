import java.util.*;

public class Challenge_21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter number of elements:");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("The number of elements should be greater than zero.");
            scanner.close(); // Close the scanner before exiting
            return;
        }

        System.out.println("Enter elements into the stack:");
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }

        scanner.close(); // Close the scanner after taking all input

        System.out.println("Original stack: " + stack);
        
        // Sorting the stack in decreasing order
        sortStack(stack);

        System.out.println("Sorted stack (decreasing order): " + stack);
    }

    // Recursive function to sort the stack in decreasing order
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the popped element back in sorted order
        sortedInsert(stack, top);
    }

    // Helper function to insert an element in decreasing order in the sorted stack
    private static void sortedInsert(Stack<Integer> stack, int element) {
        // Insert the element if stack is empty or if the element is smaller or equal to the top
        if (stack.isEmpty() || element <= stack.peek()) {
            stack.push(element);
            return;
        }

        // Otherwise, pop the top element and recursively insert the current element
        int top = stack.pop();
        sortedInsert(stack, element);

        // Push the popped element back
        stack.push(top);
    }
}
