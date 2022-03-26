class Solution {
    static int dp[] = new int[]{1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    
    
    public int climbStairs(int n) {
        
        if(n == 0 || n == 1){
            return 1;
        }    
        
        if(dp[n] == -1){
            dp[n] = climbStairs(n-1) + climbStairs(n-2);
        }
        
        return dp[n];
    }
}