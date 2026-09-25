/*
Problem Name : 215. Kth Largest Element in an Array
Problem Link : https://leetcode.com/problems/kth-largest-element-in-an-array/description/

My Approach : First, I create a PriorityQueue and add all the elements from index 0 to k - 1. 
Then, I start a loop with i = k and check if the smallest element in the heap is smaller than the current element. 
If it is, I remove the smallest element and add the current element to the heap. Finally, I return the kth largest element.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }

        return heap.peek();
    }
}
