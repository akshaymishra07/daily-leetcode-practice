class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
     
        int score = 0;
        int max = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length-1;
        
        while(i <= j){
            
            if(power >= tokens[i]){
                
                power -= tokens[i];
                i++;
                score++;
                max = Math.max(max,score);
            }else if(score >= 1){
                power += tokens[j];
                score--;
                j--;
            }else
                break;
        }
            
         return max;   
    }
}