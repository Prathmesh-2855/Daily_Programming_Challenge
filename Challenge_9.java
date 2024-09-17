public class Challenge_9 {
    public static String longestCommonPrefix(String[] strs) {
        // Edge case: If the array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take the first string as a reference for comparison
        String prefix = strs[0];
        
        // Early exit if the first string is empty
        if (prefix.isEmpty()) {
            return "";
        }

        // Loop through all strings in the array
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the start of the current string
            while (!strs[i].startsWith(prefix)) {
                // Shorten the prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }

    public static void main(String[] args) {
        // Test case 1
        String[] input1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(input1)); // Expected Output: "fl"

        // Test case 2
        String[] input2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(input2)); // Expected Output: ""

        // Test case 3
        String[] input3 = {"apple", "ape", "april"};
        System.out.println(longestCommonPrefix(input3)); // Expected Output: "ap"

        // Test case 4 (empty string)
        String[] input4 = {""};
        System.out.println(longestCommonPrefix(input4)); // Expected Output: ""

        // Test case 5 (single string)
        String[] input5 = {"alone"};
        System.out.println(longestCommonPrefix(input5)); // Expected Output: "alone"
    }
}
