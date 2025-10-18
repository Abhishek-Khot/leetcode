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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int one = (l1!= null)? l1.val : 0;
            int two = (l2!= null)?l2.val :0;
            int sum = one + two + carry;
            int lastDigit = sum % 10;
            carry = sum /10;

            ListNode newNode = new ListNode(lastDigit);

            temp.next = newNode;

            if(l1 != null)l1 = l1.next;
            if(l2 != null)l2 = l2.next;
            
            temp = temp.next;
        }
        temp.next = null;
        return dummy.next;
    }
}