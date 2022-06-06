/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    int length(ListNode li){
        
        int count = 0;
        
        ListNode temp = li;
        
        while(temp != null){
            
            count++;
            temp = temp.next;
            
        }
        
        return count;
        
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = length(headA);
        int lenB = length(headB);
        
        int d = Math.abs(lenA - lenB);
        
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        if(lenA > lenB){
            
           while(d-- > 0){
               temp1 = temp1.next;
           }
            
        }else{
            while(d-- > 0){
               temp2 = temp2.next;
           }
        }
        
        
        while(temp1 != null && temp2 != null){
            
            if(temp1 == temp2){
                return temp1;
            }
            
            temp1 = temp1.next;
            temp2 = temp2.next;
            
        }
        
        
        
        return null;
        
    }
}