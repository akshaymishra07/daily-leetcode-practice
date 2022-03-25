class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int res[] = new int[nums.length];
        
        int i = 0;
        int j = nums.length  - 1;
     
        for(int p = res.length - 1; p >= 0; p--){
            
            
            
            if(Math.abs(nums[j]) > Math.abs(nums[i])){
                res[p] = nums[j] * nums[j];
                j--;
            }else{
                res[p] = nums[i] * nums[i];
                i++;
            }
            
        }
        
        return res;
    }
}