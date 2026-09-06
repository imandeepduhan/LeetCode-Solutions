/*
Problem Name : 19. Remove Nth Node From End of List
Problem Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

My Approach : First, I find the length of the linked list. Then, I check if n == length and return head.next. Otherwise, I calculate i = length - n.I start a while loop and move curr until it reaches the node before the node that needs to be removed.
Then, I remove the node using curr.next = curr.next.next and return head.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode num = head;
        int length = 0;
        while(num != null) {
            length++;
            num = num.next;
        }

        if (n == length) {
            return head.next;
        }   
        ListNode curr = head;
        int i = length - n;
        int count = 0;
        while(count < i - 1) {
            curr = curr.next;
            count++;
        }
        curr.next = curr.next.next;
        return head;
    }
}
