class Solution {
    public List<Integer> partitionLabels(String s) {
     
     Map<Character, List<Integer>> map = new HashMap<>();
     
     for(int i = 0; i < s.length(); i++){
         char ch = s.charAt(i);
         if(!map.containsKey(ch)){
             List<Integer> temp = new ArrayList<>(2);
             temp.add(i);
             temp.add(i);
             map.put(ch, temp);
         }else{
             List<Integer> temp = map.get(ch);
             temp.set(1, i);
         }
     }
        
     List<Integer> ans = new ArrayList<>(); 
        
     for(int i = 0; i < s.length(); i++){
         
         int end = i;   
         for(int j = i; j <= end; j++){
            char ch = s.charAt(j); 
            end = Math.max(end, map.get(ch).get(1)); 
         }
         
         ans.add(end-i+1);
         i = end;
     }
       
     return ans;    
  }
}