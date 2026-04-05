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
    public ListNode deleteDuplicates(ListNode head) {
        // easy question
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy; //used to track the duplicates 
        ListNode curr = head;

        while(curr != null && curr.next != null){
            // if duplicate occurs 
            if(curr.val == curr.next.val){
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                // point prev to curr.next
                prev.next = curr.next;
            }
            // if no duplicates 
            else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}