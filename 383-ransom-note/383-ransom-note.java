class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mcount = new int[26];
        int[] rcount = new int[26];
        
        for(int i = 0; i < magazine.length(); i++){
            
            mcount[magazine.charAt(i) - 'a']++;
            
        }
        
        for(int i = 0; i < ransomNote.length(); i++){
            
            rcount[ransomNote.charAt(i) - 'a']++;
            
        }
        
        for(int i = 0; i < 26; i++){
            if(mcount[i] < rcount[i]){
                return false;
            }
        }
        
        return true;
    }
}