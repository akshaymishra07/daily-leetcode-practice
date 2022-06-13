class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int ans = 0;
        int start = 0;
        HashSet<Character> set = new HashSet<>();
        
        for(int end = 0; end < s.length();end++){
            
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }
        
            set.add(s.charAt(end));
            ans = Math.max(ans, end-start+1);      
            
        }
        
        return ans;
    }
}