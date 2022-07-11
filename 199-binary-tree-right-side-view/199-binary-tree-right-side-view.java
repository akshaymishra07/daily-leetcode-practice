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
     
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> li = new ArrayList<>();
        
        if(root == null) return li;
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int n = q.size();
            
            while(n-- > 0){
                
                TreeNode curr = q.poll();
                
                if(n+1 == 1){
                    li.add(curr.val);
                }
                
                if(curr.left != null){
                    
                    q.add(curr.left);
                }
                
                if(curr.right != null){
                    
                    q.add(curr.right);
                }
                
            }
            
        }
        
        return li;
    }
}