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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; //When fast reaches to end slow will reach midway
            fast = fast.next.next;
       }

       ListNode secondHead = slow.next;


        //ListNode secondHead = slow.next;
    slow.next = null; // split the list into two halves
    ListNode prev = null;
    while (secondHead != null) {
        ListNode next = secondHead.next;
        secondHead.next = prev;
        prev = secondHead;
        secondHead = next;
    }
    ListNode second = prev; // head of reversed second half
    ListNode first = head;
    while (second != null) {
        ListNode firstNext = first.next;
        ListNode secondNext = second.next;

        first.next = second;
        second.next = firstNext;

        first = firstNext;
        second = secondNext;
    }
        
    }
}
