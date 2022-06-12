class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        //largest subarray with distinct characters

        int sum = 0;
        int start = 0;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int end = 0; end < nums.length;){
            
            if(!set.contains(nums[end])){
                
                sum += nums[end];
                ans = Math.max(ans,sum);
                set.add(nums[end]);
                end++;
                
            }else{
                
                sum -= nums[start];
                set.remove(nums[start++]);
                
            }
            
        }
        
        return ans;
    }
}