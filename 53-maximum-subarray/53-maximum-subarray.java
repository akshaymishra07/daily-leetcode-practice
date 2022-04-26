class Solution {
    public int maxSubArray(int[] arr) {
       
        int sum = 0;
        int bestSum = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            
            if(sum >= 0){
                sum += arr[i];
            }else{
                sum = arr[i];
            }
            
            bestSum = Math.max(bestSum, sum);
            
        }
     
        return bestSum;
    }
}