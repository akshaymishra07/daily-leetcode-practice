class Solution {
    public double findMaxAverage(int[] arr, int k) {
        
        if(arr.length == 1){
            return (double)arr[0];
        }
        
        double ans = Integer.MIN_VALUE;
        double sum = 0.0;
        
        for(int i = 0; i < arr.length; i++){
            
            sum += arr[i];
            
            if(i >= k){
                
                sum = sum - arr[i-k];
                
            }
            
            if(i >= k-1){
                
                int s = i-k+1;
                int e = i;
                
                double avg =  sum / (e-s+1) ; 
                
                ans = Math.max(avg,ans);
             }
        }
        
        return ans;
    }
}