class Solution {
    public int firstUniqChar(String str) {
        
        int[] arr = new int[26];
        
        for(int i = 0; i < str.length(); i++){
                        
            arr[str.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < str.length(); i++){
                        
            if(arr[str.charAt(i) - 'a'] == 1){
             return i;   
            }
        }
        
        
        return -1;   
    }
}