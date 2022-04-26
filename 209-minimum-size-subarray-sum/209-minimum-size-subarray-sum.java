class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int start = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int end = 0; end < nums.length; end++){
            
            if(nums[end] == target){
                return 1;
            }
            
            sum += nums[end];
            
            while(sum >= target){
                 ans = Math.min(ans, end-start+1);  
                sum = sum - nums[start];
                start++;
            }
            
            
               
            
            
            
        }
        
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}