class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
       
        Arrays.sort(nums);
        
        for(int i = 0; i < n-2; i++){
       
            if (i > 0 && nums[i] == nums[i - 1]) {              
                continue;
             }
            
            
            int low  = i+1;
            int high = n-1;
            
            while(low < high){
                
                if(nums[i] + nums[low] + nums[high] == 0){
                    
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    
                    while(low < high && nums[low] == nums[low-1]){
                        low++;
                    }
                    while(low < high && nums[high] == nums[high+1]){
                        high--;
                    }
                    
                    
                }else if(nums[i] + nums[low] + nums[high] < 0){
                    low++;
                }else
                    high--;
            }
        }
        
        
      return list;    
    }
}