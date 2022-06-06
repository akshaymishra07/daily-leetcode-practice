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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode first = null;
        ListNode last = null;
        
        while(temp2.next != null){
            temp2 = temp2.next;
        }
        
        while(temp1 != null){
            
            if(temp1.val == a-1){
                first = temp1;
            }
            
            if(temp1.val == b+1){
                last = temp1;
            }
            
            temp1 = temp1.next;
        }
        
        first.next = list2;
        temp2.next = last;
        
        return list1;
    }
}