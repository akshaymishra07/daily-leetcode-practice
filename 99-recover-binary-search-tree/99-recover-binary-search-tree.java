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
    
    static void traverse(TreeNode root, List<TreeNode> inorder){
        
        if(root == null){
            return;
        }
        
        traverse(root.left, inorder);
        
        inorder.add(root);
        
        traverse(root.right, inorder);
        
    }
    
    public void recoverTree(TreeNode root) {
        
        List<TreeNode> inorder = new ArrayList<>();
        
        traverse(root,inorder);
        
        int count = 0;
        TreeNode n1 = null, n2 = null, n3 = null;
        
        for(int i = 0; i < inorder.size()-1; i++){
            
            if(inorder.get(i).val > inorder.get(i+1).val){
                count++;
                if(count == 1){
                    n1 = inorder.get(i);
                    n2 = inorder.get(i+1);
                }else if(count == 2){
                    n3 = inorder.get(i+1);
                }
          }
        }
         
        
         
          if(count == 1){
        
              int temp = n1.val;
              n1.val = n2.val;
              n2.val = temp;
          }else{
              
              int temp = n1.val;
              n1.val = n3.val;
              n3.val = temp;
          }  
            
        }
    }
