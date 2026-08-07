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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        int i = 0;
        ListNode beforeStart = dummy;
        ListNode afterEnd = beforeStart;
        while(cur != null){
            if(i == k){
                afterEnd = cur.next;
                cur = reverse(beforeStart,afterEnd);
                beforeStart = cur;
                i=0;
            }else{
                i++;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode start, ListNode end){
        ListNode prev = end;
        ListNode cur = start.next;
        ListNode send = cur;
        while(cur !=end){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        start.next = prev;
        return send;
    }
}
