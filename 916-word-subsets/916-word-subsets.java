class Solution {
    
    static boolean validate(int arr1[], int arr2[]){
        
        for(int i = 0; i < arr1.length; i++){
            if(arr2[i] > arr1[i] ){
                return false;
            }
        }
        
        return true;
    }
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> ans = new ArrayList<>();
        int[] countMax = new int[26];
        
        for(String s : words2){
            int[] count = new int[26];
            for(int j = 0; j < s.length(); j++){
                count[s.charAt(j) - 'a']++;
            }
            
            for(int i = 0; i < 26; i++){
                countMax[i] = Math.max(countMax[i], count[i]);
            }
        }
        
        for(String s1 : words1){
          
           int[] count = new int[26];
            
            for(int i = 0; i < s1.length(); i++){
                count[s1.charAt(i) - 'a']++;
            }
            
            if(validate(count, countMax)){
                ans.add(s1);
            }
        }
        
        return ans;
    }
}