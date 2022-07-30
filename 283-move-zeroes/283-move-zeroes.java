class Solution {
    public void moveZeroes(int[] nums) {
        int id = 0;
        int i = 0;
        while(i < nums.length){
            
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[id];
                nums[id] = temp;
                id++;
            }
            
            i++;
        }
    }
}