class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        
        for(int num : nums){
            sum += num;
        }
        
        int n = nums.length;
        
        int es =  n * (n+1) / 2;
        
        return es - sum;
    }
}