/*
Problem Name : 2816. Double a Number Represented as a Linked List
Problem Link : https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/

My Approach: First, I create a string str that stores all the values of the linked list. Then, I create a BigInteger and convert str into a BigInteger. Then, I multiply it by 2 and convert it back into a string str. Finally, I add all the values to the linked list ans and return it.

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
import java.math.BigInteger;
class Solution {
    public ListNode doubleIt(ListNode head) {
        StringBuilder str = new StringBuilder();
        ListNode l = head;
        while(l != null) {
            str.append(l.val);
            l = l.next;
        }

        BigInteger num = new BigInteger(str.toString());
        num = num.multiply(BigInteger.TWO);
        str = new StringBuilder(String.valueOf(num));

        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        for(int i = 0; i < str.length(); i++) {
            curr.next = new ListNode(str.charAt(i) - '0');
            curr = curr.next;
        }

        return ans.next;
    }
}
