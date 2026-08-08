/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {\ this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head; ListNode prev = null;
        while(curr != null){//check if current is not null
            ListNode nextTemp = curr.next;//find out the next node
            curr.next = prev;//change next node to point to null
            prev = curr;//make previous node to this node
            curr = nextTemp;//and current node to next Node
        }
        return prev;
    }
}