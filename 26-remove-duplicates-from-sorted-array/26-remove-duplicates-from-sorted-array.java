class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int idx = 0;
        int i = 0;
        
        while(i < nums.length){
            
            int num = nums[i];
            
            while(i < nums.length && nums[i] == num){
                i++;
            }
            
            
            nums[idx++] = num;
        }
        
        return idx;
        
    }
}