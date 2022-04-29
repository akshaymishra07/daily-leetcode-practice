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
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;
        
        while(count <= n){
            if(fast.next == null){
                return slow.next;
            }
            fast = fast.next;
            count++;
        }
        
        while(fast.next != null){
            slow=slow.next;
            fast = fast.next;
        }
        
        
       
        
        slow.next= slow.next.next;
        
        return head;
    }
}