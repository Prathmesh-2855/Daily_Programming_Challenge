import java.util.*;

public class Challenge_11 {
    
    public static List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        
        // Handle empty string case
        if (s == null || s.length() == 0) {
            return result;
        }
        
        // Convert the string to a character array and sort it to handle duplicates
        char[] chars = s.toCharArray();
        Arrays.sort(chars);  // Sorting helps in easily skipping duplicates
        boolean[] used = new boolean[chars.length];
        StringBuilder current = new StringBuilder();
        
        // Backtracking function to generate permutations
        backtrack(chars, used, current, result);
        
        return result;
    }

    private static void backtrack(char[] chars, boolean[] used, StringBuilder current, List<String> result) {
        // If the current permutation is of the correct length, add it to the result
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }
        
        for (int i = 0; i < chars.length; i++) {
            // Skip if the character is already used or it's a duplicate of the previous one
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            
            // Mark the character as used
            used[i] = true;
            current.append(chars[i]);
            
            // Recursively build the permutation
            backtrack(chars, used, current, result);
            
            // Undo the choice (backtrack)
            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        // Test case 1: Input: "abc"
        String input1 = "abc";
        System.out.println(permuteUnique(input1));
        // Expected Output: ["abc", "acb", "bac", "bca", "cab", "cba"]

        // Test case 2: Input: "aab"
        String input2 = "aab";
        System.out.println(permuteUnique(input2));
        // Expected Output: ["aab", "aba", "baa"]

        // Test case 3: Input: "aaa"
        String input3 = "aaa";
        System.out.println(permuteUnique(input3));
        // Expected Output: ["aaa"]

        // Test case 4: Input: "a"
        String input4 = "a";
        System.out.println(permuteUnique(input4));
        // Expected Output: ["a"]

        // Test case 5: Input: "abcd"
        String input5 = "abcd";
        System.out.println(permuteUnique(input5));
        // Expected Output: Permutations of "abcd", like ["abcd", "abdc", "acbd", ..., "dcba"]
    }
}

