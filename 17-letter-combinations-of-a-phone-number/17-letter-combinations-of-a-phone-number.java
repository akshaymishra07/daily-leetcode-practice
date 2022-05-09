class Solution {
    
    static void printComb(String temp, String digits, int i, List<List<Character>> digitMap , List<String> result){
        
        if(i > digits.length() - 1 ){
            result.add(temp);
            return;
        }
     
        for(int j = 0; j < digitMap.get(digits.charAt(i) - '2').size(); j++){
            printComb( temp + digitMap.get(digits.charAt(i) - '2').get(j),digits,i+1,digitMap,result);
        }
        
    }
    
    public List<String> letterCombinations(String digits) {
       
        List<List<Character>> digitMap = new ArrayList<>();
        List<String> result = new ArrayList<>();
        
        digitMap.add(Arrays.asList(new Character[]{'a','b','c'}));
        digitMap.add(Arrays.asList(new Character[]{'d','e','f'}));
        digitMap.add(Arrays.asList(new Character[]{'g','h','i'}));
        digitMap.add(Arrays.asList(new Character[]{'j','k','l'}));
        digitMap.add(Arrays.asList(new Character[]{'m','n','o'}));
        digitMap.add(Arrays.asList(new Character[]{'p','q','r','s'}));
        digitMap.add(Arrays.asList(new Character[]{'t','u','v'}));
        digitMap.add(Arrays.asList(new Character[]{'w','x','y','z'}));
        
        if(digits.length() == 0){
            return result;
        }
        
        printComb("", digits, 0, digitMap, result);
        
        return result;
    }
}