/*
Problem Name : 23. Merge k Sorted Lists
Problem Link : https://leetcode.com/problems/merge-k-sorted-lists/description/

My Approach: First, I create two arrays, negative and positive.
Then, I start a for loop and store the negative elements in the negative array.
The positive elements in the positive array. 
Then, I create a new linked list and traverse the negative array backward and add the elements to the linked list. 
Then, I traverse the positive array and add the elements to the linked list. Finally, I return the linked list.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int[] negative = new int[10001];
        int[] positive = new int[10001];

         for(int i = 0; i < lists.length; i++) {

            ListNode node = lists[i];

            while(node != null) {

                int x = node.val;

                if(x < 0) {
                    negative[-x]++;
                } else {
                    positive[x]++;
                }

                node = node.next;
            }
        }

        ListNode ans = new ListNode(0);
        ListNode curr = ans;

        for(int i = negative.length - 1; i >= 0; i--) {
            while(negative[i] > 0) {
                curr.next = new ListNode(-i);
                curr = curr.next;
                negative[i]--;
            }
        }

        for(int i = 0; i < positive.length; i++) {
            while(positive[i] > 0) {
                curr.next = new ListNode(i);
                curr = curr.next;
                positive[i]--;
            }
        }

        return ans.next;
    }
}
