/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    static void traverse(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> pathOfP, List<TreeNode> pathOfQ , List<TreeNode> temp ){
        
        
        if(root == null){
            return;
        }
        
        temp.add(root);
        
        if(root.val == p.val){
            
            for(TreeNode num : temp){
                pathOfP.add(num);
            }
            
        }
        
        if(root.val == q.val){
            
            for(TreeNode num : temp){
                pathOfQ.add(num);
            }
            
        }
        
        traverse(root.left,p,q,pathOfP, pathOfQ,temp);
        traverse(root.right,p,q,pathOfP, pathOfQ,temp);
        
        temp.remove(temp.size() - 1);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathOfP = new ArrayList<>();
        List<TreeNode> pathOfQ = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        
        
        traverse(root,p,q,pathOfP, pathOfQ,temp);
        
        int i = 0;
        
        while(i < pathOfP.size() && i < pathOfQ.size()){
            
            if(pathOfP.get(i) != pathOfQ.get(i)){
                break;
            }
            i++;
        }    
    
        return pathOfP.get(i-1);
    }
}