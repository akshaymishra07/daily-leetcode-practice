class Solution {
    static int dp[] = new int[]{1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public int fib(int n) {
        
        if(n == 0){
            return 0;
        }
        
        if(n == 1 || n == 2 ){
            return 1;
        }
        
        
        if(dp[n] == -1){
            dp[n] = fib(n-1) + fib(n-2);
        }
        
        return dp[n];
    }
}