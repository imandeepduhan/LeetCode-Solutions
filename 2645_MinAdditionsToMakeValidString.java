/*
Problem Name : 2645. Minimum Additions to Make Valid String
Problem Link : https://leetcode.com/problems/minimum-additions-to-make-valid-string/description/

My Approach : I used a Stack to track the current abc sequence. I checked the curr and prev characters to find missing
characters and added them to the answer. When one abc group was complete, I cleared the stack and started a new group.

*/

class Solution {
    public int addMinimum(String word) {
        if(word.length() == 1) {
            return 2;
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push((int) word.charAt(0));
        // a = 97, b = 98 , c = 99
        for(int i = 1; i < word.length(); i++) {
            int curr = (int) word.charAt(i);

            if(stack.isEmpty()) {
                stack.push(curr);
                continue;
            } else if (stack.peek() == curr) {
                ans += 2;
            } else if(stack.peek() == curr - 1) {
                if(curr == 99 && stack.size() == 3) {
                    stack.clear();
                } else {
                    stack.push(curr);
                }
            } else if(stack.peek() == curr - 2) {
                stack.pop();
                ans += 1;
            } else if (stack.peek() > curr) {
                ans = ans + (3 - stack.size());
                stack.clear();
                stack.push(curr);
            }
        }

        if(!stack.isEmpty()) {
            return ans + (3 - stack.size());
        }
        return ans;
    }
}
