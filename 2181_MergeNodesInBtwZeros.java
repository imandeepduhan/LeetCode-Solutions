/*
Problem Name : 2181. Merge Nodes in Between Zeros
Problem Link : https://leetcode.com/problems/merge-nodes-in-between-zeros/description/

My Approach: First, I create an ans linked list. Then, I set curr to ans and list to head.next. 
Then, I create a variable sum and start a while loop. If list.val == 0, I add sum to the answer list
and reset sum to 0. Otherwise, I add list.val to sum. Finally, I return ans.next.

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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        ListNode list = head.next;
        int sum = 0;
        while(list != null) {
            if(list.val == 0) {
                curr.next = new ListNode(sum);
                curr = curr.next;
                sum = 0;
            } else {
                sum += list.val;
            }

            list = list.next;
        }
        return ans.next;
    }
}
