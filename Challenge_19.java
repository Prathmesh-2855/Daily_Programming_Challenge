import java.util.*;

public class Challenge_19 {

    // Function to evaluate postfix expressions
    public static int evaluate(String s) {
        String[] tokens = s.split("\\s+");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Check if the token is an operator
            if (isOperator(token)) {
                int ele2 = stack.pop();
                int ele1 = stack.pop();

                // Apply the operation and push the result back onto the stack
                stack.push(applyOperation(token, ele1, ele2));
            } else {
                // Token is a number, push it to the stack
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    // Helper function to check if a string is an operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }

    // Helper function to apply the operation
    private static int applyOperation(String operator, int ele1, int ele2) {
        switch (operator) {
            case "+":
                return ele1 + ele2;
            case "-":
                return ele1 - ele2;
            case "*":
                return ele1 * ele2;
            case "/":
                if (ele2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return ele1 / ele2;
            case "^":
                return (int) Math.pow(ele1, ele2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression (separated by spaces):");
        String str = scanner.nextLine();
        try {
            System.out.println("Result: " + evaluate(str));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner to avoid resource leak
        }
    }
}
