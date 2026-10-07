/*
Problem Name : 3746. Minimum String Length After Balanced Removals.
Problem Link : https://leetcode.com/problems/minimum-string-length-after-balanced-removals/description/

My Approach : First, I count the number of a and b in the string.
Then I return the absolute difference between both counts because equal numbers of a and b can be removed.

*/

class Solution {
    public int minLengthAfterRemovals(String s) {
        int countA = 0;
        int countB = countA;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') countA++;
            else countB++;
        }
        return Math.abs(countA - countB);
    }
}
