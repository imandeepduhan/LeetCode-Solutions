/*
Problem Name : 4031. Find All Numbers Disappeared in an Array II
Problem Link : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array-ii/description/

My Approach : First, I create an array of size 100002 and mark the elements that are present in nums.
Then, I traverse from lower to upper and group the missing consecutive numbers into ranges.

*/
class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        int[] arr = new int[100002];
        arr[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]] = 1;
        }

        List<List<Integer>> list = new ArrayList<>();
        
        int idx = lower;
        while(idx <= upper) {

            if(arr[idx] == 1) {
                idx++;
                continue;
            }

            int st = idx;

            while(idx <= upper && arr[idx] == 0) {
                idx++;
            }

            int end = idx - 1;        
            list.add(Arrays.asList(st, end));
        }
        return list;
    }
}
