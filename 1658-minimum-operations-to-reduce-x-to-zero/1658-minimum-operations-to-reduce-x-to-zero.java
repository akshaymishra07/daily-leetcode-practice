class Solution {
    public int minOperations(int[] nums, int x) {
       
        int totalSum = 0;
        
        for(int num : nums){
            totalSum += num;
        }
        
        int sum = 0;
        int start = 0;
        int ans = -1;
        
        for(int end = 0; end < nums.length; end++){
            
            sum += nums[end];
            
            while(sum > totalSum - x && start <= end){
                sum -= nums[start++];
            }
            
            if(sum == totalSum - x){
              ans = Math.max(ans, end-start+1);     
            }
            
            
        }
        
        return ans == -1 ? ans : nums.length - ans;
    }
}

//largest subarray whose sum is totalsum - x;