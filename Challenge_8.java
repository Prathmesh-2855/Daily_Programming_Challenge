public class Challenge_8 {

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = n - 1;

        // Step 1: Traverse the string from the end to the beginning
        while (i >= 0) {
            // Skip spaces at the end
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break; // If we have reached the start, break

            int j = i;

            // Find the start of the word
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // Add the word to the result
            if (result.length() > 0) {
                result.append(" "); // Append a space between words
            }
            result.append(s.substring(i + 1, j + 1));
        }

        // Step 2: Return the final reversed string
        return result.toString();
    }

    public static void main(String[] args) {
        // Test case 1
        String input1 = "the sky is blue";
        System.out.println(reverseWords(input1)); // Expected Output: "blue is sky the"

        // Test case 2
        String input2 = "  hello world  ";
        System.out.println(reverseWords(input2)); // Expected Output: "world hello"

        // Test case 3
        String input3 = "a good   example";
        System.out.println(reverseWords(input3)); // Expected Output: "example good a"

        // Test case 4 (all spaces)
        String input4 = "    ";
        System.out.println("\"" + reverseWords(input4) + "\""); // Expected Output: ""

        // Test case 5 (single word)
        String input5 = "word";
        System.out.println(reverseWords(input5)); // Expected Output: "word"
    }
}

