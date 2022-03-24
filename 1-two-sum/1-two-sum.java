class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            
           
                hm.put(nums[i] , i);
            
            
        }
        
        for(int i = 0; i < nums.length; i++){
            
            if(hm.containsKey(target - nums[i]) && hm.get(target - nums[i]) != i){
                
                res[0] = i;
                res[1] = hm.get(target - nums[i]);
                
            }
        }
        
     return res;   
    }
}