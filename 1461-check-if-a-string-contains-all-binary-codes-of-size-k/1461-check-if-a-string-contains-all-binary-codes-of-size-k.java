class Solution {
    
    void generateStrings(String str, int k, Set<String> set){
        
        if(str.length() == k){
            
            String s = new String(str);
            set.add(s);
            return;
        }
        
        str += "0";
        generateStrings(str, k, set);
        
        str = str.substring(0,str.length()-1);
        
        str += "1";
        generateStrings(str, k, set);
    }
    
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> got = new HashSet<String>();

        for (int i = k; i <= s.length(); i++) {
            String a = s.substring(i - k, i);
            if (!got.contains(a)) {
                got.add(a);
                need--;
                // return true when found all occurrences
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
        
    }
}