import java.util.Stack;

public class Challenge_12 {
    public boolean isValid(String s) {
        // Edge case: if the string length is odd, it can't be valid
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Challenge_12 solution = new Challenge_12();
        
        // Test cases
        System.out.println(solution.isValid("()")); // true
        System.out.println(solution.isValid("([)]")); // false
        System.out.println(solution.isValid("[{()}]")); // true
        System.out.println(solution.isValid("")); // true
        System.out.println(solution.isValid("{[}")); // false
    }
}