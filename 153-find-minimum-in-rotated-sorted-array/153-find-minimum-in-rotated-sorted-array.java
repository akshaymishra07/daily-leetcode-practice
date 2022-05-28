class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        
        if(nums[0] < nums[n-1]){
            return nums[0];
        }
        
        int low = 0;
        int high = n-1;
        int mid;
        int ans = -1;
        while(low <= high){
            
            mid = (low+high)/2;
            
            if(nums[mid] <= nums[n-1]){
                high = mid - 1;
            }
            else{
                
                if(nums[mid] > nums[mid+1]){
                    ans = mid;
                }
                
                low = mid + 1;
            }
        }
        
        return nums[ans+1];
    }
}