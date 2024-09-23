import java.util.*;

public class Challenge_15 {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            while (uniqueChars.contains(currentChar)) {
                uniqueChars.remove(s.charAt(left));
                left++;
            }

            uniqueChars.add(currentChar);
            
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Expected Output: 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Expected Output: 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Expected Output: 3
        System.out.println(lengthOfLongestSubstring("abcdefgh")); // Expected Output: 8
        System.out.println(lengthOfLongestSubstring("a"));        // Expected Output: 1
    }
}

