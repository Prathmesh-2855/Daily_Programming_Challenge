import java.util.*;

public class Challenge_10 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Create a frequency array for 26 lowercase letters
            int[] charCount = new int[26];
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;  // Increment the count of each character
            }

            // Convert the frequency array into a string to use as a key
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append(count).append("#");
            }
            String key = keyBuilder.toString();

            // Add the original string to the corresponding anagram group
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        // Test case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        // Expected Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

        // Test case 2
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        // Expected Output: [[""]]

        // Test case 3
        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
        // Expected Output: [["a"]]
    }
}

