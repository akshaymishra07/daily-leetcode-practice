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
    public boolean isPalindrome(ListNode head) {
        
        
        Stack<Integer> st = new Stack<>();
        
        ListNode temp1 = head;
        ListNode temp2 = head;
        
        
        while(temp2!=null && temp2.next != null){
            
            st.push(temp1.val);
            
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        
        
        if(temp2 != null){
            temp1 = temp1.next;
        }
        
        while(!st.isEmpty()){
            
            if(st.pop() != temp1.val){
                return false;
            }
            
            temp1 = temp1.next;
        }
        
        return true;
    }
    
    
}