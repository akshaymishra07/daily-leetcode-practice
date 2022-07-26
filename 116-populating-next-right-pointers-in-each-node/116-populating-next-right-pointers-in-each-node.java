/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        Node thisLevel = root;
        
        
        while(thisLevel != null){
           
           Node curr  = thisLevel; 
            
           while(curr != null){
            
            if(curr.left != null && curr.right != null){
                curr.left.next = curr.right;
            }
            
            if(curr.right != null && curr.next != null && curr.next.left != null){
                curr.right.next = curr.next.left;
            }
            
            curr = curr.next;
          } 
         
             
          thisLevel = thisLevel.left;  
            
        }
        
        return root;
    }
}