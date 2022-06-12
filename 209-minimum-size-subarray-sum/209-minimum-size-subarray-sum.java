class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        
        for(int end = 0; end < nums.length; end++){
            
            sum += nums[end];
            
            while(sum >= k){
                
                ans = Math.min(ans,end-start+1);
                sum = sum - nums[start++];
                
            }
            
            
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}