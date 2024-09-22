import java.util.*;

public class Challenge_14 {
    public static int stringWithKDistinct(String str, int k) {
        int count = 0;
        
        // Sliding window approach to track distinct characters
        for (int i = 0; i < str.length(); i++) {
            Set<Character> myset = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                myset.add(str.charAt(j));
                if (myset.size() == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter String:");
        String str = s.next();

        System.out.println("Enter value of K:");
        int k = s.nextInt();

        System.out.println(stringWithKDistinct(str, k));

        s.close(); // Close the scanner to avoid resource leak
    }
}
