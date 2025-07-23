import java.util.HashSet;

public class QuestionSix {
    public static void main(String[] args) {
        // Test Case 1: nums = [1, 2, 3, 1]
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test Case 1: " + containsDuplicate(nums1)); // Expected Output: true

        // Test Case 2: nums = [1, 2, 3, 4]
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test Case 2: " + containsDuplicate(nums2)); // Expected Output: false

        // Test Case 3: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Test Case 3: " + containsDuplicate(nums3)); // Expected Output: true
    }

    // Function to check if the array contains any duplicates
    public static boolean containsDuplicate(int[] nums) {
        // Initialize a HashSet to keep track of elements we have seen so far
        HashSet<Integer> container = new HashSet<>();

        // Iterate through the array and check if an element is already in the HashSet
        for (int i : nums) {
            // If the element is already present in the set, return true (duplicate found)
            if (container.contains(i)) {
                return true;
            }
            // If not, add the element to the set
            container.add(i);
        }

        // If we complete the loop without finding any duplicates, return false
        return false;
        
        /*
        Iteration-wise for input: [1, 2, 3, 1]
        
        Initial container: {}
        
        1st iteration:
        Current element: 1
        Container before check: {}
        1 is not in the container, so we add it
        Container after add: {1}

        2nd iteration:
        Current element: 2
        Container before check: {1}
        2 is not in the container, so we add it
        Container after add: {1, 2}

        3rd iteration:
        Current element: 3
        Container before check: {1, 2}
        3 is not in the container, so we add it
        Container after add: {1, 2, 3}

        4th iteration:
        Current element: 1
        Container before check: {1, 2, 3}
        1 is already in the container, so we return true

        Final result: true (because 1 is duplicated)
        */
    }
}
