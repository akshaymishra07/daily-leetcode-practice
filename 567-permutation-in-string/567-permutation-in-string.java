class Solution {
    
    static boolean validate(int f1[] , int f2[]){
        
        for(int i = 0; i < 26; i++){
            
            if(f1[i] != f2[i]){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        
        int f1[] = new int[26]; //frequency array of the smaller string
        int f2[] = new int[26];
        int k = s1.length();
        for(int i = 0; i < s1.length(); i++){
            
             f1[s1.charAt(i) - 'a']++; 
            
        }
        
        for(int i = 0; i < s2.length(); i++){
            
            f2[s2.charAt(i)-'a']++;
            
            if(i >= k){
                
                f2[s2.charAt(i-k)-'a']--;
            }
            
            if(i >= k-1){
                
                if(validate(f1,f2)){
                     return true;
                }
            }
            
        }
                   
       return false;            
    }
}