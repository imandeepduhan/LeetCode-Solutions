/*
Problem Name : 2095. Delete the Middle Node of a Linked List
Problem Link : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

My Approach: First, I create slow, fast, and slowBack pointers pointing to head. 
Then, I check if head.next == null; if it is, I return null. Otherwise, 
I start a while loop where slowBack points to the previous node of slow, slow moves one step,
and fast moves two steps. Finally, I delete the middle node by setting slowBack.next = slow.next and return head.

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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowBack = head;
        boolean ok = true;

        if(head.next == null) {
            return null;
        }

        while(fast != null && fast.next != null) {
            slowBack = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        slowBack.next = slow.next;
        return head;
    }
}
