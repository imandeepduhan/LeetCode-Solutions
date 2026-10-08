/*
Problem Name : 260. Single Number III
Problem Link : https://leetcode.com/problems/single-number-iii/description/

My Approach : Fist, I XOR all the elements of the array. Then, I find the rightmost set bit 
and create two variables. After that , I start a for loop and divides the numbers into two groups based on the 
rightmost set bit. If ((num & rightBit) == 0), I XOR the number with a.
Otherwise, I XOR the number with b.
Finally I return an array containing a and b.

*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor = xor ^ num;
        }
        int rightBit = xor & (-xor);
        int a = 0;
        int b = 0;
        for(int num : nums) {
            if((num & rightBit) == 0) {
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }
        return new int[]{a,b};
    }
}
