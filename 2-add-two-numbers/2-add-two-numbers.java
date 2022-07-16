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
        
        if(l1.next == null && l2.next == null){
            int curr = l1.val + l2.val;
            if(curr > 9){
                ListNode temp = new ListNode(curr%10);
                temp.next = new ListNode(curr/10);
                
                return temp;
            }
            return new ListNode(l1.val + l2.val);
        }
        
        
        int carry = 0;
        ListNode ans = null;
        ListNode it = null;
        while(l1 != null && l2 != null){
            
            int curr = l1.val + l2.val+carry;
            ListNode temp = new ListNode(curr%10);
            carry = curr / 10;            
            
            if(ans == null){
                ans = temp;
                it = temp; 
            }
            
            it.next = temp;
            it = it.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            
            int curr = l1.val+carry;
            ListNode temp = new ListNode(curr%10);
            carry = curr / 10;             
            
            it.next = temp;
            it = it.next;
            
            l1 = l1.next;
        }
        
         while(l2 != null){
            
            int curr = l2.val+carry;
            ListNode temp = new ListNode(curr%10);
            carry = curr / 10;             
            
            it.next = temp;
            it = it.next;
             
            l2 = l2.next;
        }
        
        if(carry != 0){
            it.next = new ListNode(carry);
        }
        
        return ans;
    }
}