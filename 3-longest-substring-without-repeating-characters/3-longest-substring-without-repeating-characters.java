class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int ans = 0;
        int start = 0;
        HashSet<Character> set = new HashSet<>();
        
        for(int end = 0; end < s.length();){
            
            if(!set.contains(s.charAt(end))){
                
                ans = Math.max(ans, end-start+1);
                set.add(s.charAt(end));
                end++;
                
            }else{
                
                set.remove(s.charAt(start++));
                
            }
            
            
        }
        
        return ans;
    }
}