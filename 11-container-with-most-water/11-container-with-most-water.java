class Solution {
    public int maxArea(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        
        int ans = Integer.MIN_VALUE;
        
        while(i < j){
            
            int dh = Math.min(arr[i], arr[j]);
            int dw = j-i;
            
            int currVal = dh * dw;
            
            ans = Math.max(ans, currVal);
            
            if(arr[i] < arr[j]){
                i++;
            }else
                j--;
            
        }
        
        return ans;
    }
}