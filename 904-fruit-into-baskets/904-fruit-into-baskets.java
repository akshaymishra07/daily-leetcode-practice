class Solution {
    public int totalFruit(int[] fruits) {
       
        Map<Integer, Integer> map = new HashMap<>();
        
        int start = 0;
        int ans = 0;
        
        for(int end = 0; end < fruits.length; end++){
            
            map.put(fruits[end], map.getOrDefault(fruits[end],0)+1);
            
            while(map.size() > 2){
                
                map.put(fruits[start],map.get(fruits[start])-1);
                
                if(map.get(fruits[start]) == 0){
                    map.remove(fruits[start]);
                }
                start++;
                
            }
            
            int currentSize = end - start + 1;
            ans = Math.max(ans, currentSize);
            
        }
        
        return ans;
    }
}