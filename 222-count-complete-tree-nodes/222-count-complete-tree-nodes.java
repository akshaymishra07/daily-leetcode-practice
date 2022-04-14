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
    
    static int getHeight(TreeNode root, int ht){
        
        if(root.left  == null){
            return ht;
        }
        
        return getHeight(root.left,ht+1);
    }
    

    static boolean isNullNode(TreeNode root, int maxLc, int nodeNum){
        
        int low = 1;
        int high= maxLc;
        
        while(low < high){
            
            int mid = (low + high)/2;
            
            if(nodeNum <= mid){
                root = root.left;
                high = mid;
            }else{
                root = root.right;
                low = mid+1;
            }
            
            
        }
        
        return root == null;
        
    }
    
    public int countNodes(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int height =  getHeight(root,1);
        
        int maxLeafCount = (int) Math.pow(2,height-1);
        
        int low = 1;
        int high = maxLeafCount;
        int mid = 0;
        int ans = 0;
        
        while(low <= high){
            
            mid = (low+high)/2;
            
            boolean res = isNullNode(root,maxLeafCount,mid);
            
            if(res){
                high = mid - 1;
            }else{
                
                if(mid == maxLeafCount){
                    ans = mid;
                    break;
                }
                
                if(isNullNode(root,maxLeafCount,mid+1)){
                   ans = mid;
                    break;
                    
                }else{
                    low = mid + 1;
                }
            }
            
        }
        
        return ans + maxLeafCount - 1;
    }
}