import java.util.*;

public class QuestionFour {
    public static void main(String[] args) {
        // Input array of strings
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        // Call the groupAnagrams function and store the result
        List<List<String>> grouped = groupAnagrams(strs);
        // Print the grouped anagrams
        System.out.println(grouped);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store groups of anagrams
        // Key: sorted string, Value: list of original strings that are anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String s : strs) {
            // Convert the string to a character array for sorting
            char[] chars = s.toCharArray();

            // Sort the character array
            Arrays.sort(chars);

            // Convert the sorted character array back to a string
            // This sorted string will be the key for anagrams
            String key = new String(chars);

            // If the key is not present in the map, create a new list
            // Add the original string to the list for this key
            // This groups all anagrams together under the same key
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);

            /*
            Iteration-wise explanation for input: {"eat","tea","tan","ate","nat","bat"}

            1st iteration: s = "eat"
                chars = ['e','a','t'] -> sorted = ['a','e','t']
                key = "aet"
                map: {"aet": ["eat"]}

            2nd iteration: s = "tea"
                chars = ['t','e','a'] -> sorted = ['a','e','t']
                key = "aet"
                map: {"aet": ["eat", "tea"]}

            3rd iteration: s = "tan"
                chars = ['t','a','n'] -> sorted = ['a','n','t']
                key = "ant"
                map: {"aet": ["eat", "tea"], "ant": ["tan"]}

            4th iteration: s = "ate"
                chars = ['a','t','e'] -> sorted = ['a','e','t']
                key = "aet"
                map: {"aet": ["eat", "tea", "ate"], "ant": ["tan"]}

            5th iteration: s = "nat"
                chars = ['n','a','t'] -> sorted = ['a','n','t']
                key = "ant"
                map: {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"]}

            6th iteration: s = "bat"
                chars = ['b','a','t'] -> sorted = ['a','b','t']
                key = "abt"
                map: {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"], "abt": ["bat"]}
            */

        }
        // Return all the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}