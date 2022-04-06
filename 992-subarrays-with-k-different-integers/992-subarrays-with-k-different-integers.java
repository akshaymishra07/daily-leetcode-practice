class Solution {
    
    //this method will return the number of subarrays that have 
    //at most k distinct integers.
    static int countSubarrays(int nums[] , int k){
     
       
        Map<Integer, Integer> map = new HashMap<>();
        
        int start = 0;
        int end = 0;
        int count = 0; 
        
        while(end < nums.length){
           int num = nums[end];  
           map.put(num , map.getOrDefault(num , 0)+1);
            
            
           while(map.size() > k){
               
               map.put(nums[start], map.get(nums[start])-1);
               
               if(map.get(nums[start]) == 0){
                   map.remove(nums[start]);
               }
               
               start++;
           }
           
           count += end - start + 1; 
           end++; 
        }
      
        return count;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarrays(nums, k) - countSubarrays(nums,k-1);
    }
}