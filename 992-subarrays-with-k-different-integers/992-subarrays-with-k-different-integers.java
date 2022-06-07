class Solution {
    
    //function that takes a number k and return number of subarrays
    //that have at most k distinct integers
    
    public static int atMostKDistinct(int arr[], int k){
        
        int ans = 0;
        int s = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int e = 0; e < arr.length; e++){
            
            map.put(arr[e], map.getOrDefault(arr[e], 0)+1);
            
            while(map.size() > k){
                map.put(arr[s], map.get(arr[s])-1);
                if(map. get(arr[s]) == 0){
                    map.remove(arr[s]);
                }    
                
                s++;
            }
                    
            ans += e-s+1;
        }
        
        return ans;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k-1);
    }
}