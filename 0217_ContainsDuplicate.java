/*
Problem Name : 217 Contains Duplicate
Problem Link : https://leetcode.com/problems/contains-duplicate/description/

My Approach : I use a HashSet to remove duplicate elements. Finally, I check if nums.length == set.size(). 
If they are equal, there are no duplicates, so I return false. Otherwise, I return true.

*/

import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size() == nums.length) {
            return false;
        } 

        return true;
    }
}
