class Pair{
    
    int x ;
    int y ;
    
    Pair(int x, int y){
        
        this.x = x;
        this.y = y;
    }
    
}

class Solution {
    
     static boolean isValid(int x, int y, int m, int n){
         
         return x >= 0 && x < m && y >= 0 && y < n;         
    }
    
    public int orangesRotting(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        
        Queue<Pair> q = new LinkedList<>();
        
        int[] xmoves = new int[]{1 , -1 , 0 , 0};
        int[] ymoves = new int[]{0 , 0 , 1 , -1};
        
        int freshCount = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               if(mat[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                
                if(mat[i][j] == 1){
                    freshCount++;
                }
            }
        }
        
        if(freshCount == 0){
            return 0;
        }
        
        int min = -1;
         
        while(!q.isEmpty()){
            
            int nums = q.size();
          
            while(nums-- > 0){
                
                Pair curr = q.poll();
                
                for(int k = 0 ; k < xmoves.length; k++){
                    
                    int x = curr.x + xmoves[k];
                    int y = curr.y + ymoves[k];
                    
                    if(!isValid(x,y,m,n)){
                        continue;
                    }    
                    
                    if(mat[x][y] == 1){
                       freshCount--; 
                       mat[x][y] = 2;
                       q.add(new Pair(x,y));

                 }
                }
            }
            min++;
        }  
        
       return freshCount == 0 ? min : -1;
    }
}