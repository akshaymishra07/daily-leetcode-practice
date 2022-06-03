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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = Integer.MAX_VALUE;
        int last = 0;
        int prev = head.val;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; head.next != null; i++){
            
            if(Math.max(prev, head.next.val) < head.val || Math.min(prev, head.next.val) > head.val ){
                if (last != 0)
                min = Math.min(min, i - last);
            
               first = Math.min(first, i);
               last = i;
            }
            
            prev = head.val;
            head = head.next;
        }
        
        if (min == Integer.MAX_VALUE)
          return new int[]{-1, -1};
    
        return new int[]{min, last - first};
        
        
    }
}