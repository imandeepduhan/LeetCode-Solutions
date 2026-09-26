/*
Problem Name : 57. Insert Interval
Problem Link : https://leetcode.com/problems/insert-interval/description/

My Approach : First, I create a 2D array and add all the interval pairs and the newInterval in arr. 
Then, I sort the array by the first element.Then, I create a 2D array ans and start a for loop to compare 
the elements one by one. And finally, I return the ans.

*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] arr = new int[intervals.length + 1][2];

        for (int i = 0; i < intervals.length; i++) {
            arr[i] = intervals[i];
        }

        arr[intervals.length] = newInterval;

        Arrays.sort(arr, (a, b)-> a[0] - b[0]);
        
        int size = intervals.length + 1;
        int idx = 0;
        int[][] ans = new int[size][2];

        ans[idx][0] = arr[0][0];
        ans[idx][1] = arr[0][1];

        for(int i  = 1; i < arr.length; i++) {
            int ans1 = ans[idx][0];
            int ans2 = ans[idx][1];

            int curr1 = arr[i][0];
            int curr2 = arr[i][1];

            if(ans2 >= curr1) {
                ans[idx][1] = Math.max(ans2, curr2);
            } else {
                idx++;
                ans[idx][0] = curr1;
                ans[idx][1] = curr2;
            }
            
        }

        return Arrays.copyOf(ans, idx + 1);
        
    }
}
