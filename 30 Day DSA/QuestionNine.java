import java.util.ArrayList;
import java.util.List;

public class QuestionNine {
    public static void main(String[] args){
        // Example 1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s1 + "\", p = \"" + p1 + "\"");
        System.out.println("Output: " + findAnagrams(s1, p1));
        

        // Example 2
        String s2 = "abab";
        String p2 = "ab";
        System.out.println("Example 2:");
        System.out.println("Input: s = \"" + s2 + "\", p = \"" + p2 + "\"");
        System.out.println("Output: " + findAnagrams(s2, p2));
        
    } 
    public static List<Integer> findAnagrams(String s, String p) {
        /*
         * Problem:
         * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
         * You may return the answer in any order.
         *
         * Example:
         * Input: s = "cbaebabacd", p = "abc"
         * Output: [0, 6]
         * Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc".
         * The substring with start index = 6 is "bac", which is an anagram of "abc".
         */

        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (pLen > sLen) return result;

        int[] pCount = new int[26]; // character counts for p
        int[] windowCount = new int[26]; // character counts for current window in s

        // Count characters in p and the first window of s
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
            // Iteration-wise explanation:
            // For each character in p and the first pLen characters in s,
            // increment their respective counts in pCount and windowCount arrays.
            // This sets up the initial comparison window.
        }

        // Compare initial window
        if (matches(pCount, windowCount)) {
            // If the first window matches the character count of p,
            // it means the substring is an anagram of p.
            result.add(0);
        }

        // Slide the window over the string s
        for (int i = pLen; i < sLen; i++) {
            int checkOne = s.charAt(i) - 'a'; // new character entering the window
            int checkTwo = s.charAt(i - pLen) - 'a'; // old character leaving the window
            windowCount[checkOne]++; // Add new char to window count
            windowCount[checkTwo]--; // Remove old char from window count

            // Iteration-wise explanation:
            // For each step, move the window one character forward:
            // - Increment the count for the new character entering the window.
            // - Decrement the count for the character leaving the window.
            // - Compare the updated windowCount with pCount to check for an anagram.

            if (matches(pCount, windowCount)) {
                // If the current window matches pCount, record the starting index.
                result.add(i - pLen + 1);
            }
        }

        // Return the list of starting indices where anagrams of p are found in s
        return result;
    }

    public static String printArray(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static boolean matches(int[] a, int[] b) {
        // Compare two character count arrays for equality
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
