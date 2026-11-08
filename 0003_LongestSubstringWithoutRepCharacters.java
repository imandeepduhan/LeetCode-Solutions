/*
Problem Name : 3. Longest Substring Without Repeating Characters
Problem Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

My Approach : First, I create an array named check of size 128. Then, I create two variables ans and max.
Next, I fill the check with -1. After that, I run a for loop to check each character in the string.
If the character is not present in the array, I store its index and increase ans by 1.
If the character is already present, I reset ans and check the previous indexes in the array.
I reset the indexes that are before the duplicates character and count the remaining valid characters.
Finally, I update the max and return it as the answer.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] check = new int[128];
        int ans = 0;
        int max = 0;
        for(int i = 0; i < check.length; i++) check[i] = -1;

        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i);
            if(check[num] == -1) {
                check[num] = i;
                ans++;
            } else {
                ans = 0;
                int idx = check[num];
                check[num] = -1;
                for(int j = 0; j < 128; j++) {
                    if(check[j] < idx && check[j] != -1) {
                        check[j] = -1;
                    } else if (check[j] > idx) {
                        ans++;
                    }
                }
                ans++;
                check[num] = i;
            }

            max = Math.max(max, ans);
        }

        return max;
    }
}
