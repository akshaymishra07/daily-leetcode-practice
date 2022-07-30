class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int pivot = -1;
        
        while(low <= high){
            
            int mid = (low + high)/2;
            
            if(nums[mid] <= nums[nums.length-1]){
                high = mid - 1;
            }else{
                
                if(nums[mid] > nums[mid+1]){
                    pivot = mid;
                    break;
                }
                low = mid + 1;
            }
        }
        
        return nums[pivot+1];
    }
}