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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right)return head;
        ListNode dummy = new ListNode(0,head);
     ListNode before_left = dummy;
     
        for(int i = 1;i < left;i++){
            before_left = before_left.next;
        }
        ListNode after_right = before_left.next;
        for(int i = left;i<=right;i++){
            after_right = after_right.next;
        }
     reverse(before_left,after_right);
     return dummy.next;
    }
    private void reverse (ListNode start,ListNode end){
        ListNode prev = end;
        ListNode cur = start.next;
        while(cur != end){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        start.next = prev;
    }
}