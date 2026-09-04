/*
Problem Name : 141. Linked List Cycle
Problem Link : https://leetcode.com/problems/linked-list-cycle/description/

My Approach : First, I create two pointers first and second point to head node. Then, I start a while loop and first moves one step and second moves two steps at a time. When first == second, I return true. Otherwise, I return false.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;

            if(first == second) {
                return true;
            }
        }
        return false;
    }
}
