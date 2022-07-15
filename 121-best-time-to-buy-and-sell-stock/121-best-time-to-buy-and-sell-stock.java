class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        
        for(int num : prices){
            
            if(num < min){
                min = num;
            }else{
               
                int profit = num - min;
                maxProfit = Math.max(profit, maxProfit);
            }   
        }
        
        return maxProfit;
    }
}