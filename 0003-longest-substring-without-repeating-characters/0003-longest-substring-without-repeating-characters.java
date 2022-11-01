class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        
        if(s.length() == 0){
            return 0;
        }
        
        int start = 0;
        int ans = Integer.MIN_VALUE;
        
        
        for(int end = 0; end < s.length(); end++){
            
            char ch = s.charAt(end);
            
            while(set.contains(ch)){
                set.remove(s.charAt(start));
                start++;
            }
            
            ans = Math.max(ans, end-start+1);
            set.add(ch);
        }
        
        return ans;
    }
}