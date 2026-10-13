/*
Problem Name : 3727. Maximum Alternating Sum of Squares
Problem Link : https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/

My Approach : First, I create an array of the same size as nums. Then, I calculate the squares of each element and store it in the new array.
After that, I sort the array. Next, I create three variables : back = arr.length - 1, front = 0 and ans = 0.
Then, I start a while loop that runs as long as front < back. Inside the loop, I add arr[back] - arr[front] to ans, then increment
front and decrement back. Finally if front == back, I add arr[front] to ans. Then, I return ans.

*/

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] arr = new long[nums.length];
         for (int i = 0; i < nums.length; i++) {
            arr[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(arr);
        int back = arr.length - 1;
        int front = 0;
        long ans = 0;

        while(front < back) {            
            ans += arr[back] - arr[front];
            front++;
            back--;
        }

        if(front == back) {
            ans += arr[front];
        }

        return ans;
    }
}
