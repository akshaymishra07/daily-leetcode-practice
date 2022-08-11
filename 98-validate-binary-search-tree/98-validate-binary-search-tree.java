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
    public boolean isValidBST(TreeNode root) {
         Stack<TreeNode> stack = new Stack<TreeNode> ();
		   TreeNode cur = root ;
		   TreeNode pre = null ;		   
		   while (!stack.isEmpty() || cur != null) {			   
			   if (cur != null) {
				   stack.push(cur);
				   cur = cur.left ;
			   } else {				   
				   TreeNode p = stack.pop() ;
				   if (pre != null && p.val <= pre.val) {					   
					   return false ;
				   }				   
				   pre = p ;					   
				   cur = p.right ;
			   }
		   }
		   return true ;  
    }
}