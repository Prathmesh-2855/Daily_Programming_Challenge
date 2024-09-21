public class Challenge_13 {

    // Helper function to expand around the center and return the longest palindrome
    public static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the palindrome substring
        return s.substring(left + 1, right);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome (single center)
            String oddPalindrome = expandAroundCenter(s, i, i);
            // Even length palindrome (double center)
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            // Get the longest of the current palindromes
            String currentLongest = oddPalindrome.length() > evenPalindrome.length() ? oddPalindrome : evenPalindrome;

            // Update the longest palindrome if necessary
            if (currentLongest.length() > longest.length()) {
                longest = currentLongest;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(longestPalindrome("babad")); // Output: "bab" or "aba"
        System.out.println(longestPalindrome("cbbd")); // Output: "bb"
        System.out.println(longestPalindrome("a")); // Output: "a"
        System.out.println(longestPalindrome("aaaa")); // Output: "aaaa"
        System.out.println(longestPalindrome("abc")); // Output: "a"
    }
}
