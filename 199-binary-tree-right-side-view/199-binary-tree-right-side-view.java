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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int n = q.size();
            
            TreeNode temp = q.poll();
            res.add(temp.val);
            if(temp.right != null) q.add(temp.right);
            if(temp.left != null) q.add(temp.left);
            n--;
            
            while(n-- > 0){
                temp = q.poll();
                if(temp.right != null) q.add(temp.right);
                if(temp.left != null) q.add(temp.left);
                
            }
            
        }
        
        return res;
    }
}