class Solution {
    public int totalFruit(int[] fruits) {
        Map <Integer, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int ans = 0;
        
        while(right < fruits.length){
            int num = fruits[right];
            map.put(num , map.getOrDefault(num, 0)+1);
            
            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left])-1);
                    
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }    
                
                left++;
            }
            
            int cans = right - left + 1;
            ans = Math.max(ans, cans);
            right++;
        }
        
        return ans;
    }
}