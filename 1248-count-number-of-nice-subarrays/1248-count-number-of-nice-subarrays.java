class Solution {
    static int countSubarrays(int arr[], int k){
        
        int count = 0;
        int left = 0;
        int right = 0;
        int ans = 0;
        
        while(right < arr.length){
            
            count += arr[right] % 2;
            
            while(left <= right && count > k){
                
                count = count - arr[left++]%2;
                
                
            }
            
            ans += right - left + 1;
            right++;
        }
        
        return ans;
        
    }
    public int numberOfSubarrays(int[] nums, int k) {
        
       return  countSubarrays(nums, k) - countSubarrays(nums, k-1);
        
    }
}