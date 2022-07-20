class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        List<Integer> li = new ArrayList<>();
        int n = nums.length;
        for(int num : nums){
            
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        for(Map.Entry entry : map.entrySet()){
            if((int)entry.getValue() > n/3 ){
                li.add((int) entry.getKey());
            }
        }
        
        return li;
    }
}