/*
Problem Name : 347. Top K Frequent Elements
Problem Link : https://leetcode.com/problems/top-k-frequent-elements/description/

My Approach : First, I store the elements in a HashMap as key-value pairs. When duplicate elements are present, I increase their value by 1. Then, I store the key-value pairs in a list and sort the list in descending order based on the values. Finally, I store the top k elements in the ans array and return the ans array.

*/

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(map.entrySet());

         list.sort(
            Map.Entry.<Integer, Integer>comparingByValue().reversed()
        );

        int[] ans = new int[k];

        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int key = entry.getKey();
            ans[idx] = key;
            idx++;
            if(idx == k) {
                break;
            }
        }
        
        return ans;
    }
    
}
