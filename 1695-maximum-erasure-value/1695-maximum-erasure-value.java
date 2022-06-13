class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int ans = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int start = 0;
        
        for(int end = 0; end < nums.length; end++){
            
            while(set.contains(nums[end])){
                sum = sum - nums[start];
                set.remove(nums[start++]);
                
            }
            
            set.add(nums[end]);
            sum += nums[end];
            ans = Math.max(sum, ans);    
        }
        
        return ans;
    }
}    