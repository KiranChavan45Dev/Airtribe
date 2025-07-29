import java.util.Stack;

public class QuestionTwelv {
    
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i : asteroids){
            // Iteration-wise explanation:
            // For each asteroid, check for possible collisions with the top of the stack.
            while(!stack.isEmpty() && i < 0 && stack.peek() > 0){
                int top = stack.peek();

                // If the incoming asteroid is smaller, it gets destroyed.
                if(Math.abs(i) < Math.abs(top)){
                    i = 0; // Current asteroid destroyed, stop further collision checks.
                    // Explanation: The top asteroid survives, current asteroid is gone.
                }else if (Math.abs(i) == Math.abs(top)){
                    stack.pop(); // Both asteroids destroy each other.
                    i = 0; // Current asteroid also destroyed.
                    // Explanation: Both asteroids are equal in size, both are destroyed.
                }else{
                    stack.pop(); // Top asteroid destroyed, continue checking for more collisions.
                    // Explanation: Current asteroid is larger, top asteroid is destroyed, check next.
                }
            }

            // If current asteroid survived all collisions, push it to the stack.
            if(i != 0){
                stack.push(i);
                // Explanation: Asteroid added to stack as it did not collide or survived all collisions.
            }
        }

        // Prepare result array from stack
        int[] result = new int[stack.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = stack.get(i);
            // Explanation: Copy each surviving asteroid from stack to result array.
        }

        return result;
    }

    public static void main(String[] args) {
        QuestionTwelv qt = new QuestionTwelv();
        
        // Example 1
        int[] asteroids1 = {5, 10, -5};
        System.out.println("Example 1: " + java.util.Arrays.toString(qt.asteroidCollision(asteroids1)));
        
        // Example 2
        int[] asteroids2 = {8, -8};
        System.out.println("Example 2: " + java.util.Arrays.toString(qt.asteroidCollision(asteroids2)));
        
        // Example 3
        int[] asteroids3 = {10, 2, -5};
        System.out.println("Example 3: " + java.util.Arrays.toString(qt.asteroidCollision(asteroids3)));
    }
}
