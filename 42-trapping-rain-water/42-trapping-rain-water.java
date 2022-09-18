class Solution {
    
    static int[] prefixMax(int[] arr){
        
        int[] prefixMax = new int[arr.length];
        prefixMax[0] = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            
            prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);
        }
        
        return prefixMax;
    }
    
    static int[] suffixMax(int[] arr){
        
        int[] suffixMax = new int[arr.length];
        suffixMax[arr.length-1] = arr[arr.length-1];
        
        for(int i = arr.length-2; i > 0; i--){
            
            suffixMax[i] = Math.max(suffixMax[i+1], arr[i]);
        }
        
        return suffixMax;
    }
    
    public int trap(int[] height) {
        
        int pMax[] = prefixMax(height);
        int sMax[] = suffixMax(height);
        int ans = 0;
        
        for(int i = 1; i < height.length-1; i++){
            
            int decidingHeight = Math.min(pMax[i-1], sMax[i+1]);
            
            if(decidingHeight > height[i]){
                
                ans += (decidingHeight - height[i]);
            }
            
        }
        
        return ans;
    }
}