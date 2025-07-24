public class QuestionSeven {
    public static void main(String[] args) {
        // Test Case 1: nums = [0, 1, 0, 3, 12]
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("Test Case 1: ");
        moveZeroes(nums1);
        printArray(nums1); // Expected Output: [1, 3, 12, 0, 0]
        
        // Test Case 2: nums = [0]
        int[] nums2 = {0};
        System.out.println("Test Case 2: ");
        moveZeroes(nums2);
        printArray(nums2); // Expected Output: [0]
        
        // Test Case 3: nums = [1, 2, 3]
        int[] nums3 = {1, 2, 3};
        System.out.println("Test Case 3: ");
        moveZeroes(nums3);
        printArray(nums3); // Expected Output: [1, 2, 3]
        
        // Test Case 4: nums = [0, 0, 0]
        int[] nums4 = {0, 0, 0};
        System.out.println("Test Case 4: ");
        moveZeroes(nums4);
        printArray(nums4); // Expected Output: [0, 0, 0]
    }

    // Function to move all zeros to the end of the array
    public static void moveZeroes(int[] nums) {
        if (nums != null) {
            int lastIndex = 0; // Pointer for the last non-zero element
            for (int i = 0; i < nums.length; i++) {
                // If the current element is non-zero, swap it with the element at lastIndex
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[lastIndex];
                    nums[lastIndex] = temp;
                    lastIndex++; // Move the pointer to the next position
                }
            }
        }

        /*
        Iteration-wise simulation for input: [0, 1, 0, 3, 12]
        
        Initial nums array: [0, 1, 0, 3, 12]
        lastIndex starts at 0
        
        1st iteration (i = 0):
        Current element: 0
        Since it's zero, we do nothing and move to the next element
        
        2nd iteration (i = 1):
        Current element: 1
        Swap nums[1] and nums[lastIndex] (nums[1] and nums[0])
        nums after swap: [1, 0, 0, 3, 12]
        lastIndex is incremented to 1
        
        3rd iteration (i = 2):
        Current element: 0
        Since it's zero, we do nothing and move to the next element
        
        4th iteration (i = 3):
        Current element: 3
        Swap nums[3] and nums[lastIndex] (nums[3] and nums[1])
        nums after swap: [1, 3, 0, 0, 12]
        lastIndex is incremented to 2
        
        5th iteration (i = 4):
        Current element: 12
        Swap nums[4] and nums[lastIndex] (nums[4] and nums[2])
        nums after swap: [1, 3, 12, 0, 0]
        lastIndex is incremented to 3
        
        Final nums array after moving zeros: [1, 3, 12, 0, 0]
        */
    }

    // Helper function to print the array
    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
