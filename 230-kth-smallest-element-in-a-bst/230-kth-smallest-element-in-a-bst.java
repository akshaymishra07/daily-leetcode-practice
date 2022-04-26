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
class Solution {

     static TreeNode curr = null;
    static int count = 0;
    static void traverse(TreeNode root, int k){
        if(root == null){
            return;
        }

        traverse(root.left , k);

        
        count++;
        if(count == k) curr = root ;

        traverse(root.right, k); 

    } 
    
    public int kthSmallest(TreeNode root, int k) {
        curr = null;
       count = 0;
       traverse(root, k);

       return curr.val;
    }
}