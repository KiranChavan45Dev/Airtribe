public class QuestionTen {
    public static void main(String[] args) {
        // Example 1
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Example 1:");
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + isPalindrome(s1));
        System.out.println("Explanation: \"amanaplanacanalpanama\" is a palindrome.\n");

        // Example 2
        String s2 = "race a car";
        System.out.println("Example 2:");
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + isPalindrome(s2));
        System.out.println("Explanation: \"raceacar\" is not a palindrome.\n");

        // Example 3
        String s3 = " ";
        System.out.println("Example 3:");
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + isPalindrome(s3));
        System.out.println("Explanation: After removing non-alphanumeric characters, string is empty \"\" which is a palindrome.\n");
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (s == null || s.length() == 0 || s.length() == 1) {
            // Iteration-wise explanation:
            // If the string is null, empty, or has only one character, it's a palindrome by definition.
            return true;
        }

        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                // Iteration-wise explanation:
                // Move left pointer forward if current character is not alphanumeric.
            }
            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                // Iteration-wise explanation:
                // Move right pointer backward if current character is not alphanumeric.
            }

            // Compare characters in a case-insensitive manner
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                // Iteration-wise explanation:
                // If the characters at left and right pointers don't match, it's not a palindrome.
                return false;
            }
            // Iteration-wise explanation:
            // If the characters match, move both pointers towards the center for next comparison.
            left++;
            right--;
        }
        // Iteration-wise explanation:
        // If all character comparisons passed, the string is a palindrome.
        return true;
    }
}
