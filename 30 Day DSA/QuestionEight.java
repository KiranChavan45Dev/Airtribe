import java.util.Deque;
import java.util.LinkedList;

public class QuestionEight {
    public static void main(String[] args) {
        /*
         * Problem:
         * You are given an array of integers nums, and a sliding window of size k
         * which moves from the very left of the array to the very right.
         * You can only see the k numbers in the window.
         * Each time the sliding window moves right by one position.
         * Return the max sliding window.
         *
         * Example:
         * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
         * Output: [3,3,5,5,6,7]
         */

        // Test Case 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println("Test Case 1:");
        int[] result1 = maxSlidingWindow(nums1, k1);
        printArray(result1); // Expected: [3, 3, 5, 5, 6, 7]

        // Test Case 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Test Case 2:");
        int[] result2 = maxSlidingWindow(nums2, k2);
        printArray(result2); // Expected: [1]

        // Test Case 3
        int[] nums3 = {9, 11};
        int k3 = 2;
        System.out.println("Test Case 3:");
        int[] result3 = maxSlidingWindow(nums3, k3);
        printArray(result3); // Expected: [11]

        // Test Case 4
        int[] nums4 = {4, -2};
        int k4 = 2;
        System.out.println("Test Case 4:");
        int[] result4 = maxSlidingWindow(nums4, k4);
        printArray(result4); // Expected: [4]

        /*
         * Iteration-wise explanation for input nums = [1,3,-1,-3,5,3,6,7], k = 3
         * 
         * Initial nums array: [1, 3, -1, -3, 5, 3, 6, 7]
         * 
         * i = 0, window = [1], max = 1
         * i = 1, window = [1,3], max = 3
         * i = 2, window = [1,3,-1] → remove 1 (not max), max = 3
         * i = 3, window = [3,-1,-3] → remove -1, -3 < 3, max = 3
         * i = 4, window = [-1,-3,5] → remove all smaller than 5 → max = 5
         * i = 5, window = [-3,5,3] → max = 5
         * i = 6, window = [5,3,6] → remove 3, 5 < 6 → max = 6
         * i = 7, window = [3,6,7] → remove 6, max = 7
         */
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements outside the window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements smaller than current
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i); // Add current index

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
