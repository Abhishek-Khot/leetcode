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
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        while(head != null){
            map.put(head.val,map.getOrDefault(head.val,0)+1);
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getValue();
            if(num != 1){
                continue;
            }
            ListNode curr = new ListNode(entry.getKey());
            dummy.next = curr;
            dummy = dummy.next;
        }
        
        return newHead.next;
    }
}