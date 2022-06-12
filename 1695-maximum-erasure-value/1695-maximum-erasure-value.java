class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        
        for(int end = 0; end < nums.length; end++){
            
            sum += nums[end];
            
            while(map.containsKey(nums[end])){
                sum = sum - nums[start];
                map.remove(nums[start++]);
                
            }
            
            map.put(nums[end], 1);
            ans = Math.max(sum, ans);    
        }
        
        return ans;
    }
}    