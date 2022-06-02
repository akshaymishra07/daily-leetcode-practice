class Solution {
    public int findKthPositive(int[] arr, int k) {
     
        Set<Integer> set = new HashSet<>();
        
        for(int num : arr){
            set.add(num);
        }
        
        for(int i = 1; i < arr[arr.length-1]; i++){
            
            if(!set.contains(i)){
                k--;
            }
            
            if(k == 0){
                return i;
            }
        }
        
        return arr[arr.length-1]+k;
    }
}