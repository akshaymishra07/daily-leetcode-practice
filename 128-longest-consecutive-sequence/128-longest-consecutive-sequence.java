class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int ans = 0;
        
        for(int num : nums){
            
            if(!map.containsKey(num)){
                
                int leftStreak = map.getOrDefault(num-1, 0);
                int rightStreak = map.getOrDefault(num+1, 0);
                
                int l = 1 + rightStreak + leftStreak;
                
                ans = Math.max(ans,l);
            
              map.put(num, l); 
              map.put(num-leftStreak, l); 
              map.put(num+rightStreak,l); 
               
        }
    }
        
        return ans;
    }
}