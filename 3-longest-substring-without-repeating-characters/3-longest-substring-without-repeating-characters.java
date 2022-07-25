class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        //we always want to keep the set in a state, such that the incoming character should not be present
        //in the set
 
        int start = 0;
        int ans = 0;
                
        for(int end = 0; end < s.length(); end++){
            
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));          
            }
            
            set.add(s.charAt(end));
            
            ans = Math.max(ans, end - start + 1);
        }
        
        return ans;
    }
}