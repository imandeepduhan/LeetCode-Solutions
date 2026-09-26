/*
Problem Name : 3834. Merge Adjacent Equal Elements
Problem Link : https://leetcode.com/problems/merge-adjacent-equal-elements/description/

My Approach: First, I create a stack and push the first element of nums into it.
Then, I start a for loop and check the condition i < nums.length. I create a variable prev 
that stores the current element of nums. If prev != stack.peek(), I push the element into the stack.
Otherwise, I keep removing elements until prev != stack.peek() becomes true.
Then, I create an ArrayList and store all the stack elements in it one by one. Finally, I return the list.

*/

import java.util.ArrayList;
import java.util.Stack;
class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> stack = new Stack<>();
        stack.push((long)nums[0]);
        for(int i = 1; i < nums.length; i++){
            long prev = nums[i];
            while(!stack.isEmpty() && stack.peek() == prev) {
                long sum = prev + prev;
                prev = sum;
                stack.pop();
            } 
            stack.push((long)prev);
        }

        ArrayList<Long> list = new ArrayList<>();
        for(Long x: stack) {
            list.add((long)x);
        }

        return list;
    }

}
