/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode head;
    TreeNode tail;
    
    Pair(TreeNode head, TreeNode tail){
        
        this.head = head;
        this.tail = tail;
    }
}
class Solution {
    
    Pair convertToDLL(TreeNode root){
        
        if(root == null){
            return new Pair(null,null);
        }
        
        Pair lst = convertToDLL(root.left);
        Pair rst  = convertToDLL(root.right);
        
        TreeNode head = root;
        TreeNode tail = root;
        
        root.left = lst.tail;
        
        if(lst.tail != null){
            lst.tail.right = root;
            head = lst.head;
        }
        
        root.right = rst.head;
        
        if(rst.head != null){
            rst.head.left = root;
            tail = rst.tail;
        }
        
        return new Pair(head, tail);
    }
    
    public boolean findTarget(TreeNode root, int k) {
            
        Pair res = convertToDLL(root);
        
        TreeNode p1 = res.head;
        TreeNode p2 = res.tail;
        
        while(p1.val < p2.val){
            
            int sum = p1.val + p2.val;
            
            if(sum == k){
                return true;
            }else if(sum > k){
                p2 = p2.left;
            }else
                p1 = p1.right;
            
        }
        
        return false;
        
    }
}